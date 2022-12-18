/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import linearsearch.LinearSearch;
import validate.Validation;
/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int size = Validation.getInt("Enter number of array:",
                "Must be positve number",
                "Input is invalid", 1, Integer.MAX_VALUE);
        linearSearch.genArray(size);
        linearSearch.display("The array: ");
        int searchNumber = Validation.getInt("Enter number to search:",
                "Must be positve number",
                "Input is invalid", 0, Integer.MAX_VALUE);
        int index =  linearSearch.indexOf(searchNumber);
        if (index==-1) {
            System.out.println("Not found!");
        } else {
            System.out.println("Found "+searchNumber+" at index: "+index);
        }
    }
}
