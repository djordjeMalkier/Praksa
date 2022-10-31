package common.bankarskiSistem;

public class Kurs {

    float[][] kursnaLista;
    public Kurs(float[][] kursnaLista) {
        if (kursnaLista == null) throw new NullPointerException("Null kursna lista");
        this.kursnaLista = kursnaLista;
    }

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
