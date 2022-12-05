package tamara.zadaci;

//import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class PermutujBrojDobijNajveci {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        int zadatiBroj = ulaz.nextInt();
        int zadatiBroj1 = zadatiBroj;
        int kapacitetNiza = 0;

        while(zadatiBroj != 0) {
            kapacitetNiza++;
            zadatiBroj /= 10;
        }

        int[] nizCifara = new int[kapacitetNiza];
        int brojac = 0;
        int poslednjaCifra;
        while(zadatiBroj1 != 0) {
            poslednjaCifra = zadatiBroj1 % 10;
            nizCifara[brojac++] = poslednjaCifra;
            zadatiBroj1 /= 10;
        }

        Arrays.sort(nizCifara);
       // ArrayUtils.reverse(nizCifara);

        int konacanBroj = 0;
        for (int broj : nizCifara) {
            konacanBroj = konacanBroj * 10 + broj;
        }
        System.out.println(konacanBroj);
    }
}
