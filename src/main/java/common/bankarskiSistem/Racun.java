package common.bankarskiSistem;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Klasa racun sadrzi jedinstveni broj racuna koji pripada samo jednom {@link Korisnik}
 * i stanje raspolozovih sredstava u odredjenoj valuti.
 * Racun pipada samo jednoj banci i samo jednom korisniku i definisan je tip racuna
 * {@link Tip}
 */

public class Racun {
    private float stanje;
    private final int brojRacuna;
    private static final AtomicInteger count = new AtomicInteger(0);

    private Valuta valuta;
    private Tip tipRacuna;
    private Korisnik korisnik;
    private Banka banka;

    private int idValuta, idTip, idKorisnik, idBanka;

    public Racun(Tip tipRacuna, Valuta valuta, Korisnik korisnik, Banka banka) {
        if(tipRacuna == null || valuta == null || korisnik == null || banka == null) {
            throw new NullPointerException("Konstruktor ne prima null vrednosti");
        }
        this.idValuta = valuta.ordinal();
        this.idTip = tipRacuna.ordinal();
        this.idKorisnik = korisnik.getIdKorisnik();
        this.idBanka = banka.getIdBanke();
        this.tipRacuna = tipRacuna;
        this.stanje = 0;
        this.valuta = valuta;
        brojRacuna = count.incrementAndGet();
        this.korisnik = korisnik;
        this.banka = banka;
    }

    public int getIdValuta() {
        return idValuta;
    }

    public int getIdTip() {
        return idTip;
    }

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public int getIdBanka() {
        return idBanka;
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
        if(valuta == null) throw new NullPointerException("Prosledjena valuta je null");
        this.valuta = valuta;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        if(korisnik == null) throw new NullPointerException("Prosledjen korisnik je null");
        this.korisnik = korisnik;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        if(banka == null) throw new NullPointerException("Prosledjena banka je null");
        this.banka = banka;
    }

    public Tip getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(Tip tipRacuna) {
        if(tipRacuna == null) throw new NullPointerException("Prosledjen tip racuna je null");
        this.tipRacuna = tipRacuna;
    }
}
