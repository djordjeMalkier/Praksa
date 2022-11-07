package mirzad.zadaci;

import java.util.Scanner;

public class MatricaTransponovana {
    public static void main(String[] args) {
        int[][] insertMatrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        

        for (int i = 0; i < insertMatrix.length; i++){
            for (int j = i; j < insertMatrix.length; j++){
                swap(i,j,insertMatrix);
            }
        }
        printMatrix(insertMatrix);
    }

    private static void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");;
            }
            System.out.println();
        }
    }
}
