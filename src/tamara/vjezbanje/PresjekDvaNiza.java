package tamara.vjezbanje;

import java.util.ArrayList;
import java.util.List;

//naci presjek dva niza
public class PresjekDvaNiza {
    public static void main(String[] args) {
        int[] zadatiNiz1 = {5, -1, 12, 6, 3, 3, 4, -1};
        int[] zadatiNiz2 = {2, 8, -6, 7, 3, 1, -1, 3, 3, -1};
        List<Integer> listaPosjecenihIndeksa = new ArrayList<>();

        for (int element1 : zadatiNiz1) {
            int brojPojavljivanja = 0;
            for (int j = 0; j < zadatiNiz2.length; j++) {
                if (element1 == zadatiNiz2[j] && brojPojavljivanja == 0 && !listaPosjecenihIndeksa.contains(j)) {
                    brojPojavljivanja++;
                    listaPosjecenihIndeksa.add(j);
                    System.out.print(element1 + " ");
                }
            }
        }

        if(listaPosjecenihIndeksa.isEmpty())
            System.out.println("Ne postoji presjek.");

    }
}
