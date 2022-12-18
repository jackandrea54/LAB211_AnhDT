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
                System.out.print(messageInfo);
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
}
