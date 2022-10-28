package david.zadaci.nedelja02;

import java.io.IOException;
import java.util.Arrays;

import static david.zadaci.nedelja02.Zadatak04.inputArray;
/*
* Zameni sve brojeve u nizu proizvodom svih ostalih elemenata niza.
* */
public class Zadatak09 {
    public static void main(String[] args) {
        try {
            int[] array = inputArray();
            Arrays.stream(productOfOtherElements(array)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int[] productOfOtherElements(int[] array) {
        if (array == null) throw new NullPointerException("Null array");

        int[] products = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            products[i] = product(array, i);
        }
        return products;
    }

    private static int product(int[] array, int i) {
        if (array == null) throw new NullPointerException("Null array");

        int prod = 1;
        for (int j = 0; j < array.length; j++) {
            if (i != j)
                prod *= array[j];
        }
        return prod;
    }
}
