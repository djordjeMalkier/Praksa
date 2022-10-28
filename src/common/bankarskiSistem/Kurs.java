package common.bankarskiSistem;

public class Kurs {

    float[][] kursnaLista;
    public Kurs(float[][] kursnaLista) {
        this.kursnaLista = kursnaLista;
    }

    public float convert(Valuta from, Valuta to){
        return kursnaLista[from.ordinal()][to.ordinal()];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEUR\tRSD\tUSD\n");

        for (int i = 0; i < kursnaLista.length; i++) {
            for (int j = 0; j < kursnaLista[i].length; j++)
                sb.append(kursnaLista[i][j] + "\t");
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
