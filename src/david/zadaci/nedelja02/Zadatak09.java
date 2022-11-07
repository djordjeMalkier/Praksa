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
            int[] inputArray = inputArray();
            Arrays.stream(productOfOtherElements2(inputArray)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int[] productOfOtherElements(int[] inputArray) {
        if (inputArray == null) throw new NullPointerException("Null array");

        int[] products = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            products[i] = product(inputArray, i);
        }
        return products;
    }

    private static int product(int[] inputArray, int i) {
        if (inputArray == null) throw new NullPointerException("Null array");

        int productInArray = 1;
        for (int j = 0; j < inputArray.length; j++) {
            if (i != j)
                productInArray *= inputArray[j];
        }
        return productInArray;
    }

    private static int[] productOfOtherElements2(int[] inputArray) {
        if (inputArray == null) throw new NullPointerException("Null input array");

        int arrayProduct = Arrays.stream(inputArray).reduce((a, b) -> a*b).orElse(1);
        return  Arrays.stream(inputArray).map(arrayElement -> arrayProduct / arrayElement).toArray();
    }
}
