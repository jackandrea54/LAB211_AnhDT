package mock;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Account> listAccount = new ArrayList<Account>() {
        {
            add(new Account("1550002332", "1234xxx89FF"));
            add(new Account("1550002333", "abc444xxx888F"));
            add(new Account("1550002334", "1234xxx567xX"));
            add(new Account("1550002335", "abcxxx11u4uX"));
        }
    };
}
