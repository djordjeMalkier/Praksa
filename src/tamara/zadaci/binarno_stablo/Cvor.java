package tamara.zadaci.binarno_stablo;

public class Cvor {
    int vrijednost;
    Cvor lijevo;
    Cvor desno;
    int visina;

    public Cvor(int vrijednost) {
        this.vrijednost = vrijednost;
        visina = 1;
    }

    public int getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(int vrijednost) {
        this.vrijednost = vrijednost;
    }

    public Cvor getLijevo() {
        return lijevo;
    }

    public void setLijevo(Cvor lijevo) {
        this.lijevo = lijevo;
    }

    public Cvor getDesno() {
        return desno;
    }

    public void setDesno(Cvor desno) {
        this.desno = desno;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }
}
