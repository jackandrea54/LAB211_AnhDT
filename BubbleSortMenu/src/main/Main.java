package main;

import constant.Constant;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import sort.BubbleSort;
import utils.Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thangnv
 */
public class Main {

    public static void main(String[] args) throws Exception {
         //Test check day of week
//        Calendar c = Calendar.getInstance();
//        Date date = new SimpleDateFormat("dd/M/yyyy").parse("11/10/2022");
//        c.setTime(date);
//        String dayOfWeek = new SimpleDateFormat("EEEE").format(date);
//        int day = c.get(Calendar.DAY_OF_WEEK);
//        System.out.println(dayOfWeek);

        BubbleSort bbSort = new BubbleSort();
        Scanner scan = new Scanner(System.in);
        int sel;
        int arr[] = new int[0];
        do {
            System.out.println("============== Bubble Sort program ===============");
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");
            sel = Validation.getInteger(
                    "Please choice one option: ",
                    "Please enter a number in range of menu choices",
                    "Wrong format, please re-enter an integer number in range of menu choices",
                    1,
                    4
            );
            switch (sel) {
                case 1:
                    System.out.println("--------- Input Element ---------");
                    arr = bbSort.getInputArrElement();
                    break;
                case 2:
                    System.out.println("----- Ascending -----");
                    bbSort.sort(arr, true);
                    bbSort.display(arr, true);
                    break;
                case 3:
                    System.out.println("----- Descending -----");
                    bbSort.sort(arr, false);
                    bbSort.display(arr, false);
                    break;
                case 4:
                    sel = Constant.END_INDEX;
                    break;
            }
        } while (sel != Constant.END_INDEX);
    }
}
