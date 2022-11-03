package common.bankarskiSistem.Test;

import common.bankarskiSistem.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankarskiSistemTest {
    private final Banka banka = new Banka("Intesa", "Adresa 1", new Kurs(new float[][] {
        {1F, 117.3F, .98F},
        {.0085F, 1F, .0083F},
        {1.02F, 120.04F, 1F}
    }));

    private final Korisnik korisnik1 = new Korisnik("Pera", "Petrovic", "Adresa 2", "1001995710453");
    private final Korisnik korisnik2 = new Korisnik("Mika", "Petrovic", "Adresa 2", "2001995720075");
    private final Korisnik korisnik3 = new Korisnik("Zika", "Petrovic", "Adresa 2", "3101995710135");

    private final Racun racun1 = new Racun(Tip.DEVIZNI, Valuta.EUR, korisnik1, banka);
    private final Racun racun2 = new Racun(Tip.DEVIZNI, Valuta.USD, korisnik2, banka);
    private final Racun racun3 = new Racun(Tip.DINARSKI, Valuta.RSD, korisnik3, banka);



    private void initBankSystem() {
        banka.dodajRacun(racun1, korisnik1);
        banka.dodajRacun(racun2, korisnik2);
        banka.dodajRacun(racun3, korisnik3);
    }

    @Test
    void uplataRacunaIstaValuta() {
        initBankSystem();
        int iznosUplate = 158;

        korisnik1.uplata(racun1, iznosUplate);

        assertEquals(iznosUplate, korisnik1.proveraStanja(racun1, Valuta.EUR));
    }

    @Test
    void uplataRacunaRazlicitaValuta() {
        initBankSystem();
        int iznosUplate = 158;
        Valuta valutaZaPrikaz = Valuta.RSD;

        korisnik1.uplata(racun1, iznosUplate);

        assertEquals(iznosUplate * banka.getKurs().convert(racun1.getValuta(), valutaZaPrikaz),
                korisnik1.proveraStanja(racun1, valutaZaPrikaz));
    }

    @Test
    void prebaciNovacKorisnikuTest() {
        initBankSystem();
        int stanjeRacunaKorisnik1 = 1000;
        korisnik1.uplata(racun1, stanjeRacunaKorisnik1);
        int iznos = 158;
        float konverzija = banka.getKurs().convert(racun1.getValuta(), racun2.getValuta());

        banka.prebaciNovacKorisniku(korisnik1, racun1, korisnik2, racun2, iznos);

        assertEquals(stanjeRacunaKorisnik1 - (iznos * konverzija),
                korisnik1.proveraStanja(racun1, Valuta.EUR));
        assertEquals(iznos * konverzija, korisnik2.proveraStanja(racun2, Valuta.USD));
    }

    @Test
    void odViseKorisnikaVracaTrazenogKorisnika() {
        initBankSystem();
        assertEquals(korisnik1, banka.nadjiKorisnika("1001995710453"));
    }

    @Test
    void odViseKorisnikaVracaNullAkoKorisnikNePostoji() {
        initBankSystem();
        assertNull(banka.nadjiKorisnika("1001000010453"));
    }

    @Test
    void odKorisnikaSa1RacunVracaStanje() {
        initBankSystem();
        korisnik1.uplata(racun1, 100);
        assertEquals(100, korisnik1.stanjeSvihRacuna(Valuta.EUR));
    }

    @Test
    void odKorisnikaSaViseRacunaVracaStanje() {
        initBankSystem();
        korisnik1.uplata(racun1, 100); //EUR
        banka.dodajRacun(racun2, korisnik1);
        korisnik1.uplata(racun2, 1000); //USD

        assertEquals(100 + 1000*banka.getKurs().convert(Valuta.USD, Valuta.EUR),
                     korisnik1.stanjeSvihRacuna(Valuta.EUR));
    }

    @Test
    void odKorisnikaSaViseRacunaZatvaraSveRacuneDatogTipa() {
        initBankSystem();
        banka.dodajRacun(racun2, korisnik1);
        banka.dodajRacun(racun3, korisnik1); //DINARSKI ostaje

        korisnik1.zatvoriSveRacune(Tip.DEVIZNI);

        assertEquals(1, korisnik1.getRacuni().size());
    }

    @Test
    void akoNePostojiRacunNistaNijeObrisano() {
        initBankSystem();
        banka.dodajRacun(racun2, korisnik1);

        korisnik1.zatvoriSveRacune(Tip.DINARSKI);

        assertEquals(2, korisnik1.getRacuni().size());
    }

    @Test
    void akoNePostojiRacunObrisiVracaFalse() {
        initBankSystem();
        banka.dodajRacun(racun2, korisnik1);

        assertFalse(korisnik1.obrisiRacun(racun3));
    }
}