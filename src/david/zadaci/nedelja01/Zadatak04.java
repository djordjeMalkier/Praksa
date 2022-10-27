package david.zadaci.nedelja01;

import java.util.*;

/*
 * Za niz brojeva ispisati
 * sve brojeve koji se pojavljuju tacno jednom
 * i koji od njih se pojavljuje najvise puta
 * */
public class Zadatak04 {
        public static void main(String[] args) {
            int[] num_array = {6, 6, 1, 4, 5, 6, 10, 15, 1};

            jedno_ponavljanje(izracunaj_broj_ponavljanja(num_array));
            System.out.print("Najcesce se ponavlja: ");
            System.out.println(max_ponavljanja(izracunaj_broj_ponavljanja(num_array)));
        }

    private static int max_ponavljanja(Map<Integer, Integer> mapa_ponavljanja) {
        int max = -1;
        int max_value = -1;
        for (Integer key:  mapa_ponavljanja.keySet()) {
            if (mapa_ponavljanja.get(key) > max_value) {
                max_value = mapa_ponavljanja.get(key);
                max = key;
            }
        }
        return max;
    }

    private static void jedno_ponavljanje(Map<Integer, Integer> mapa_ponavljanja) {
        for (Integer key:  mapa_ponavljanja.keySet()) {
            if (mapa_ponavljanja.get(key) == 1)
                System.out.println(key);
        }
    }

    private static Map<Integer, Integer> izracunaj_broj_ponavljanja(int[] num_array) {
        if (num_array == null)
            throw new NullPointerException("Prazna mapa");

        Map<Integer, Integer> mapa_ponavljanja = new HashMap<>();
        for (int num: num_array) {
            if (mapa_ponavljanja.containsKey(num))
                mapa_ponavljanja.put(num, mapa_ponavljanja.get(num) + 1);
            else
                mapa_ponavljanja.put(num, 1);
        }
        return mapa_ponavljanja;
    }
}
