package david.zadaci.nedelja01;

import java.util.Scanner;
import static java.util.Arrays.sort;

/*Permutacija stringa*/
public class Zadatak05 {
    public static void main(String[] args) {
        String originalString = "aabcdef";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            try {
                System.out.println(isStringPermutation(originalString, sc.next()));
            } catch (NullPointerException e) {
                System.err.println("Null string");
                sc.close();
            }
        }
        sc.close();
    }

    private static String sortString(String originalString) throws NullPointerException {
        if (originalString == null)
            throw new NullPointerException("Null string");

        char[] sortedArray = originalString.toCharArray();
        sort(sortedArray);
        return new String(sortedArray);
    }

    private static boolean isStringPermutation(String originalString, String newString) throws NullPointerException {
        if (originalString == null || newString == null)
            throw new NullPointerException("Null string");

        if (originalString.length() != newString.length())
            return false;

        String originalSorted = sortString(originalString);
        String newSorted = sortString(newString);
        return originalSorted.equals(newSorted);
    }
}
