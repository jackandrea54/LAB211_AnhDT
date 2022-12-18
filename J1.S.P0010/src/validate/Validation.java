/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Validation {
    private final static Scanner SCANNER = new Scanner(System.in);
    
    /**
     * Enter integer in range from min to max
     * 
     * @param messageInfo               is message info of number want to input
     * @param messageErrorOutOfRange    is message error if number input out of range
     * @param messageErrorInvalidNumber is error if input is invalid number
     * @param min                       is minimum value
     * @param max                       is maximum value
     * @return  integer in range min and max 
     */
    public static int getInt(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        do {
            try {
                System.out.println(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <=max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    /**
     * Get a string with provided form
     * 
     * @param messageInfo               is message info of String want to input
     * @param messageErrorInvalidString is error if input is invalid String
     * @param REGEX                     is String to valid input
     * @return a String with exact form
     */
    public static String getString(String messageInfo,
            String messageErrorInvalidString,
            final String REGEX) {
        do {
            try {
                System.out.println(messageInfo);
                String inputString = SCANNER.nextLine().trim();
                if (inputString.matches(REGEX)){
                    return inputString;
                }
                System.out.println(messageErrorInvalidString);
            } catch (Exception e) {
                System.out.println(messageErrorInvalidString);
            }
        } while (true);
    }
}
