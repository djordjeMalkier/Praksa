package common.bankarskiSistem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Klasa racun sadrzi jedinstveni broj racuna koji pripada samo jednom {@link Korisnik}
 * i stanje raspolozovih sredstava u odredjenoj valuti.
 * Racun pipada samo jednoj banci i samo jednom korisniku i definisan je tip racuna
 * {@link Tip}
 */
@Entity
@Table (name = "Racun")
@Getter
@Setter
@NoArgsConstructor
public class Racun {
    @Column(name = "stanje", nullable = false)
    private float stanje;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brojRacuna", nullable = false)
    private Integer brojRacuna;

    @ManyToOne
    @JoinColumn(name="idValuta")
    private Valuta valuta;
    @ManyToOne
    @JoinColumn(name="idTip")
    private Tip tipRacuna;
    @ManyToOne
    @JoinColumn(name="idKorisnik")
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name="idBanka")
    private Banka banka;
    @Column(name = "idValuta", nullable = false)
    private int idValuta;
    @Column(name = "idTip", nullable = false)
    private int idTip;
    @Column(name = "idKorisnik", nullable = false)
    private int idKorisnik;
    @Column(name = "idBanka", nullable = false)
    private int idBanka;

    public Racun(Tip tipRacuna, Valuta valuta, Korisnik korisnik, Banka banka, int brojRacuna) {
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
        this.brojRacuna = brojRacuna;
        this.korisnik = korisnik;
        this.banka = banka;
    }

    public Racun(Tip tipRacuna, Valuta valuta, Korisnik korisnik, Banka banka, float stanje, int brojRacuna) {
        this(tipRacuna,valuta,korisnik,banka, brojRacuna);
        this.stanje = stanje;
    }


    @Override
    public String toString() {
        return "Racun{" +
                "stanje=" + stanje +
                ", brojRacuna=" + brojRacuna +
                ", valuta=" + valuta +
                ", tipRacuna=" + tipRacuna +
                ", korisnik=" + korisnik +
                ", banka=" + banka +
                ", idValuta=" + idValuta +
                ", idTip=" + idTip +
                ", idKorisnik=" + idKorisnik +
                ", idBanka=" + idBanka +
                '}';
    }
}
