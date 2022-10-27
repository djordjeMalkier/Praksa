package david.zadaci.nedelja01;

import java.util.Scanner;

/*Obrtanje stringa*/
public class Zadatak07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            try {
                System.out.println(obrni(sc.nextLine()));
            } catch (NullPointerException e) {
                System.err.println("Null string");
                sc.close();
            }
        }
        sc.close();
    }

    private static String obrni(String str) {
        if (str == null) throw new NullPointerException("Null string");

        StringBuilder newStr = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++)
            newStr.append(str.charAt(len - 1 - i));

        return newStr.toString();
    }
}
