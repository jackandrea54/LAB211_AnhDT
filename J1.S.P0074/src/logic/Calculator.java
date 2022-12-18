/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author nguye
 */
public class Calculator {

    /**
     * Addition two matrix
     *
     * @param matrix1 is first matrix
     * @param matrix2 is second matrix
     * @return result matrix
     */
    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            System.out.println("Invalid size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                ansMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return ansMatrix;
    }

    /**
     * Subtraction two matrix
     *
     * @param matrix1 is first matrix
     * @param matrix2 is second matrix
     * @return result matrix
     */
    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            System.out.println("Invalid size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                ansMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return ansMatrix;
    }

    /**
     * Multiplication two matrix
     *
     * @param matrix1 is first matrix
     * @param matrix2 is second matrix
     * @return result matrix
     */
    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Invalide size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    temp += matrix1[i][k] * matrix2[k][j];
                }
                ansMatrix[i][j] = temp;
            }
        }
        return ansMatrix;
    }
}
