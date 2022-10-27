package david.zadaci.nedelja02;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Zadatak06 {
    public static void main(String[] args) {
        //int[] array = inputArray();
        int n = 13;
        int[] array = rearrange(IntStream.range(1,100).toArray(), n);
        subSetSumN(array, n);
    }

    private static void subSetSumN(int[] array, int n) {
        String format = "%" + array.length + "s";

        for (int i = 1; i < 1 << array.length; i++) {
            String binStr = String.format(format, Integer.toBinaryString(i)).replaceAll(" ", "0");

            if (sum(array, binStr, n) == n) {
                for (int j = 0; j < binStr.length(); j++)
                    if (binStr.charAt(j) == '1')
                        System.out.print(array[j] + " ");
                System.out.println();
            }
        }
    }

    private static int sum(int[] array, String binaryString, int n) {
        int sum = 0;
        for (int i = array.length-1; i >= 0; i--) {
            sum += array[i] * ((int) binaryString.charAt(i) - '0');
            if (sum > n)
                return sum;
        }
        return sum;
    }

    private static int[] rearrange(int[] array, int n) {
        int newLen = array.length;
        for (int elem : array)
            if (elem > n)
                newLen--;

        int[] newArray = new int[newLen];
        int j = 0;
        for (int elem : array)
            if (elem <= n)
                newArray[j++] = elem;

        return newArray;
    }
}
