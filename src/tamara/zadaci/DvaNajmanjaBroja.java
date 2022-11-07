package tamara.zadaci;

public class DvaNajmanjaBroja {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, 7, -2, -1, 0};

        if(zadatiNiz.length == 0) {
            System.out.println("Niz je prazan. ");
            return;
        }

        if(zadatiNiz.length == 1) {
            System.out.println("Niz ima samo jedan element.");
            return;
        }

        int minEl = zadatiNiz[0];
        int minEl2 = zadatiNiz[0];
        int index = 0;

        for (int i = 0; i < zadatiNiz.length; i++) {
            if (zadatiNiz[i] < minEl) {
                minEl = zadatiNiz[i];
                index = i;
            }
            if (zadatiNiz[i] < minEl2 && index != i) {
                minEl2 = zadatiNiz[i];
            }
        }

        System.out.println(minEl + " " + minEl2);

    }
}
