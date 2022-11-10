package velickovj.nedelja04;

public class Proizvod {
    private String ime;
    private double cena;
    private double vrednost;

    Proizvod(String ime, double cena, double vrednost){
        this.ime=ime;
        this.cena=cena;
        this.vrednost=vrednost;
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

    public String toString(){
        return "Proizvod: "+ime+" sa cenom: "+cena+" i vrednoscu: "+vrednost;
    }
}
