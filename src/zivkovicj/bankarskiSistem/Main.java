package zivkovicj.bankarskiSistem;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<VALUTE, Float> kurs = new HashMap<>();
        kurs.put(VALUTE.EUR, 1F);
        kurs.put(VALUTE.USD, 1.1F);
        kurs.put(VALUTE.RSD, 117F);
        Korisnik korisnikIntesa = new Korisnik("Jovana", "Zivkovic", "1002948989", "Karlovacka");
        Banka bankaIntesa = new Banka("Banca Intesa", "Cara Dusana", kurs);
        Racun racun = new Racun(VALUTE.EUR, 111, korisnikIntesa, bankaIntesa);
        Racun racun2 = new Racun(VALUTE.RSD, 222, korisnikIntesa, bankaIntesa);

        // racun 1 eur
        System.out.println("Racun 1 EUR:");
        bankaIntesa.dodajRacun(korisnikIntesa, racun);
        korisnikIntesa.uplata(racun, 5000);
        korisnikIntesa.proveraStanja(racun, VALUTE.EUR);
        korisnikIntesa.isplata(racun, 5000);
        korisnikIntesa.proveraStanja(racun, VALUTE.EUR);

        // racun 2 rsd
        System.out.println("Racun 2 RSD:");
        bankaIntesa.dodajRacun(korisnikIntesa, racun2);
        korisnikIntesa.uplata(racun2, 12000);
        korisnikIntesa.proveraStanja(racun2, VALUTE.RSD);
        korisnikIntesa.isplata(racun2, 1000);
        korisnikIntesa.proveraStanja(racun2, VALUTE.RSD);

        korisnikIntesa.stanjeSvihRacuna(VALUTE.RSD);
    }
}