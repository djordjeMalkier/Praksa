package zivkovicj.zadaci;

import java.util.Scanner;

public class NajvecaSumaRedovaKolonaMatrica {
    public static void main(String[] args) {

        int[][] matrica = generateMatrix();
        System.out.println("Vasa matrica:");
        displayMatrix(matrica);
        System.out.println("Najveca suma elemenata:");
        biggestSumMatrix(generateMatrix());

    }

    public static int[][] generateMatrix() {
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

    public static int[][] biggestSumMatrix(int[][] matrix) {

        int[] maxSumRowsArray = new int[matrix.length];
        int[] maxSumColumnsArray = new int[matrix.length];

        int maxSumRows = 0;
        int maxSumColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            int sumRows = 0;
            int[] array = new int[matrix.length];
            for (int j = 0; j < matrix[i].length; j++) {
                sumRows += matrix[i][j];
                array[j] = matrix[i][j];
            }
            if (maxSumRows < sumRows) {
                maxSumRows = sumRows;
                maxSumRowsArray = array;
            }
        }
        for (int i = 0; i < matrix[i].length - 1; i++) {
            int sumColumns = 0;
            int[] array = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                sumColumns += matrix[j][i];
                array[j] = matrix[i][j];
            }
            if (maxSumColumns < sumColumns) {
                maxSumColumns = sumColumns;
                maxSumColumnsArray = array;
            }

        }
        if (maxSumColumns > maxSumRows) {
            for (int n : maxSumColumnsArray) {
                System.out.print(n);

            }
        } else {
            for (int n : maxSumRowsArray) {
                System.out.print(n);
            }
        }

        return matrix;

    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] m : matrix) {
            for (int n : m) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
