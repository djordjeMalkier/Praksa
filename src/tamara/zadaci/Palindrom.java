package tamara.zadaci;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.print("Unesi string: ");
        String s = ulaz.nextLine();

        System.out.print("Rijec je: " + s + "\n");

        StringBuilder obrnuto = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            obrnuto.append(s.charAt(i));
        }

        if(s.isEmpty()) {
            System.out.println("Niste unijeli rijec.");

        } else {
            if (s.equals(obrnuto.toString()))
                System.out.println("Jeste palindrom");
            else
                System.out.println("Nije palindrom");
        }
        ulaz.close();
    }
}
