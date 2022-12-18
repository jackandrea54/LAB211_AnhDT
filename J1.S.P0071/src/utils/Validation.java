package utils;

import java.util.Scanner;

public class Validation {

    /**
     * Don't let anyone instantiate this class.
     */
    private Validation(){
    }
    
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Input a number integer
     *
     * @param messageInfo               display when user input
     * @param messageErrorOutOfRange    display when user input out of range
     * @param messageErrorInvalidNumber display when user input an invalid number
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the integer value
     */
    public static int getInteger(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min,
            int max
    ) {
        int number;
        while (true) {
            try {
                System.out.print(messageInfo);
                number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.err.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.err.println(messageErrorInvalidNumber);
            }
        }
    }
    
    /**
     * Input a number double
     *
     * @param messageInfo               display when user input
     * @param messageErrorOutOfRange    display when user input out of range
     * @param messageErrorInvalidNumber display when user input an invalid number
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the double value
     */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min,
            double max
    ) {
        double number;
        while (true) {
            try {
                System.out.print(messageInfo);
                number = Double.parseDouble(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.err.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.err.println(messageErrorInvalidNumber);
            }
        }
    }

    /**
     * Input a String
     *
     * @param messageInfo  display the message info
     * @param messageError display when user input doesn't match the defined format
     * @param REGEX        the pattern to test string is valid or not
     * @return the string value
     */
    public static String getString(
            String messageInfo, 
            String messageError, 
            String REGEX
    ) {
        do {
            System.out.print(messageInfo);
            String str = scanner.nextLine().trim();
            if (str.matches(REGEX)) {
                return str;
            }
            System.err.println(messageError);
        } while (true);
    }
}
