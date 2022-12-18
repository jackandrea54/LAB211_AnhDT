package constant;

public class IConstant {

    public static final String REGEX_ACCOUNT_NUMBER = "^[0-9]{10}$";
    public static final String REGEX_PASSWORD = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,31})$";
    public static final String REGEX_CAPTCHA = "^[0-9A-Za-z]{1}$";
    public static final String RANDOM_CAPTCHA = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String ACCOUNT_TEXT = "account";
    public static final String PASSWORD_TEXT = "password";
    public static final String CAPTCHA_TEXT = "captcha";
    public static final String INPUT_CAPTCHA_TEXT = "inputCaptcha";
    public static final String ACCOUNT_INVALID_TEXT = "accountInvalid";
    public static final String PASSWORD_INVALID_TEXT = "passwordInvalid";
    public static final String CAPTCHA_INCORRECT_TEXT = "captchaIncorrect";
    public static final String CAPTCHA_INVALID_TEXT = "captchaInvalid";
    public static final String LOGIN_SUCCESS_TEXT = "loginSuccess";
    public static final String LOGIN_FAILED_TEXT = "loginFailed";
}
