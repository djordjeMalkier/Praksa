package common.bankarskiSistem;

public class Kurs {

    float[][] kursnaLista;
    public Kurs(float[][] kursnaLista) {
        this.kursnaLista = kursnaLista;
    }

    public float convert(Valuta from, Valuta to){
        return kursnaLista[from.ordinal()][to.ordinal()];
    }
}
