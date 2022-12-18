package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Validation {

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
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min,
            int max) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print(messageInfo);
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
}
