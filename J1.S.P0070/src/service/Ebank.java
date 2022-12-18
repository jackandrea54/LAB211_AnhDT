/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Random;
import java.util.ResourceBundle;
import constant.Constant;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Ebank {

    /**
     * Check user's login details
     * 
     * @param resourceBundle determine which language will be using
     * @return {@code true} if user's login details are correct, return {@code false}
     *                      otherwise.
     */
    public boolean checkLogin(ResourceBundle resourceBundle) {
        //Nhap account
        String account = Validation.getString(
                resourceBundle.getString("account"),
                resourceBundle.getString("accountInvalid"),
                Constant.REGEX_ACCOUNT_NUMBER
        );
        
        //Nhap password
        String password = Validation.getString(
                resourceBundle.getString("password"),
                resourceBundle.getString("passwordInvalid"),
                Constant.REGEX_PASSWORD
        );

        //Nhap captcha
        boolean isPass = false;
        do {            
            String captcha = generateCaptcha(5);
            System.out.println(resourceBundle.getString("captcha") + ": " + captcha);
            String captchaInput = Validation.getString(
                    resourceBundle.getString("inputCaptcha"),
                    resourceBundle.getString("captchaInvalid"),
                    Constant.REGEX_CAPTCHA);
            if (captcha.contains(captchaInput)) {
                isPass = true;
            }else{
               System.out.println(resourceBundle.getString("captchaIncorrect")); 
            }
        } while (!isPass);
        
        return isPass;
    }

    /**
     * Generate a random Captcha string with length of user's input
     * 
     * @param length of the Captcha string
     * @return A random Captcha string
     */
    public String generateCaptcha(int length) {
        String captcha = "";
        Random R = new Random();
        for (int i = 0; i < length; i++) {
            int index = R.nextInt(Constant.RANDOM_CAPTCHA.length());
            captcha += Constant.RANDOM_CAPTCHA.charAt(index);
        }
        return captcha;
    }

//    /**
//     * Check user's input for Captcha character
//     * 
//     * @param messageInfo                display the message info
//     * @param messageErrorInvalidCaptcha display when user's input invalid character
//     * @param messageErrorWrongCaptcha   display when user's input incorrect Captcha character
//     * @param captchaString              the Captcha String   
//     * @return {@code true} when user input the correct Captcha character
//     */
//    public boolean checkCaptcha(
//            String messageInfo,
//            String messageErrorInvalidCaptcha,
//            String messageErrorWrongCaptcha,
//            String captchaString    
//    ) {
//        do {
//            String captchaInput = Validation.getString(
//                    messageInfo,
//                    messageErrorInvalidCaptcha,
//                    Constant.REGEX_CAPTCHA);
//            if (captchaString.contains(captchaInput)) {
//                return true;
//            }
//            System.out.println(messageErrorWrongCaptcha);
//        } while (true);
//    }
}
