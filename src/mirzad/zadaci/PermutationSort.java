package mirzad.zadaci;

import java.util.Scanner;

public class PermutationSort {
    public static void main(String[] args) {
        String permutationString = "baab";
        boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if(permutationString.length() != inputString.length()) {
            System.out.println("Nije permutacija");
            return;
        }

        char[] permutation = permutationString.toCharArray();
        char[] input = inputString.toCharArray();

        sort(permutation, 0, permutation.length-1);
        sort(input, 0, permutation.length-1);

        for (int i = 0; i < permutation.length; i++){
            if(permutation[i] != input[i]) {
                flag = false;
                System.out.println("Nije permutacija.");
                break;
            }
        }

        if(flag) System.out.println("Jeste permutacija.");

    }

    private static void sort(char arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex-1);
            sort(arr, partitionIndex+1, end);
        }

    }

    private static int partition(char arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                char swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        char swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}


