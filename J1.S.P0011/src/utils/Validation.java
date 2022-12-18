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
     * input a number integer
     *
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @param messageInfo               display when user input
     * @param messageErrorOutOfRange    display when user input out of range
     * @param messageErrorInvalidNumber display when user input an invalid number
     * @return the integer value
     */
    public static int getInteger(
            int min,
            int max,
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber
    ) {
        int number;
        while (true) {
            try {
                System.out.println(messageInfo);
                number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        }
    }

    /**
     * Returns an input string from the keyboard.
     *
     * @param messageInfo  message info
     * @param messageError message error
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
