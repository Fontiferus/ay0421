package Model;

/**
 * Class containing the tool's info
 */
final public class Tool {

    private final String toolCode;
    private String brand;
    private String toolType;
    private double dailyCharge;
    private boolean hasWeekendCharge;
    private boolean hasHolidayCharge;

    /**
     * Constructor to assign the tool's details based on the tool code
     *
     * @param toolCode String unique code of the tool
     */
    public Tool(final String toolCode) {
        this.toolCode = toolCode;
        switch (toolCode) {
            case "LADW":
                toolType = "Ladder";
                brand = "Werner";
                dailyCharge = 1.99;
                hasWeekendCharge = true;
                hasHolidayCharge = false;
                break;
            case "CHNS":
                toolType = "Chainsaw";
                brand = "Stihl";
                dailyCharge = 1.49;
                hasWeekendCharge = false;
                hasHolidayCharge = true;
                break;
            case "JAKR":
                toolType = "Jackhammer";
                brand = "Ridgid";
                dailyCharge = 2.99;
                hasWeekendCharge = false;
                hasHolidayCharge = false;
                break;
            case "JAKD":
                toolType = "Jackhammer";
                brand = "DeWalt";
                dailyCharge = 2.99;
                hasWeekendCharge = false;
                hasHolidayCharge = false;
                break;
        }
    }

    /**
     * @return String unique code of the tool
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * @return String brand of the tool
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return String type of tool
     */
    public String getToolType() {
        return toolType;
    }

    /**
     * @return double daily charge of renting the tool
     */
    public double getDailyCharge() {
        return dailyCharge;
    }

    /**
     * @return boolean true if the tool charges on the weekend, false otherwise
     */
    public boolean hasWeekendCharge() {
        return hasWeekendCharge;
    }

    /**
     * @return boolean true if the tool charges on holidays, false otherwise
     */
    public boolean hasHolidayCharge() {
        return hasHolidayCharge;
    }
}
