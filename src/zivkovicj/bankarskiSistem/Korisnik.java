package zivkovicj.bankarskiSistem;

import java.util.ArrayList;
import java.util.List;

public class Korisnik {
    private String ime;
    private String prezime;
    private String jmbg;
    private String adresa;
    private List<Racun> racuni;

    public Korisnik(String ime, String prezime, String jmbg, String adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
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

    public void stanjeSvihRacuna(VALUTE valuta){
        for (Racun racun : racuni){
            System.out.print("Broj racuna ");
            System.out.print(racun.getBrojRacuna() + " ");
            proveraStanja(racun, valuta);
        }
    }

    public void proveraStanja(Racun racun, VALUTE valuta){
        System.out.print("Stanje: ");
        System.out.println(racun.getStanje() + " " +
                racun.getTipRacuna());
    }

    public void uplata(Racun racun, float iznos){
        racun.setStanje(racun.getStanje() + iznos);
    }

    public void isplata(Racun racun, float iznos){
        if(iznos > racun.getStanje()){
            System.out.println("Nedovoljno sredstva na racunu");
        } else {
            racun.setStanje(racun.getStanje() - iznos);
            if(Math.signum(racun.getStanje()) == 0){
                racuni.remove(racun);
            }
        }
    }
}
