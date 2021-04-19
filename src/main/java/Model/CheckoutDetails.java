package Model;

import java.time.LocalDate;

final public class CheckoutDetails {

    private final int daysRented;
    private final int discountPercent;
    private final LocalDate checkoutDate;

    public CheckoutDetails(final int daysRented, final int discountPercent, final LocalDate checkoutDate) {
        this.daysRented = daysRented;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }
}
