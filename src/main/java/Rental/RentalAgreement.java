package Rental;

import Model.CheckoutDetails;
import Model.Tool;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

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
        preDiscountCharge = calculatePreDiscountCharge();
        discountAmount = calculateDiscountAmount();
        finalCharge = calculateFinalCharge();
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

    private double calculatePreDiscountCharge() {
        return 1;
    }

    private double calculateDiscountAmount() {
        return 1;
    }

    private double calculateFinalCharge() {
        return 1;
    }

    public void print() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/uu");
    }
}
