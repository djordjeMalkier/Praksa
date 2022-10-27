package david.zadaci.nedelja01;

import java.io.IOException;
import static david.zadaci.nedelja02.Zadatak04.inputArray;

/*
 * Za niz brojeva sa tastature
 * sve nule iz niza staviti na kraj niza
 */
public class Zadatak09 {
    public static void main(String[] args) {
        try {
            int[] array = inputArray();
            moveZerosToEnd(array);
            printArray(array);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void moveZerosToEnd(int[] array) throws NullPointerException {
        if (array == null) throw new NullPointerException("Null array");

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                int nextNonZero = indexOfNextNonZero(array, i);
                if (nextNonZero == -1)
                    return;
                swapPlace(array, i, nextNonZero);
            }
        }
    }

    private static int indexOfNextNonZero(int[] array, int currentPosition) throws NullPointerException {
        if (array == null) throw new NullPointerException("Null array");

        if (currentPosition > array.length)
            return -1;

        for (int i = currentPosition + 1; i < array.length; i++)
            if (array[i] != 0)
                return i;

        return -1;
    }

    private static void swapPlace(int[] array, int i, int j) throws NullPointerException, IndexOutOfBoundsException {
        if (array == null)
            throw new NullPointerException("Null array");
        if (i >= array.length || j >= array.length)
            throw new IndexOutOfBoundsException("Invalid indexes");

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void printArray(int[] array) throws NullPointerException {
        if (array == null) throw new NullPointerException("Null array");

        for (int a : array)
            System.out.print(a + " ");
        System.out.println(" ");
    }
}
