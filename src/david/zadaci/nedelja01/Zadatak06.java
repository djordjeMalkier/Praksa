package david.zadaci.nedelja01;

import java.util.Scanner;

/*Da li je string palindrom*/

public class Zadatak06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            try {
                System.out.println(isPalindrom(sc.nextLine()));
            } catch (NullPointerException e) {
                System.err.println("Null string");
                sc.close();
            }
        }
        sc.close();
    }

    private static boolean isPalindrom(String str) {
        if (str == null) throw new NullPointerException("Null string");

        if (str.isEmpty()) return false;

        int len = str.length() - 1;
        for (int i = 0; i < len/2; i++)
            if (str.charAt(i) != str.charAt(len - i))
                return false;

        return true;
    }
}
