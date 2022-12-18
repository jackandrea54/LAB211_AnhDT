/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Matrix;
import logic.Calculator;
import validate.Validation;

/**
 *
 * @author nguye
 */
public class Main {

    public static void main(String[] args) {
        String messageErrorOutOfRange = "Must be positive number";
        String messageErrorInvalidNumber = "Invalid number";
        int flag = 1;
        while (flag == 1) {
            int choice = Validation.getInt("Enter your choice: ",
                    messageErrorOutOfRange,
                    messageErrorInvalidNumber, 1, 4);
            int [][] matrix1 = Matrix.input();
            int [][] matrix2 = Matrix.input();
            int[][] ansMatrix;
            switch (choice) {
                case 1:
                    ansMatrix = Calculator.additionMatrix(matrix1, matrix2);
                    Matrix.display(ansMatrix);
                    break;
                case 2:
                    ansMatrix = Calculator.subtractionMatrix(matrix1, matrix2);
                    Matrix.display(ansMatrix);
                    break;
                case 3:
                    ansMatrix = Calculator.multiplicationMatrix(matrix1, matrix2);
                    Matrix.display(ansMatrix);
                    break;
                case 4:
                    flag = 0;
                    break;
            }
            
        }
    }
}
