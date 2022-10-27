package zivkovicj.zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinNaizmenicno {
    public static void main(String[] args) {
        // 2,5,1,6,7,8,4 rezultat je 8,1,7,2,6,4,5
        Scanner sc = new Scanner(System.in);
        System.out.println("Koliko brojeva hocete da unesete?");
        int number = sc.nextInt();
        int[] array = new int[number];
        System.out.println("Unesite brojeve:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        int[] arrayCopy = new int[array.length];

        int max = array.length - 1;

        for (int i = 0; i < array.length; i+=2) {
            arrayCopy[i] = array[max--];
        }

        max = 0;
        for (int i = 1; i < array.length; i+=2) {
            arrayCopy[i] = array[max++];
        }

        for (int a: arrayCopy){
            System.out.println(a);
        }
    }
}
