package zivkovicj.zadaci;

import java.util.Scanner;

public class TransponovanaMatrica {
    public static void main(String[] args) {


        //displayMatrix(transposeMatrix(matrix, matrixSize, sc));
        int[][] matrica = generateMatrix();
        System.out.println("Vasa matrica:");
        displayMatrix(matrica);
        System.out.println("Transponovana matrica:");
        displayMatrix(transposeMatrix(matrica));

    }

    public static int[][] generateMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite velicinu matrice:");
        int matrixSize = sc.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        System.out.println("Unesite matricu:");

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    public static int[][] transposeMatrix(int[][] matrix){

        int[][] transposedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[i][j] = matrix[j][i];

            }
        }
        return transposedMatrix;

    }

    public static void displayMatrix(int[][] matrix){
        for (int[] m: matrix){
            for (int n: m){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
