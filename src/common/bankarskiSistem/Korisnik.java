package common.bankarskiSistem;

import java.util.ArrayList;
import java.util.List;

public class Korisnik {
    private String ime;
    private String prezime;
    private String jmbg;
    private String adresa;
    private List<Racun> racuni;


    public Korisnik(String ime, String prezime, String adresa, String jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.jmbg = jmbg;
        this.racuni = new ArrayList<>();
    }

    public Korisnik(String ime, String prezime, String jmbg, String adresa, List<Racun> racuni) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.racuni = racuni;
    }

    public Korisnik(){
        this.racuni = new ArrayList<>();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }

    public float stanjeSvihRacuna(Valuta valuta) {
        float sum = 0;
        for (Racun racun: racuni ) {
            sum += proveraStanja(racun, valuta);
        }
        return sum;
    }

    public float proveraStanja(Racun racun, Valuta valuta) {
        return racun.getStanje() * racun.getBanka().getKurs().convert(racun.getValuta(), valuta);
    }

    public float uplata(Racun racun, float iznos) {
        racun.setStanje(racun.getStanje() + iznos);
        return iznos;
    }

    public float isplata(Racun racun, float iznos) {
        if(iznos > racun.getStanje()) {
            System.out.println("Iznos je veci od stanja na racunu. ");
            return -1;
        }
        else {
            System.out.println("Uspjesno.");
            racun.setStanje(racun.getStanje() - iznos);
            //funkcija signum gleda i najmanju vrijednost ako ima razlike, jer poredjenje float-a sa 0 ne bi radilo
            if (Math.signum(racun.getStanje()) == 0)
                obrisiRacun(racun);
        }
        return iznos;
    }
    public void transferIzmedjuRacuna(Racun saRacuna, Racun naRacun, float iznos) {
        if(saRacuna.getValuta() != naRacun.getValuta()) {
            isplata(saRacuna, iznos);
               float konvertovanaValuta = saRacuna.getBanka().getKurs().convert(saRacuna.getValuta(), naRacun.getValuta());
               iznos *= konvertovanaValuta;
               uplata(naRacun, iznos);
        } else {
            isplata(saRacuna, iznos);
            uplata(naRacun, iznos);
        }

    }

    public void zatvoriSveRacune(Tip tipRacuna) {
        for (Racun racun : racuni)
            if (racun.getTipRacuna() == tipRacuna)
                obrisiRacun(racun);
    }

    private boolean obrisiRacun(Racun racun) {
        if (racun == null) throw new NullPointerException("Nije prosledjen racun");
        return racuni.remove(racun);
    }
}
