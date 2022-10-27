package zivkovicj.zadaci;

import java.util.Scanner;

public class SveNuleNaKraju {
    public static void main(String[] args) {
        // prebaciti sve nule iz niza na kraj

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.print("Unesite broj:");

        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (arr[j] == 0) {
                    swap(arr, j, k);
                }
            }
        }
        for (int n : arr) {
            System.out.println(n);
        }
    }

    public static void swap(int[] arr, int b, int a) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
