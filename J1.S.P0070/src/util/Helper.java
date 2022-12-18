package util;

import static constant.IConstant.RANDOM_CAPTCHA;
import java.util.Random;

public class Helper {

    /**
     * Don't let anyone instantiate this class.
     */
    private Helper() {
    }

    /**
     * Print the menu
     */
    public static void menu() {
        System.out.println("\n------------Login Program--------------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    /**
     * Return generate captcha.
     *
     * @return the string value is captcha.
     */
    public static String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();
        Random R = new Random();
        String s = RANDOM_CAPTCHA;
        for (int i = 0; i < 5; i++) {
            int a = R.nextInt(s.length());
            captcha.append(s.charAt(a));
        }
        return captcha.toString().trim();
    }
}
