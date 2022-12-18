package bo;

import java.util.Scanner;
import util.Validate;

public class Validator {

    public String getPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Phone number: ");
            String str = scanner.nextLine();
            if (str.length() == 10) {
                if (str.matches(Validate.REGEX_NUMBER)) {
                    return str;
                } else {
                    System.out.println("Phone number must is number");
                }
            } else {
                System.out.println("Phone number must be 10 digits");
            }
        } while (true);
    }
    public String getEmail() {
        return Validate.getString(
                "Email: ", 
                "Email must is correct format.", 
                Validate.REGEX_EMAIL
        );
    }
    public String getDate() {
        return Validate.getString(
                "Date: ", 
                "Date to correct format (dd/mm/yyyy).", 
                Validate.REGEX_DATE
        );
    }
}
