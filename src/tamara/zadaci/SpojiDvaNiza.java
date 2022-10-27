package tamara.zadaci;

import java.util.Arrays;

public class SpojiDvaNiza {
    public static void main(String[] args) {
        int[] niz1 = {5, 7, 6, 8, 7};
        int[] niz2 = {5, 44, 26, 8,};
        int[] zajednicki = new int[niz1.length+ niz2.length];


        Arrays.sort(niz1);
        Arrays.sort(niz2);

        int a = 0, b = 0, c = 0;

       /*while(a < niz1.length) {
               zajednicki[c] = niz1[a];
               a++;
               c++;
        }*/

        while(a < niz1.length && b < niz2.length) {
            if(niz1[a] <= niz2[b]) {
                zajednicki[c++] = niz1[a++];
            } else
                zajednicki[c++] = niz2[b++];

        }

        for (;a < niz1.length; a++) {
            zajednicki[c++] = niz1[a];
        }
        
        for (;b < niz2.length; b++) {
            zajednicki[c++] = niz2[b];
        }



        /*while(b < niz2.length) {
            zajednicki[c] = niz2[b];
            b++;
            c++;
        }*/

        for (int j : zajednicki) {
            System.out.print(j + " ");
        }
    }
}
