package Model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutDetailsTest {

    @Test
    public void testConstructor() {
        LocalDate checkoutDate = LocalDate.of(2021, 4, 13);
        CheckoutDetails checkoutDetails = new CheckoutDetails(5, 20, checkoutDate);
        assertEquals(5, checkoutDetails.getDaysRented());
        assertEquals(20, checkoutDetails.getDiscountPercent());
        assertEquals(checkoutDate, checkoutDetails.getCheckoutDate());
    }
}
