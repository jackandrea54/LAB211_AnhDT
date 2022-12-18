/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import validate.Validation;

/**
 *
 * @author nguye
 */
public class Matrix {

    /**
     * Input matrix
     *
     * @return matrix
     */
    public static int[][] input() {
        String messageErrorOutOfRange = "Must be positive number";
        String messageErrorInvalidNumber = "Invalid number";
        int row = Validation.getInt("Enter number of row: ",
                messageErrorOutOfRange,
                messageErrorInvalidNumber, 1, Integer.MAX_VALUE);
        int col = Validation.getInt("Enter number of col: ",
                messageErrorOutOfRange,
                messageErrorInvalidNumber, 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Validation.getInt("Enter matrix[" + i + "][" + j + "]: ",
                        "Number is out of range",
                        messageErrorInvalidNumber, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    /**
     * Display matrix
     *
     * @param matrix to displays
     */
    public static void display(int[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
