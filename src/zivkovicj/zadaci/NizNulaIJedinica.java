package zivkovicj.zadaci;

public class NizNulaIJedinica {
    public static void main(String[] args) {

        int[] inputArray = {1, 0, 2, 1, 4, 0, 6, 1, 1};

        int leftPointer = 0;
        int rightPointer = inputArray.length - 1;

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && inputArray[rightPointer] == 1) {
                rightPointer--;
            }
            if (inputArray[leftPointer] == 1) {
                swap(inputArray, leftPointer, rightPointer);
            }
            leftPointer++;
        }

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {

                for (int j = i; j > 0; j--) {
                    swap(inputArray, j, j-1);
                }
            }
        }

        for (int a : inputArray) {
            System.out.println(a);
        }
    }

    public static void swap(int[] inputArray, int b, int a) {
        int temp = inputArray[a];
        inputArray[a] = inputArray[b];
        inputArray[b] = temp;
    }
}
