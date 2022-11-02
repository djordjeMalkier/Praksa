package zivkovicj.zadaci;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumaDijagonalaMatriceLambda {
    public static void main(String[] args) {
        /* potrebno je za matricu unetu sa tastature n*n pronaci sledece sume: sume elemenata na glavnoj dijagonali,
        na sporednoj dijagonali, sumu elemenata ispod i i znad i jedne i druge. Takodje je potrebno izracunati proizvod
        svih brojeva koji ne pripadaju ni glavnoj ni sporednoj dijagonali. */

        int[][] generatedMatrix = generateMatrix();
        displayMatrix(generatedMatrix);

        System.out.println("Suma glavne dijagonale matrice: " + sumOfPrimary(generatedMatrix));
        System.out.println("Suma sporedne dijagonale matrice: " + sumOfSecondary(generatedMatrix));
        System.out.println("Suma ispod glavne dijagonale matrice: " + sumBelowPrimary(generatedMatrix));
        System.out.println("Suma iznad glavne dijagonale matrice: " + sumAbovePrimary(generatedMatrix));
        System.out.println("Suma iznad sporedne dijagonale matrice: " + sumAboveSecondary(generatedMatrix));
        System.out.println("Suma ispod sporedne dijagonale matrice: " + sumBelowSecondary(generatedMatrix));
        System.out.println("Pomnozeni elementi matrice koji ne pripadaju dijagonalama: " +
                productOfEverythingButDiagonals(generatedMatrix));
    }

    public static int sumOfPrimary(int[][] matrix) {

        return IntStream.range(0, matrix.length)
                .map(i -> matrix[i][i])
                .sum();
    }

    public static int sumOfSecondary(int[][] matrix) {

        return IntStream.range(0, matrix.length)
                .map(i -> matrix[i][matrix.length - i - 1]).sum();
    }

    public static int sumAbovePrimary(int[][] matrix) {

        return IntStream.range(0, matrix.length * matrix.length)
                .filter(i -> i % matrix.length > i / matrix.length)
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .sum();

    }

    public static int sumBelowPrimary(int[][] matrix) {

        return IntStream.range(0, matrix.length * matrix.length)
                .filter(i -> i % matrix.length < i / matrix.length)
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .sum();

    }


    public static int productOfEverythingButDiagonals(int[][] matrix) {
        return IntStream.range(0, matrix.length * matrix.length)
                .filter(i -> i % matrix.length != i / matrix.length)
                .filter(i -> (i % matrix.length + i / matrix.length) != matrix.length - 1)
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .reduce(1, (x, y) -> x * y);
    }

    public static int sumAboveSecondary(int[][] matrix) {

        return IntStream.range(0, matrix.length * matrix.length)
                .filter(i -> i % matrix.length > i / matrix.length)
                .map(i -> matrix[i / matrix.length][i % matrix.length - i / matrix.length - 1])
                .sum();

    }

    public static int sumBelowSecondary(int[][] matrix) {

        return IntStream.range(0, matrix.length * matrix.length)
                .filter(i -> (i % matrix.length + i / matrix.length) > matrix.length - 1)
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .sum();
    }

    public static int[][] generateMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite velicinu matrice:");
        int matrixSize = sc.nextInt();
        System.out.println("Unesite matricu");
        int[][] matrix = new int[matrixSize][matrixSize];

        IntStream.range(0, matrix.length * matrix.length)
                .forEach(i -> matrix[i / matrix.length][i % matrix.length] = sc.nextInt());

        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
