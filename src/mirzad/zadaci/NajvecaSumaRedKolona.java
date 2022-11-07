package mirzad.zadaci;

import java.util.Scanner;

public class NajvecaSumaRedKolona {
    public static void main(String[] args) {
        int n,m;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite n: ");

        if(scanner.hasNextInt()) n = scanner.nextInt();
        else {
            System.out.println("Nepravilan unos! ");
            return;
        }

        System.out.println("Unesite m: ");

        if(scanner.hasNextInt()) m = scanner.nextInt();
        else {
            System.out.println("Nepravilan unos! ");
            return;
        }
        int[][] matrix = scanMatrix(n,m,scanner);

        if(matrix == null) return;

        int[] rowSumArray = rowSum(matrix,n,m);
        int[] columnSumArray = columnSum(matrix,n,m);

        int rowSum = sum(rowSumArray);
        int columnSum = sum(columnSumArray);

        if (rowSum > columnSum) {
            printArray(rowSumArray);
            System.out.println("Vrsta sa sumom: " + rowSum);
        }
        else {
            printArray(columnSumArray);
            System.out.println("Kolona sa sumom: " + columnSum);
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    private static int sum(int[] columnSumArray) {
        int sum = 0;
        for (int i = 0; i < columnSumArray.length; i++){
            sum += columnSumArray[i];
        }
        return sum;
    }

    private static int[][] scanMatrix(int n, int m, Scanner scanner) {
        System.out.println("Unesite matricu");
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++ ){
                if(scanner.hasNextInt())  matrix[i][j] = scanner.nextInt();
                else {
                    System.out.println("Nepravilan unos! ");
                    return null;
                }
            }
        }
        return matrix;
    }

    private static int[] columnSum(int[][] matrix, int n, int m){
        int max = 0;
        int[] arrayMax = new int[n];
        for(int j = 0; j < m; j++){
            int[] array = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++){
                array[i] = matrix[i][j];
                sum += matrix[i][j];
            }
            if(sum > max) arrayMax = array;
        }
        return arrayMax;
    }

    private static int[] rowSum(int[][] matrix, int n, int m) {
        int max = 0;
        int[] arrayMax = new int[n];
        for(int i = 0; i < n; i++){
            int[] array = new int[m];
            int sum = 0;
            for (int j = 0; j < m; j++){
                array[j] = matrix[i][j];
                sum += matrix[i][j];
            }
            if(sum > max) arrayMax = array;
        }
        return arrayMax;
    }
}
