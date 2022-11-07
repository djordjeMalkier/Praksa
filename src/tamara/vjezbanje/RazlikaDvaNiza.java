package tamara.vjezbanje;

import java.util.ArrayList;
import java.util.List;

//razlika dva niza
public class RazlikaDvaNiza {
    public static void main(String[] args) {
        int[] zadatiNiz1 = {4, 5, 8, -3, 12, -4, 4};
        int[] zadatiNiz2 = {10, -8, -3, 12, 12, 4};
        List<Integer> listaPosjecenihIndeksa1 = new ArrayList<>();
        List<Integer> listaPosjecenihIndeksa2 = new ArrayList<>();
        List<Integer> razlika = new ArrayList<>();


        for (int i = 0; i < zadatiNiz1.length; i++) {
            int brojPonavljanja = 0;
            for (int j = 0; j < zadatiNiz2.length; j++) {
                if(zadatiNiz1[i] == zadatiNiz2[j] && !listaPosjecenihIndeksa1.contains(j) && brojPonavljanja == 0) {
                    brojPonavljanja++;
                    listaPosjecenihIndeksa1.add(j);
                }
            }
            if(brojPonavljanja == 0)
                razlika.add(zadatiNiz1[i]);
        }

        for (int i = 0; i < zadatiNiz2.length; i++) {
            int brojPonavljanja = 0;
            for (int j = 0; j < zadatiNiz1.length; j++) {
                if(zadatiNiz2[i] == zadatiNiz1[j] && !listaPosjecenihIndeksa2.contains(j) && brojPonavljanja == 0) {
                    brojPonavljanja++;
                    listaPosjecenihIndeksa2.add(j);
                }
            }
            if(brojPonavljanja == 0)
                razlika.add(zadatiNiz2[i]);
        }

        if(razlika.isEmpty()) System.out.println("Ne postoji razlika dva niza.");
        else System.out.println("Razlika: " + razlika);
    }
}
