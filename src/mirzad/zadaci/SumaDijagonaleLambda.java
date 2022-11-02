package mirzad.zadaci;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SumaDijagonaleLambda {

    public static void main(String[] args) {
        int n;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite n: ");

        if(scanner.hasNextInt()) n = scanner.nextInt();
        else {
            System.out.println("Nepravilan unos! ");
            return;
        }

        int[][] matrix = scanMatrix(n,scanner);

        if(matrix == null) return;
        int glavnaDijagonalaSum = 0;
        int sporednaDijagonalaSum = 0;

        int ispodGlavne = 0;
        int iznadGlavne = 0;

        int ispodSporedne = 0;
        int iznadSporedne = 0;
        int proizvod = 1;

        glavnaDijagonalaSum = IntStream.range(0,matrix.length).map(i -> matrix[i][i]).sum();

        sporednaDijagonalaSum = IntStream.range(0, matrix.length).map(i -> matrix[i][matrix.length - i - 1]).sum();


        ispodGlavne = IntStream.range(1, matrix.length*matrix.length).filter(i -> i%matrix.length < i/matrix.length).
                map(i -> matrix[i/matrix.length][i%matrix.length]).sum();

        iznadGlavne = IntStream.range(1, matrix.length*matrix.length).filter(i -> i%matrix.length > i/matrix.length).
                map(i -> matrix[i/matrix.length][i%matrix.length]).sum();

        System.out.println(glavnaDijagonalaSum + " " + sporednaDijagonalaSum + " " + ispodGlavne + " " + iznadGlavne);


    }

    private static int[][] scanMatrix(int n, Scanner scanner) {
        System.out.println("Unesite matricu");
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++ ){
                if(scanner.hasNextInt())  matrix[i][j] = scanner.nextInt();
                else {
                    System.out.println("Nepravilan unos! ");
                    return null;
                }
            }
        }
        return matrix;
    }
}
