package zivkovicj.zadaci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindNumberInSortedMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,3,7,9,15},
                {2,5,8,17,22},
                {4,7,10,30,40}};

        printMatrix(matrix);
        System.out.println("Sorted matrix");


    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void findNumberInMatrix(int[][] matrix, int number) {
        int r = matrix.length;
        int start = 0;
        int end = r - 1;
        int mid = (start+end)/2;
        while (start <= end){
            mid = (start + end) / 2;
            if(number >= start){

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
