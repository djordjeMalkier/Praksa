package mirzad.zadaci;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MatricaDijagonale {

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

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(glavnaDijagonala(i,j)) glavnaDijagonalaSum +=matrix[i][j];
                if(sporednaDijagonala(i,j,n)) sporednaDijagonalaSum +=matrix[i][j];
                if(iznadGlavne(i,j)) iznadGlavne += matrix[i][j];
                if(ispodGlavne(i,j)) ispodGlavne += matrix[i][j];
                if(iznadSporedne(i,j,n)) iznadSporedne += matrix[i][j];
                if(ispodSporedne(i,j,n)) ispodSporedne += matrix[i][j];
                if(!glavnaDijagonala(i,j) && !sporednaDijagonala(i,j,n)) proizvod *= matrix[i][j];
            }
        }

        System.out.println(
                "Glavna: " + glavnaDijagonalaSum +
                "\nSporedna: " + sporednaDijagonalaSum +
                "\nIznad glavne: " + iznadGlavne +
                "\nIspod glavne: " + ispodGlavne +
                "\nIznad sporedne: " + iznadSporedne +
                "\nIspod sporedne: " + ispodSporedne +
                "\nProizvod: " + proizvod);
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

    private static boolean glavnaDijagonala(int i, int j){
        return i == j;
    }

    private static boolean sporednaDijagonala(int i, int j, int n){
        return j == n-i-1;
    }

    private static boolean iznadGlavne(int i, int j){
        return j > i;
    }

    private static boolean ispodGlavne(int i, int j){
        return j < i;
    }

    private static boolean iznadSporedne(int i, int j, int n){
        return i + j < n - 1;
    }

    private static boolean ispodSporedne(int i, int j, int n){
        return i + j > n - 1;
    }

}
