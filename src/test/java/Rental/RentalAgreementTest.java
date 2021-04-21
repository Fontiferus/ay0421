package Rental;

import Model.CheckoutDetails;
import Model.Tool;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalAgreementTest {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/uu");
    NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

    @Test
    public void testPrint_LADW() {
        Tool tool = new Tool("LADW");
        int discountPercent = 10;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 7, 6);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_LADW_WeekendCharge() {
        Tool tool = new Tool("LADW");
        int discountPercent = 10;
        int daysRented = 5;
        int daysCharged = 5;
        LocalDate localDate = LocalDate.of(2020, 7, 10);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_LADW_HolidayCharge_IndependenceDay() {
        Tool tool = new Tool("LADW");
        int discountPercent = 10;
        int daysRented = 3;
        int daysCharged = 2;
        LocalDate localDate = LocalDate.of(2015, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_LADW_HolidayCharge_LaborDay() {
        Tool tool = new Tool("LADW");
        int discountPercent = 10;
        int daysRented = 5;
        int daysCharged = 4;
        LocalDate localDate = LocalDate.of(2020, 9, 4);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_CHNS() {
        Tool tool = new Tool("CHNS");
        int discountPercent = 25;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 7, 6);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_CHNS_WeekendCharge() {
        Tool tool = new Tool("CHNS");
        int discountPercent = 25;
        int daysRented = 5;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_CHNS_HolidayCharge_IndependenceDay() {
        Tool tool = new Tool("CHNS");
        int discountPercent = 25;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2019, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_CHNS_HolidayCharge_LaborDay() {
        Tool tool = new Tool("CHNS");
        int discountPercent = 25;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 9, 6);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKR() {
        Tool tool = new Tool("JAKR");
        int discountPercent = 0;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 7, 6);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKR_WeekendCharge() {
        Tool tool = new Tool("JAKR");
        int discountPercent = 0;
        int daysRented = 5;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 9, 11);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKR_HolidayCharge_IndependenceDay() {
        Tool tool = new Tool("JAKR");
        int discountPercent = 0;
        int daysRented = 6;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2015, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKR_HolidayCharge_IndependenceDay2020() {
        Tool tool = new Tool("JAKR");
        int discountPercent = 50;
        int daysRented = 4;
        int daysCharged = 1;
        LocalDate localDate = LocalDate.of(2020, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKR_HolidayCharge_LaborDay() {
        Tool tool = new Tool("JAKR");
        int discountPercent = 50;
        int daysRented = 6;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 9, 3);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKD() {
        Tool tool = new Tool("JAKD");
        int discountPercent = 0;
        int daysRented = 3;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 7, 6);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKD_WeekendCharge() {
        Tool tool = new Tool("JAKD");
        int discountPercent = 0;
        int daysRented = 5;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 9, 11);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKD_HolidayCharge_IndependenceDay() {
        Tool tool = new Tool("JAKD");
        int discountPercent = 0;
        int daysRented = 6;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2015, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKD_HolidayCharge_IndependenceDay2020() {
        Tool tool = new Tool("JAKD");
        int discountPercent = 50;
        int daysRented = 4;
        int daysCharged = 1;
        LocalDate localDate = LocalDate.of(2020, 7, 2);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }

    @Test
    public void testPrint_JAKD_HolidayCharge_LaborDay() {
        Tool tool = new Tool("JAKD");
        int discountPercent = 50;
        int daysRented = 6;
        int daysCharged = 3;
        LocalDate localDate = LocalDate.of(2020, 9, 3);
        CheckoutDetails checkoutDetails = new CheckoutDetails(daysRented, discountPercent, localDate);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, checkoutDetails);
        double preDiscount = tool.getDailyCharge() * daysCharged;
        double discount = ((double) Math.round(preDiscount * discountPercent)) / 100;
        BigDecimal finalCharge = new BigDecimal(Double.toString(preDiscount)).subtract(new BigDecimal(Double.toString(discount)));
        String expected = "Rental Agreement: " +
                "\n\nTool code: " + tool.getToolCode() +
                "\n\nTool type: " + tool.getToolType() +
                "\n\nTool brand: " + tool.getBrand() +
                "\n\nRental days: " + daysRented +
                "\n\nCheck out date: " + localDate.format(dateFormat) +
                "\n\nDue date: " + localDate.plusDays(daysRented).format(dateFormat) +
                "\n\nDaily rental charge: " + dollarFormat.format(tool.getDailyCharge()) +
                "\n\nCharge days: " + daysCharged +
                "\n\nPre-discount charge: " + dollarFormat.format(preDiscount) +
                "\n\nDiscount percent: " + discountPercent + "%" +
                "\n\nDiscount amount: " + dollarFormat.format(discount) +
                "\n\nFinal charge: " + dollarFormat.format(finalCharge);
        assertEquals(expected, rentalAgreement.print());
    }
}
