package tamara.zadaci;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SvakiDrugiVeciOdSusjeda {
    public static void main(String[] args) {
        //int[] niz = {5, 8, 0, 1, 7, 6};
        int[] niz = IntStream.range(0,100).toArray();
        int[] novi = new int[niz.length];

        Arrays.sort(niz);

        int i = 0, j = 0;

        while(i < niz.length && j < novi.length) {
            novi[j] = niz[i];
            j++;
            if(i+2 < niz.length) {
                novi[j] = niz[i + 2];
           }
            i++; j++;
        }

        for (int n : novi) {
            System.out.print(n + " ");
        }
    }


}
