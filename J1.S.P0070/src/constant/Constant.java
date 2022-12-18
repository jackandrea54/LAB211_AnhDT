package constant;

public class Constant {

    public static final String REGEX_ACCOUNT_NUMBER = "^[0-9]{10}$";
    public static final String REGEX_PASSWORD = "^((?=.*\\d)(?=.*[a-zA-Z]).{8,31})$";
    public static final String REGEX_CAPTCHA = "^[0-9A-Za-z]{1}$";
    public static final String RANDOM_CAPTCHA = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static final int    EXIT_INDEX = -1;
}
