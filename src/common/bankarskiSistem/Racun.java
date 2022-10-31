package common.bankarskiSistem;

import java.util.concurrent.atomic.AtomicInteger;

public class Racun {
    private float stanje;
    private final int brojRacuna;
    private static final AtomicInteger count = new AtomicInteger(0);

    private Valuta valuta;
    private Tip tipRacuna;
    private Korisnik korisnik;
    private Banka banka;

    public Racun(Tip tipRacuna,Valuta valuta, Korisnik korisnik, Banka banka) {
        this.tipRacuna = tipRacuna;
        this.stanje = 0;
        this.valuta = valuta;
        brojRacuna = count.incrementAndGet();
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

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
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

    public Tip getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(Tip tipRacuna) {
        this.tipRacuna = tipRacuna;
    }
}
