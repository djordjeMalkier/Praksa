package david.zadaci.nedelja02;

import java.io.IOException;
import java.util.Arrays;

public class Zadatak05 {

    public static void main(String[] args) {
        try {
            int[] a = {-1,2,2,13};
            int[] b = {2,10,15,20,21};
            Arrays.stream(merge(a, b)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int[] merge(int[] a, int[] b) throws IOException {
        if (a == null || b == null) throw new NullPointerException("Null array");
        if (!isSorted(a) || !isSorted(b)) throw new IOException("Array not sorted");

        int[] sorted = new int[a.length + b.length];

        int indA = 0, indB = 0, i = 0;
        while (indA < a.length && indB < b.length) {
            if (a[indA] <= b[indB])
                sorted[i++] = a[indA++];
            else
                sorted[i++] = b[indB++];
        }

        for (; indA < a.length; indA++)
            sorted[i++] = a[indA];

        for (; indB < b.length; indB++)
            sorted[i++] = b[indB];

        return sorted;
    }

    private static boolean isSorted(int[] a) {
        if (a == null) throw new NullPointerException("Null array");

        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i+1])
                return false;
        return true;
    }
}
