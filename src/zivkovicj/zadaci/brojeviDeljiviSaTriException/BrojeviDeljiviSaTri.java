package zivkovicj.zadaci.brojeviDeljiviSaTriException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrojeviDeljiviSaTri {
    public static void main(String[] args) {
        ArrayList<Integer> listaBrojeva = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite 10 brojeva:");

        int i = 0;
        int counter = 0;
        while (i < 10) {
            try {
                int unetiBroj = sc.nextInt();
                daLiJeDeljivSaTri(unetiBroj);
                listaBrojeva.add(unetiBroj);
            } catch (NumbersDevisibleByThreeException e) {
                System.out.println(e.getMessage());
                counter++;
            }
            i++;
        }
        System.out.println(listaBrojeva);
        System.out.println("Brojeva deljivih sa 3 ima: " + counter);
    }

    private static void daLiJeDeljivSaTri(int broj) throws NumbersDevisibleByThreeException {

        if (broj % 3 == 0) {
            throw new NumbersDevisibleByThreeException("Broj je deljiv sa 3");
        }
    }
}
