package tamara.zadaci;

public class DvaNajmanjaBroja {
    public static void main(String[] args) {
        int[] niz = {5, 7, -2, -1, 0};

        if(niz.length == 0) {
            System.out.println("Niz je prazan. ");
            return;
        }

        if(niz.length == 1) {
            System.out.println("Niz ima samo jedan element.");
            return;
        }

        int minEl = niz[0];
        int minEl2 = niz[0];
        int index = 0;

        for (int i = 0; i < niz.length; i++) {
            if (niz[i] < minEl) {
                minEl = niz[i];
                index = i;
            }
            if (niz[i] < minEl2 && index != i) {
                minEl2 = niz[i];
            }
        }

        System.out.println(minEl + " " + minEl2);

    }
}
