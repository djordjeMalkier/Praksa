package zivkovicj.zadaci;

import java.util.Scanner;

public class SumaDijagonalaMatrice {
    public static void main(String[] args) {
        /* potrebno je za matricu unetu sa tastature n*n pronaci sledece sume: sume elemenata na glavnoj dijagonali,
        na sporednoj dijagonali, sumu elemenata ispod i i znad i jedne i druge. Takodje je potrebno izracunati proizvod
        svih brojeva koji ne pripadaju ni glavnoj ni sporednoj dijagonali. */
        int[][] generatedMatrix = generateMatrix();
        displayMatrix(generatedMatrix);

        System.out.println("Suma glavne dijagonale matrice: " + sumOfPrimary(generatedMatrix));
        System.out.println("Suma sporedne dijagonale matrice: " + sumOfSecondary(generatedMatrix));
        System.out.println("Suma iznad glavne dijagonale matrice: " + sumAbovePrimary(generatedMatrix));
        System.out.println("Suma ispod glavne dijagonale matrice: " + sumBelowPrimary(generatedMatrix));
        System.out.println("Suma iznad sporedne dijagonale matrice: " + sumAboveSecondary(generatedMatrix));
        System.out.println("Suma ispod sporedne dijagonale matrice: " + sumBelowSecondary(generatedMatrix));
        System.out.println("Pomnozeni elementi matrice koji ne pripadaju dijagonalama: " +
                productOfEverythingButDiagonals(generatedMatrix));
    }

    public static int sumOfPrimary(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j)
                    sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int sumOfSecondary(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ((i + j) == matrix.length - 1)
                    sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int sumAbovePrimary(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int sumBelowPrimary(int[][] matrix) {

        int sum = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int sumAboveSecondary(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int sumBelowSecondary(int[][] matrix) {

        int sum = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= i; j--) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int productOfEverythingButDiagonals(int[][] matrix) {
        int currentProduct = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j && (i + j) != matrix.length - 1) {
                    currentProduct *= matrix[i][j];
                }

            }
        }
        return currentProduct;
    }


    public static int[][] generateMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite velicinu matrice:");
        int matrixSize = sc.nextInt();
        System.out.println("Unesite matricu");
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = sc.nextInt();
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
