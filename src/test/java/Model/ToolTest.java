package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToolTest {

    @Test
    public void testConstructorLADW() {
        Tool tool = new Tool("LADW");
        assertEquals("LADW", tool.getToolCode());
        assertEquals("Ladder", tool.getToolType());
        assertEquals("Werner", tool.getBrand());
        assertEquals(1.99, tool.getDailyCharge());
        assertTrue(tool.hasWeekendCharge());
        assertFalse(tool.hasHolidayCharge());
    }

    @Test
    public void testConstructorCHNS() {
        Tool tool = new Tool("CHNS");
        assertEquals("CHNS", tool.getToolCode());
        assertEquals("Chainsaw", tool.getToolType());
        assertEquals("Stihl", tool.getBrand());
        assertEquals(1.49, tool.getDailyCharge());
        assertFalse(tool.hasWeekendCharge());
        assertTrue(tool.hasHolidayCharge());
    }

    @Test
    public void testConstructorJAKR() {
        Tool tool = new Tool("JAKR");
        assertEquals("JAKR", tool.getToolCode());
        assertEquals("Jackhammer", tool.getToolType());
        assertEquals("Ridgid", tool.getBrand());
        assertEquals(2.99, tool.getDailyCharge());
        assertFalse(tool.hasWeekendCharge());
        assertFalse(tool.hasHolidayCharge());
    }

    @Test
    public void testConstructorJAKD() {
        Tool tool = new Tool("JAKD");
        assertEquals("JAKD", tool.getToolCode());
        assertEquals("Jackhammer", tool.getToolType());
        assertEquals("DeWalt", tool.getBrand());
        assertEquals(2.99, tool.getDailyCharge());
        assertFalse(tool.hasWeekendCharge());
        assertFalse(tool.hasHolidayCharge());
    }
}
