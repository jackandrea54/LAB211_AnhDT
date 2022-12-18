package sort;

import utils.Validation;

public class BubbleSort {

    /**
     * Display an array
     *
     * @param arr   the Integer array to display
     * @param isAsc to print the array in the ascending (if true) or descending
     *              way (if false)
     */
    public void display(int arr[], boolean isAsc) {
        if (arr.length == 0) {
            System.out.println("The array is empty");
        } else {
            if (isAsc) {
                for (int i = 0; i < arr.length; i++) {
                    if (i != arr.length - 1) {
                        System.out.print("[" + arr[i] + "]->");
                    } else {
                        System.out.print("[" + arr[i] + "]");
                    }
                }
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i != arr.length - 1) {
                        System.out.print("[" + arr[i] + "]<-");
                    } else {
                        System.out.print("[" + arr[i] + "]");
                    }
                }
            }
            System.out.println("");
        }
    }

    /**
     * Create the array and get input for all of the array elements
     * 
     * @return the inputted array
     */
    public int [] getInputArrElement() {
        int length = Validation.getInteger(
                "Enter Number: ",
                "Please input number and number is greater than zero",
                "Please input number and number is greater than zero",
                1, 
                Integer.MAX_VALUE
        );
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Validation.getInteger(
                    "Enter Number " + (i + 1) + ": ",
                    "Please input number and number is greater than zero",
                    "Please input number and number is greater than zero",
                    1, 
                    Integer.MAX_VALUE   
            );
        }
        return arr;
    }


    /**
     * Sort the array using Bubble Sort algorithm
     * 
     * @param arr   the Integer array to be sorted
     * @param isAsc to sort the array in the ascending (if {@code true}) or descending
     *              (if {@code false})
     */
    public void sort(int arr[], boolean isAsc) {
        if (arr.length == 0) {
            System.out.println("The list is empty!");
        } else {
            if (isAsc) {
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            } else {
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        if (arr[j] < arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            }
        }
    }
}
