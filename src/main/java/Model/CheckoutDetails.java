package Model;

import java.time.LocalDate;

/**
 * Class containing the details for the checkout.
 */
final public class CheckoutDetails {

    private final int daysRented;
    private final int discountPercent;
    private final LocalDate checkoutDate;

    /**
     * Constructor assigning the passed in checkout details.
     *
     * @param daysRented int amount of days the customer rents the tool
     * @param discountPercent int percentage discount for the total cost of the rental
     * @param checkoutDate LocalDate date the tool is checked out
     */
    public CheckoutDetails(final int daysRented, final int discountPercent, final LocalDate checkoutDate) {
        this.daysRented = daysRented;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    /**
     * @return int amount of days the customer rents the tool
     */
    public int getDaysRented() {
        return daysRented;
    }

    /**
     * @return int percentage discount for the total cost of the rental
     */
    public int getDiscountPercent() {
        return discountPercent;
    }

    /**
     * @return LocalDate date the tool is checked out
     */
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }
}
