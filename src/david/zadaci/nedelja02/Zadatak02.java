package david.zadaci.nedelja02;

import java.util.Scanner;

public class Zadatak02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert start and end letters: ");
        char startLetter = sc.next().charAt(0);
        char endLetter = sc.next().charAt(0);
        sc.close();
        int n = endLetter - startLetter + 1;

        String space = " ".repeat(n+1);
        for (int i = 1; i < n; i++) {
            space = space.replaceFirst(" ", "");
            System.out.print(space);
            System.out.println(makeStr(startLetter, i));
        }

        StringBuilder space2 = new StringBuilder();
        for (int i = n; i > 0; i--) {
            space2.append(" ");
            System.out.print(space2);
            System.out.println(makeStr(startLetter, i));
        }
    }

    private static String makeStr(char startLetter, int n) {
        if (n <= 0) return "";

        StringBuilder s = new StringBuilder(String.valueOf(startLetter));

        for (int i = 1; i < n; i++)
            s.append((char)(startLetter + i));

        for (int i = n-2; i >= 0; i--)
            s.append((char)(startLetter + i));

        return s.toString();
    }
}
