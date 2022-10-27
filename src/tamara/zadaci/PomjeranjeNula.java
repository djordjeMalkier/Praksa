package tamara.zadaci;

import java.util.Scanner;

public class PomjeranjeNula {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.print("Unesi broj clanova: ");
        int n = ulaz.nextInt();
        int[] niz = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("niz[" + i + "]: ");
            niz[i] = ulaz.nextInt();
        }

        int pomocna;

        for (int i = 0; i < niz.length; i++) {
            if(niz[i] == 0) {
                int j= i;
             while(j<niz.length-1) {
                 System.out.println("menjam " + niz[j] + " sa " + niz[j + 1]);
                 pomocna = niz[j];

                 niz[j] = niz[j + 1];
                 niz[j + 1] = pomocna;
                 j++;
             }
            }
        }

        for (int k: niz) {
            System.out.println(k);
        }
    }
}