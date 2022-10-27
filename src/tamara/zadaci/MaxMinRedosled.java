package tamara.zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinRedosled {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);

        System.out.print("Unesi broj clanova: ");

        int brojClanova = ulaz.nextInt();
        int[] niz = new int[brojClanova];
        System.out.println("Unesi clanove: ");

        for (int i = 0; i < brojClanova; i++) {
            System.out.print("X[" + i + "]" + ": ");
            niz[i] = ulaz.nextInt();
        }

        Arrays.sort(niz);
        int[] niz2 = new int[niz.length];

        for (int j : niz) {
            System.out.print(j + " ");
        }

        System.out.println("");

        int pomeraj = 0;

        for (int i = 0; i <= niz.length/2; i++) {
            if(i != niz.length - i) {
              niz2[i + pomeraj] = niz[niz.length-i-1];
              if(i+pomeraj+1 < niz2.length)
                niz2[i+pomeraj+1] = niz[niz[i]];
              pomeraj++;
            }

        }

        for (int j : niz2) {
            System.out.print(j + " ");
        }
    }
}