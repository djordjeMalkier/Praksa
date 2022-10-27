package zivkovicj.bankarskiSistem;

import java.util.*;

public class Banka {
    private String ime;
    private String adresa;
    private Map<Korisnik, ArrayList<Racun>> racuni;
    private Map<VALUTE, Float> kurs;

    public Banka(String ime, String adresa, Map<VALUTE, Float> kurs) {
        this.ime = ime;
        this.adresa = adresa;
        this.racuni = new HashMap<>();
        this.kurs = kurs;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Map<Korisnik, ArrayList<Racun>> getRacuni() {
        return racuni;
    }

    public void setRacuni(Map<Korisnik, ArrayList<Racun>> racuni) {
        this.racuni = racuni;
    }

    public Map<VALUTE, Float> getKurs() {
        return kurs;
    }

    public void setKurs(Map<VALUTE, Float> kurs) {
        this.kurs = kurs;
    }

    public void dodajRacun(Korisnik korisnik, Racun racun){
        if(racuni.containsKey(korisnik)){
            racuni.get(korisnik).add(racun);
        } else {
            ArrayList<Racun> new_racun = new ArrayList<>();
            new_racun.add(racun);
            racuni.put(korisnik, new_racun);
        }
        korisnik.getRacuni().add(racun);
    }
}
