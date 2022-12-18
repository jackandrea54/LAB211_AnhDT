/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;

/**
 *
 * @author nguye
 */
public class LinearSearch {
    private int [] arr;
    
    /**
     * Generate random array with provided size 
     * @param size 
     */
    public void genArray(int size) {
        arr = new int[size];
        Random random = new Random();
        for (int i = 0; i< size; i++) {
            arr[i] = random.nextInt(size);
        }
    }
    
    /**
     * Find first index of input number
     * @param number need to find index
     * @return index
     */
    public int indexOf(int number) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Display an array
     */
    public void display(String msg) {
        System.out.println(msg);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
    }
}
