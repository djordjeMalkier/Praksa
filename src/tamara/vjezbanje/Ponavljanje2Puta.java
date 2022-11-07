package tamara.vjezbanje;

import java.util.ArrayList;
import java.util.List;

//prikazati elemente koji se pojavljuju tacno dva puta
public class Ponavljanje2Puta {
    public static void main(String[] args) {
        int[] zadatiNiz = {12, 5, -1, 12, 6, 3, 3, 12, -1, 6, 12, -1};
        List<Integer> viseOd2Puta = new ArrayList<>();
        boolean tacno2Puta = false;

        for (int i = 0; i < zadatiNiz.length; i++) {
            int brojPonavljanja = 0;
            for (int j = i; j < zadatiNiz.length; j++) {
                if(zadatiNiz[i] == zadatiNiz[j]) {
                    brojPonavljanja++;
                    if(brojPonavljanja > 2)
                        viseOd2Puta.add(zadatiNiz[i]);
                }
            }
            if(brojPonavljanja == 2 && !viseOd2Puta.contains(zadatiNiz[i])) {
                System.out.print(zadatiNiz[i] + " ");
                tacno2Puta = true;
            }
        }

        if(!tacno2Puta)
            System.out.println("Nijedan element se ne ponavlja tacno 2 puta.");

    }
}
