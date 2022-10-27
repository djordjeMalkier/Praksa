package tamara.zadaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class proveriStringove {
    public static void main(String[] args) {
        int brojac = 0;

        String s1 = "Lak";
        Scanner ulaz = new Scanner(System.in);
        System.out.print("Unesi string: ");
        String s2 = ulaz.next();

        if(s2.isEmpty())
            System.out.println("Niste unijeli string.");

        System.out.print("Ulazni string je: " + s1 + "\nString sa tastature je: " + s2 + "\n");

        char[] niz1 = s1.toLowerCase().toCharArray();
        char[] niz2 = s2.toLowerCase().toCharArray();

        Arrays.sort(niz1);
        Arrays.sort(niz2);

        if(niz1.length != niz2.length) {
            System.out.println("Duzine razlicite.");
            return;

        } else {
            for (int i = 0; i< niz1.length; i++) {
                if(niz1[i] != niz2[i]) {
                    System.out.println("Nisu isti.");
                    return;
                }
            }

            System.out.println("Isti su.");
            }
        }
}