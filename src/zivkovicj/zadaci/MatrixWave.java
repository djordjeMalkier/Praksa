package zivkovicj.zadaci;

import java.util.Scanner;

public class MatrixWave {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite broj kolona:");
        int n = scanner.nextInt();
        System.out.println("Unesite broj redova:");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        // unos matrice
        System.out.println("Unesite elemente matrice:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        printMatrix(n, m, matrix);

    }

    public static void printMatrix(int n, int m, int[][] matrix) {
        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
