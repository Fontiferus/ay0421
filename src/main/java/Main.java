import Model.Tool;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static final PrintStream output = System.out;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean shouldContinue;
        do {
            HashSet<String> toolCodesSet = createToolCodeSet();
            output.print("Enter the code for the tool being rented: ");
            String toolCode = input.nextLine();
            while (!toolCodesSet.contains(toolCode)) {
                output.print("Tool code entered is not valid. Please enter a valid tool code: ");
                toolCode = input.nextLine();
            }
            output.println("Tool Code entered: " + toolCode);

            Tool tool = new Tool(toolCode);

            int daysRented = 0;
            do {
                try {
                    output.print("Enter how many days the customer will rent the tool: ");
                    daysRented = input.nextInt();
                    if (daysRented < 1) {
                        throw new Exception("Days rented must be 1 or greater.");
                    }
                }
                catch (Exception exception) {
                    output.println(exception.getMessage());
                }
            } while (daysRented < 1);
            output.println("Days Rented: " + daysRented);

            int discountPercent = -1;
            do {
                try {
                    output.print("Enter the percentage discount of the rental: ");
                    discountPercent = input.nextInt();
                    input.nextLine(); //to take in the new line
                    if (discountPercent < 0 || discountPercent > 100) {
                        throw new Exception("The discount must be between 0 and 100.");
                    }
                }
                catch (Exception exception) {
                    output.println(exception.getMessage());
                }
            } while (discountPercent < 0 || discountPercent > 100);
            output.println("Percentage discount: " + discountPercent + "%");

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/uu");
            LocalDate checkoutDate = null;
            boolean hasEnteredDate;
            do {
                output.print("Enter the date the tool is checked out (mm/dd/yy): ");
                try {
                    checkoutDate = LocalDate.parse(input.nextLine(), dateFormat);
                    hasEnteredDate = true;
                }
                catch (Exception exception) {
                    output.println("Date was not entered correctly.");
                    hasEnteredDate = false;
                }
            } while (!hasEnteredDate);
            output.println("Date entered: " + checkoutDate.format(dateFormat));

            output.print("Is there another tool to rent? (Y/N) ");
            String answer = input.nextLine();
            shouldContinue = answer.equals("Y");
        } while (shouldContinue);
    }

    private static HashSet<String> createToolCodeSet() {
        HashSet<String> toolCodes = new HashSet<>();
        toolCodes.add("LADW");
        toolCodes.add("CHNS");
        toolCodes.add("JAKR");
        toolCodes.add("JAKD");
        return toolCodes;
    }
}
