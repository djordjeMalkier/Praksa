package zivkovicj.zadaci;

import java.util.Scanner;

public class MatrixDiagonalWave {
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

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                if (i == j)
                    System.out.print(matrix[i][j] + " ");
            }
        }
        for (int k = 0; k <= m; k++) {

            for (int i = n; i >= 0; i--) {

                for (int j = m - 1; j >= 0; j--) {

                    if ((i + k) == j && (i != j))
                        System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
