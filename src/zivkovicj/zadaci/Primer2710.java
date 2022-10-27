package zivkovicj.zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class Primer2710 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Koliko brojeva hocete da unesete?");
        int number = sc.nextInt();
        int[] array = new int[number];
        System.out.println("Unesite brojeve:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int i = 1; i < array.length-1; i+=2) {
            swap(array, i+1, i);
        }
        System.out.println("Rearranged numbers:");
        for (int a: array){
            System.out.print(a + " ");
        }
    }
    public static void swap(int[] arr, int b, int a) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
