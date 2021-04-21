package ConsoleIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToolCheckoutTest {
    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void teardown() {
        outContent = null;
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testWrongToolCode() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WrongToolCode.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        assertTrue(outContent.toString().contains("Tool code entered is not valid. Please enter a valid tool code: "));
    }

    @Test
    public void testDaysRentedIsZero() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DaysRentedIsZero.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        assertTrue(outContent.toString().contains("Days rented must be 1 or greater."));
    }

    @Test
    public void testDiscountPercent_LessThanZero() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DiscountPercentLessThanZero.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        assertTrue(outContent.toString().contains("The discount must be between 0 and 100."));
    }

    @Test
    public void testDiscountPercent_GreaterThan100() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DiscountPercentGreaterThan100.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        assertTrue(outContent.toString().contains("The discount must be between 0 and 100."));
    }

    @Test
    public void testIncorrectDateFormat() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("IncorrectDateFormat.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        assertTrue(outContent.toString().contains("Date was not entered correctly."));
    }

    @Test
    public void testEnterAnotherTool() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("EnterAnotherTool.txt");
        System.setIn(inputStream);
        new ToolCheckout().start();
        // Confirms the system asked for another tool because 1st run had all correct inputs, second run had a wrong tool code.
        assertTrue(outContent.toString().contains("Tool code entered is not valid. Please enter a valid tool code:"));
    }
}
