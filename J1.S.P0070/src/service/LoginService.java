package service;

import constant.IConstant;
import entity.Account;
import java.util.ResourceBundle;
import mock.Data;
import util.Helper;
import util.Validation;

public class LoginService {
    
    public void LoginProcess(ResourceBundle resourceBundle) {
        //get account info ~ account and password
        String account = Validation.getString(
                resourceBundle.getString(IConstant.ACCOUNT_TEXT),
                resourceBundle.getString(IConstant.ACCOUNT_INVALID_TEXT),
                IConstant.REGEX_ACCOUNT_NUMBER
        );
        String password = Validation.getString(
                resourceBundle.getString(IConstant.PASSWORD_TEXT),
                resourceBundle.getString(IConstant.PASSWORD_INVALID_TEXT),
                IConstant.REGEX_PASSWORD
        );
        // generate captcha
        String captchaGenerate = Helper.generateCaptcha();
        System.out.println(resourceBundle.getString(IConstant.CAPTCHA_TEXT)
                + captchaGenerate);
        //verify captcha
        boolean isPass = verifyCaptcha(
                resourceBundle.getString(IConstant.INPUT_CAPTCHA_TEXT),
                resourceBundle.getString(IConstant.CAPTCHA_INVALID_TEXT),
                resourceBundle.getString(IConstant.CAPTCHA_INCORRECT_TEXT),
                captchaGenerate
        );
        // verify account info login
        if (isPass && authentication(account, password)) {
            System.out.println(resourceBundle.getString(IConstant.LOGIN_SUCCESS_TEXT));
        } else {
            System.out.println(resourceBundle.getString(IConstant.LOGIN_FAILED_TEXT));
        }
    }

    /**
     *
     * @param mesageInfo
     * @param messageErrorInvalidCaptcha
     * @param messageErrorWrongCaptcha
     * @param captchaGenerate
     * @return
     */
    private boolean verifyCaptcha(
            String mesageInfo,
            String messageErrorInvalidCaptcha,
            String messageErrorWrongCaptcha,
            String captchaGenerate
    ) {
        String captchaInput;
        do {
            captchaInput = Validation.getString(mesageInfo,
                    messageErrorInvalidCaptcha,
                    IConstant.REGEX_CAPTCHA);
            if (captchaGenerate.contains(captchaInput)) {
                return true;
            }
            System.out.println(messageErrorWrongCaptcha);
        } while (true);
    }

    private boolean authentication(String account, String password) {
        for (Account a : Data.listAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
