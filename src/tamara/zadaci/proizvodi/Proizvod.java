package tamara.zadaci.proizvodi;

public class Proizvod {
    String ime;
    double cijena;
    double vrijednost;

    public Proizvod(String ime, double cijena, double vrijednost) {
        this.ime = ime;
        this.cijena = cijena;
        this.vrijednost = vrijednost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public double getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(double vrijednost) {
        this.vrijednost = vrijednost;
    }

    public void setVrijednost(int vrijednost) {
        this.vrijednost = vrijednost;
    }

    @Override
    public String toString() {
        return ime;
    }
}
