package tamara.zadaci;

public class NajduzaSortiranaSekvenca {
    public static void main(String[] args) {
        int[] niz = {1, 2, 1, 2, 3, -1, 0, 1, 2, 3, 4, 3, 2};
        int duzina = 1;
        int maxDuzina = 0;
        int glavni = 0;
        int pocetak = 0;

        for (int i = 0; i < niz.length - 1; i++) {

            if(niz[i] <= niz[i+1]) {
                if(duzina == 1)
                    pocetak = i;
                duzina++;

            } else if (niz[i] > niz[i+1]) {
                if(duzina > maxDuzina) {
                    maxDuzina = duzina;
                    glavni = pocetak;
                }

                duzina = 1;
            }
        }

        while(maxDuzina > 0) {
            System.out.print(niz[glavni++]);
            maxDuzina--;
        }

        System.out.println("\n\nMaksimalna duzina je: " + maxDuzina + "\n");

    }

}
