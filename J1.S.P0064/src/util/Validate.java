package util;

import java.util.Scanner;

public class Validate {

    public static Scanner scanner = new Scanner(System.in);
    /**
     * Format number.
     */
    public static final String REGEX_NUMBER = "^\\d+$";
    /**
     * Format Email.
     */
    public static final String REGEX_EMAIL = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    /**
     * Format date.
     */
    public static final String REGEX_DATE = 
            "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
                    + "(?:(?:29|30)(\\/|-|\\.)"
                    + "(?:0?[1,3-9]|1[0-2])\\2))"
                    + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"
                    + "|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)"
                    + "?(?:0[48]|[2468][048]|[13579][26])|"
                    + "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]"
                    + "|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])"
                    + "|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    private Validate() {
    }

    /**
     * Returns an input string from the keyboard.
     *
     * @param messageInfo  message info
     * @param REGEX        the pattern to test string is valid or not
     * @param messageError message error
     * @return the string value
     */
    public static String getString(String messageInfo, String messageError, final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = scanner.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}
