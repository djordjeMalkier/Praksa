package david.zadaci.nedelja02;

import java.util.Arrays;
import java.util.stream.IntStream;

//Svaki drugi element u nizu da bude veci od elementa levo i desno od njega
public class Zadatak07 {
    public static void main(String[] args) {
        int[] array = IntStream.range(1,10).toArray();
        Arrays.stream(rearrange(array)).forEach(System.out::println);
    }

    private static int[] rearrange(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length-1; i+=2)
            swap(array, i, i+1);

        return array;
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
