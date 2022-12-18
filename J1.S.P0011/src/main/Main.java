package main;

import logic.BaseConversion;

public class Main {

    public static void main(String[] args) {
        BaseConversion baseConv = new BaseConversion();
        System.out.println("---- Enter input base ----(");
        int inBase = baseConv.getBase();
        System.out.print("Enter output base. ");
        int outBase = baseConv.getBase();
        System.out.print("Enter input number. ");
        String inputNumber = baseConv.getInputNumber(inBase);
        int decNum = baseConv.convertToDec(inputNumber, inBase);
        String outputNumber = baseConv.convertDecToOutBase(decNum, outBase);
        System.out.print("Output number: ");
        System.out.println(outputNumber);
    }
}
