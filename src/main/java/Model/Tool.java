package Model;

final public class Tool {

    private final String toolCode;
    private String brand;
    private String toolType;
    private double dailyCharge;
    private boolean hasWeekendCharge;
    private boolean hasHolidayCharge;

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

    public String getToolCode() {
        return toolCode;
    }

    public String getBrand() {
        return brand;
    }

    public String getToolType() {
        return toolType;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean hasWeekendCharge() {
        return hasWeekendCharge;
    }

    public boolean hasHolidayCharge() {
        return hasHolidayCharge;
    }
}
