package common.bankarskiSistem;

/**
 * Kurs klasa u sebi sadrzi tabelu kurseva za EUR,RSD i USD.
 * Tabela je predstavljena preko matrice redom kolone i redovi : EUR, RSD, USD.
 * U tabeli je predstavljena vrstom jedinica valute u vrednosti druge valute sa presekom odgovarajuce kolone.
 */
public class Kurs {

    float[][] kursnaLista;
    public Kurs(float[][] kursnaLista) {
        if (kursnaLista == null) throw new NullPointerException("Null kursna lista");
        if (kursnaLista.length != 3) throw new IndexOutOfBoundsException("Kurs treba da ima 3 valute");
        for (float[] vrsta : kursnaLista) {
            if (vrsta.length != 3) throw new IndexOutOfBoundsException("Kurs treba da ima 3 valute");
        }
        this.kursnaLista = kursnaLista;
    }

    /**
     * Konvertovanje iz jedne valute u drugu valutu.
     * @param from - valuta iz koje se konvertuje
     * @param to - valuta u koju se konvertuje
     * @return - konvertovana vrednost jedinice valute
     *
     * {@code convert(EUR,RSD)} konveruje se 1 euro u dinare i vrednost je prema kursu 117,3
     */

    public float convert(Valuta from, Valuta to){
        if (from == null || to == null) throw new NullPointerException("Null valuta");
        return kursnaLista[from.ordinal()][to.ordinal()];
    }

    @Override
    public String toString() {
        StringBuilder kursnaListaString = new StringBuilder();
        kursnaListaString.append("\nEUR\tRSD\tUSD\n");

        for (float[] vrsta : kursnaLista) {
            for (float kolona : vrsta)
                kursnaListaString.append(kolona).append("\t");
            kursnaListaString.append("\n");
        }
        
        return kursnaListaString.toString();
    }
}
