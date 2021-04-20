package Rental;

import Model.CheckoutDetails;
import Model.Tool;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class RentalAgreement {

    private final Tool tool;
    private final CheckoutDetails checkoutDetails;
    private final LocalDate dueDate;
    private final int chargedDays;
    private final double preDiscountCharge;
    private final double discountAmount;
    private final double finalCharge;

    public RentalAgreement(final Tool tool, final CheckoutDetails checkoutDetails) {
        this.tool = tool;
        this.checkoutDetails = checkoutDetails;
        dueDate = checkoutDetails.getCheckoutDate().plusDays(checkoutDetails.getDaysRented());
        chargedDays = calculateChargedDays();
        preDiscountCharge = chargedDays * tool.getDailyCharge();
        discountAmount = ((double) Math.round(preDiscountCharge * checkoutDetails.getDiscountPercent())) / 100;
        finalCharge = preDiscountCharge - discountAmount;
    }

    private int calculateChargedDays() {
        int finalChargedDays = checkoutDetails.getDaysRented();
        if (!tool.hasWeekendCharge()) {
            for (LocalDate date = checkoutDetails.getCheckoutDate().plusDays(1); !date.isAfter(dueDate); date = date.plusDays(1)) {
                if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    finalChargedDays--;
                }
            }
        }
        if (!tool.hasHolidayCharge()) {
            LocalDate independenceDay = LocalDate.of(dueDate.getYear(), 7, 4);
            LocalDate laborDay = LocalDate.of(dueDate.getYear(), 9, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
            if ((independenceDay.isAfter(checkoutDetails.getCheckoutDate()) && independenceDay.isBefore(dueDate)) || independenceDay.isEqual(dueDate)) {
                finalChargedDays--;
            }
            if ((laborDay.isAfter(checkoutDetails.getCheckoutDate()) && laborDay.isBefore(dueDate)) || laborDay.isEqual(dueDate)) {
                finalChargedDays--;
            }
        }
        return finalChargedDays;
    }

    public void print() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/uu");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        System.out.println("Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + checkoutDetails.getDaysRented() +
                "\n\nCheck out date: " + checkoutDetails.getCheckoutDate().format(dateFormat) +
                "\n\nDue date: " + dueDate.format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + chargedDays +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscountCharge) +
                "\n\nDiscount percent: " + checkoutDetails.getDiscountPercent() + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discountAmount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge));
    }
}
