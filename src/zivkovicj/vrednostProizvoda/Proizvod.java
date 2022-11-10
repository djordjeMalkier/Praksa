package zivkovicj.vrednostProizvoda;



public class Proizvod implements Comparable<Proizvod> {
    String ime;
    double cena;
    double vrednost;

    public Proizvod(String ime, double cena, double vrednost) {
        this.ime = ime;
        this.cena = cena;
        this.vrednost = vrednost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    @Override
    public String toString() {
        return
                ime + " " + cena + " din. " + " (vrednost: " + vrednost + ")\n";
    }


    @Override
    public int compareTo(Proizvod p) {
        return Double.compare(vrednost, p.vrednost);
    }
}
