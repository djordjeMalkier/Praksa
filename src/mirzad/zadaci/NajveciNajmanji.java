package mirzad.zadaci;

import java.util.Scanner;

public class NajveciNajmanji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n= ");
        int n,a = 0;
        n = sc.nextInt();
        int[] array = new int[n];

        while (a < n && sc.hasNextInt()){
            array[a++] = sc.nextInt();

        }


        if(a < n) {
            System.out.println("Niste uneli dovoljno brojeva ");
            return;
        }

        sort(array,0,array.length-1);
        int[] niz = new int[array.length];
        int max = array.length-1;
        int min = 0;
        for (int i = 0; i < niz.length; i+=2){
            if(max < min) break;
            niz[i] = array[max--];
            if(i+1 <= niz.length-1) {
                niz[i + 1] = array[min++];
            }
        }

        for (int i = 0; i < niz.length; i++){
            System.out.print(niz[i] + " ");
        }



    }

    private static void sort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex-1);
            sort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}