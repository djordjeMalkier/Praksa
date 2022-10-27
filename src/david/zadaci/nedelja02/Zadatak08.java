package david.zadaci.nedelja02;

import java.io.IOException;
import static david.zadaci.nedelja02.Zadatak04.inputArray;

/*
* iz zadatog niza brojeva, potrebno je pronaci maksimalnu razliku dva broja,
* ali takvu da manji broj prethodi vecem broju u nizu*/
public class Zadatak08 {
    public static void main(String[] args) {
        try {
            int[] array = inputArray();
            System.out.println(maxDiff(array));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int maxDiff(int[] array) {
        int maxDifference = -Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++)
            for (int j = i+1; j < array.length; j++)
                if (array[j] - array[i] > maxDifference)
                    maxDifference = array[j] - array[i];
        if (maxDifference < 0)
            return -1;

        return maxDifference;
    }
}
