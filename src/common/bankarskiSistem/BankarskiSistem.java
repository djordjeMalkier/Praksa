package common.bankarskiSistem;

public class BankarskiSistem {
        public static void main(String[] args) {

            float[][] kursnaLista1 = {
                    {1F, 117.3F, .98F},
                    {.0085F, 1F, .0083F},
                    {1.02F, 120.04F, 1F}
            };
            float[][] kursnaLista2 = {
                    {1F, 117.3F, .95F},
                    {.0083F, 1F, .0080F},
                    {1.05F, 121.04F, 1F}
            };

            Banka bankaIntesa = new Banka("Intesa", "Adresa 1", new Kurs(kursnaLista1));
            Banka bankaErste = new Banka("Erste", "Adresa 2", new Kurs(kursnaLista2));

            Korisnik korisnik = new Korisnik("Pera", "Peric", "Topolska 18", "2001999710033");
            Korisnik korisnik2 = new Korisnik("Marko", "Markovic", "Topolska 19", "1001989710043");

            Racun racun = new Racun(Tip.DEVIZNI,Valuta.EUR, 123, korisnik, bankaIntesa);
            Racun racun2 = new Racun(Tip.DINARSKI,Valuta.RSD, 124, korisnik, bankaIntesa);
            Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, 100, korisnik, bankaErste);

            bankaIntesa.dodajRacun(racun, korisnik);
            bankaIntesa.dodajRacun(racun2, korisnik);
            bankaErste.dodajRacun(racun3, korisnik2);
            korisnik.uplata(racun, 1000); //1000 eur
            korisnik.uplata(racun2, 11700);  //din - 99e

            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR));

            korisnik.isplata(racun, 1000);
            korisnik.stanjeSvihRacuna(Valuta.RSD);

            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR));

        }
}
