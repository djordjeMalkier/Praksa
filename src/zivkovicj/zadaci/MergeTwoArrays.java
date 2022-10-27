package zivkovicj.zadaci;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr = {1, 3,3, 10, 15};
        int[] arr2 = {2, 3, 5, 7, 11};
        int[] arr3 = new int[arr.length + arr2.length];
        int l = 0;
        int r = 0;
        sort(arr, arr2, arr3);

        for (int a3 : arr3){
            System.out.println(a3);
        }

    }
    public static void sort(int[] arr1,int[] arr2,int[] arr3){
        int k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        for (int i = 0; i < n1; i++) {
            arr3[k++] = arr1[i];
        }
        for (int j = 0; j < n2; j++) {
            arr3[k++] = arr2[j];
        }

        Arrays.sort(arr3);
    }
}
