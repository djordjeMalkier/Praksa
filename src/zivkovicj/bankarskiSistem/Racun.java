package zivkovicj.bankarskiSistem;

enum VALUTE{
    RSD,
    EUR,
    USD
}
public class Racun {

    private float stanje;
    private VALUTE tipRacuna;
    private Integer brojRacuna;
    private Korisnik korisnik;
    private Banka banka;

    public Racun(VALUTE tipRacuna, Integer brojRacuna, Korisnik korisnik, Banka banka) {
        this.stanje = 0;
        this.tipRacuna = tipRacuna;
        this.brojRacuna = brojRacuna;
        this.korisnik = korisnik;
        this.banka = banka;
    }

    public Float getStanje() {
        return stanje;
    }

    public void setStanje(Float stanje) {
        this.stanje = stanje;
    }

    public VALUTE getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(VALUTE tipRacuna) {
        this.tipRacuna = tipRacuna;
    }

    public Integer getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Integer brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }
}
