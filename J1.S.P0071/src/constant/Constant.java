/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author ADMIN
 */
public class Constant {
    public static final String NAME_REGEX = "^[a-zA-Z\\s]*$";
    public static final int EXIT_INDEX = -1;
    public static final String DATE_REGEX = 
      "^(29-02-(2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26])))$" 
      + "|^((0[1-9]|1[0-9]|2[0-8])-02-((19|2[0-9])[0-9]{2}))$"
      + "|^((0[1-9]|[12][0-9]|3[01])-(0[13578]|10|12)-((19|2[0-9])[0-9]{2}))$" 
      + "|^((0[1-9]|[12][0-9]|30)-(0[469]|11)-((19|2[0-9])[0-9]{2}))$";
}
