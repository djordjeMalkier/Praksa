package david.zadaci.nedelja02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Zadatak04 {
    public static void main(String[] args) {
        try {
            int[] array = inputArray();
            arrangeArray(array);
            Arrays.stream(array).forEach(System.out::println);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void arrangeArray(int[] array) {
        if (array == null) throw new NullPointerException("Null array");

        for (int i = 0; i < array.length - 2; i+=2) {
            swap(array, i, indexOfMax(array, i));
            swap(array, i+1, indexOfMin(array, i+1));
        }
    }

    private static int indexOfMin(int[] array, int pos) {
        if (array == null) throw new NullPointerException("Null array");
        if (pos < 0 || pos >= array.length) throw new IndexOutOfBoundsException("Bad position");

        int min = array[pos];
        int minInd = pos;
        for (int i = pos; i < array.length; i++)
            if (array[i] < min) {
                min = array[i];
                minInd = i;
            }

        return minInd;
    }

    private static int indexOfMax(int[] array, int pos) {
        if (array == null) throw new NullPointerException("Null array");
        if (pos < 0 || pos >= array.length) throw new IndexOutOfBoundsException("Bad position");

        int max = array[pos];
        int maxInd = pos;
        for (int i = pos; i < array.length; i++)
            if (array[i] > max) {
                max = array[i];
                maxInd = i;
            }

        return maxInd;
    }

    private static void swap(int[] array, int i, int j) {
        if (array == null) throw new NullPointerException("Null array");
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int[] inputArray() throws IOException {
        Scanner sc = new Scanner(System.in);
        int arraySize;

        if (sc.hasNextInt())
            arraySize = sc.nextInt();
        else
            throw new IOException("Array size must be int");

        if (arraySize <= 0)
            throw new IOException("Array size must be greater than zero");

        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            if (sc.hasNextInt())
                array[i] = sc.nextInt();
            else
                throw new IOException("Array element must be int");

        sc.close();
        return array;
    }
}
