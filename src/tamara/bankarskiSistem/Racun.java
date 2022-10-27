package tamara.bankarskiSistem;

public class Racun {
    private float stanje;
    private int brojRacuna;
    private Valuta tipRacuna;
    private Korisnik korisnik;
    private Banka banka;

    public Racun(Valuta tipRacuna, int brojRacuna, Korisnik korisnik, Banka banka) {
        this.stanje = 0;
        this.tipRacuna = tipRacuna;
        this.brojRacuna = brojRacuna;
        this.korisnik = korisnik;
        this.banka = banka;
    }

    public float getStanje() {
        return stanje;
    }

    public void setStanje(float stanje) {
        this.stanje = stanje;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Valuta getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(Valuta tipRacuna) {
        this.tipRacuna = tipRacuna;
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
