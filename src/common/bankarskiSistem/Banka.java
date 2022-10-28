package common.bankarskiSistem;

import java.util.ArrayList;
import java.util.List;

public class Banka {
    private String ime;
    private String adresa;
    private List<Korisnik> korisnici;
    private Kurs kurs;

    public Banka(String ime, String adresa, Kurs kurs) {
        this.ime = ime;
        this.adresa = adresa;
        this.korisnici = new ArrayList<>();
        this.kurs = kurs;
    }

    public Banka(String ime, String adresa, List<Korisnik> korisnici, Kurs kurs) {
        this.ime = ime;
        this.adresa = adresa;
        this.korisnici = korisnici;
        this.kurs = kurs;
    }

    public Banka() {
        this.korisnici = new ArrayList<>();
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

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public void dodajRacun(Racun racun, Korisnik korisnik) {
        if(korisnici.contains(korisnik)) {
            korisnik.getRacuni().add(racun);
        }
        else {

            korisnici.add(korisnik);
            korisnik.getRacuni().add(racun);
        }
    }

    public void obrisiRacun(Racun racun) {
        Korisnik korisnik = racun.getKorisnik();
        korisnik.getRacuni().remove(racun);
    }

    public void prebaciNovacKorisniku(Korisnik posiljalac, Racun racunPosiljalaca, Korisnik primalac,
                                      Racun racunPrimalaca, float iznos){
        if(racunPosiljalaca.getValuta() != racunPrimalaca.getValuta()){
            iznos *= kurs.convert(racunPosiljalaca.getValuta(), racunPrimalaca.getValuta());
            primalac.uplata(racunPrimalaca, iznos);
            posiljalac.isplata(racunPosiljalaca, iznos);
        } else{
            primalac.uplata(racunPrimalaca, iznos);
            posiljalac.isplata(racunPosiljalaca, iznos);
        }

    }

    public Korisnik nadjiKorisnika(String jmbg){
        for (Korisnik k : korisnici){
            if (k.getJmbg().equals(jmbg)) return k;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banka: " + ime + " na adresi: " + adresa + "\nKursna lista: " + getKurs().toString();
    }
}
