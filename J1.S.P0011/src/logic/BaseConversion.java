package logic;

import constant.Constant;
import utils.Validation;

public class BaseConversion {

    /**
     * Convert input number to decimal base
     *
     * @param inputNumber input number
     * @param inBase      input base
     * @return number in decimal base
     */
    public int convertToDec(String inputNumber, int inBase) {
        int decNum = 0;
        int decBase = 1;
        for (int i = inputNumber.length()-1; i >= 0; i--) {
            switch (inputNumber.charAt(i)) {
                case 'A':
                    decNum += 10 * decBase;
                    break;
                case 'B':
                    decNum += 11 * decBase;
                    break;
                case 'C':
                    decNum += 12 * decBase;
                    break;
                case 'D':
                    decNum += 13 * decBase;
                    break;
                case 'E':
                    decNum += 14 * decBase;
                    break;
                    
                case 'F':
                    decNum += 15 * decBase;
                    break;
                default:
                    decNum += Integer.parseInt(inputNumber.charAt(i) + "") * decBase;
            }
            decBase *= inBase;
        }
        return decNum;
    }

    /**
     * Convert decimal base to output base
     *
     * @param decNum  number in decimal base
     * @param outBase output number
     * @return String output number
     */
    public String convertDecToOutBase(int decNum, int outBase) {
        String outNum = "";
        int remainNum;
        while (decNum != 0) {            
            remainNum = decNum % outBase;
            switch(remainNum){
                case 10:
                    outNum = "A" + outNum;
                    break;
                case 11:
                    outNum = "B" + outNum;
                    break;
                case 12:
                    outNum = "C" + outNum;
                    break;
                case 13:
                    outNum = "D" + outNum;
                    break;
                case 14:
                    outNum = "E" + outNum;
                    break;
                case 15:
                    outNum = "F" + outNum;
                    break;
                default:
                    outNum = String.valueOf(decNum) + outNum;
            }
            decNum /= outBase;
        }
        
        return outNum;
    }
    
    /**
     * Get an input number in range 1-3 from the keyboard 1 is binary, 2 is
     * decimal, 3 is hexadecimal Convert 1 to 2, 2 to 20, 3 to 16
     *
     * @return base number 2 or 10 or 16
     */
    public int getBase() {
        int base;
        base = Validation.getInteger(
                1, 3,
                "Enter a number in range 1-3 (1 for Binary, 2 for Decimal, 3 for Hexadecimal) :",
                "Number is out of range",
                "Not a valid number"
        );
        switch (base) {
            case 1:
                base = 2;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 16;
                break;
        }
        return base;
    }

    /**
     * Get an input number from the keyboard
     *
     * @param inBase input base
     * @return String input number
     */
    public String getInputNumber(int inBase) {
        String inputNumber = "";
        switch (inBase) {
            case 2:
                inputNumber = Validation.getString(
                        "Enter a binary number: ",
                        "Not a valid number",
                        Constant.REGEX_BINARY);
                break;
            case 10:
                inputNumber = Validation.getString(
                        "Enter a decimal number: ",
                        "Not a valid number",
                        Constant.REGEX_DECIMAL);
                break;
            case 16:
                inputNumber = Validation.getString(
                        "Enter a hexadecimal number: ",
                        "Not a valid number",
                        Constant.REGEX_HEXADECIMAL);
                break;
        }
        return inputNumber.toUpperCase();
    }
}
