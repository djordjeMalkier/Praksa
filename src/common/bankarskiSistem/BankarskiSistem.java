package common.bankarskiSistem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

            ArrayList<Racun> racuni = new ArrayList<>();
            ArrayList<Racun> racuni2 = new ArrayList<>();

            Banka bankaIntesa = new Banka("Intesa", "Adresa 1", new Kurs(kursnaLista1));
            Banka bankaErste = new Banka("Erste", "Adresa 2", new Kurs(kursnaLista2));

            Korisnik korisnik = new Korisnik("Pera", "Peric", "Topolska 18", "2001999710033");
            Korisnik korisnik2 = new Korisnik("Marko", "Markovic", "Topolska 19", "1001989710043");
            Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, 100, korisnik2, bankaErste);


            Scanner sc = new Scanner(System.in);
            StringBuilder tip = new StringBuilder();
            System.out.println("Tip: ");

            if(sc.hasNextLine()){
                tip.append(sc.nextLine());
            }

            if(tip.isEmpty())  return;

            racuni = napraviRacune(tip.toString(), korisnik, bankaIntesa);
            racuni2 = napraviRacune(tip.toString(), korisnik2,bankaErste);

            if(!racuni.isEmpty()) {
                for (Racun racun : racuni) {
                    bankaIntesa.dodajRacun(racun, korisnik);
                }
            }

            korisnik.uplata(racuni.get(0), 100);

<<<<<<< Updated upstream
            korisnik.zatvoriSveRacune(Tip.DEVIZNI);
            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR));
=======
            bankaIntesa.prebaciNovacKorisniku(korisnik, racuni.get(0), korisnik2, racun3, 23);

            korisnik2.stanjeSvihRacuna(Valuta.RSD);
>>>>>>> Stashed changes

        }

        private static ArrayList<Racun> napraviRacune(String tip, Korisnik korisnik, Banka banka){
            ArrayList<Racun> racuni = new ArrayList<>();
            if(tip.toUpperCase().equals(Tip.DEVIZNI.toString())){
                Racun racun = new Racun(Tip.DEVIZNI,Valuta.EUR, 123, korisnik, banka);
                Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, 100, korisnik, banka);
                racuni.add(racun);
                racuni.add(racun3);
            }
            else if (tip.toUpperCase().equals(Tip.DINARSKI.toString())){
                Racun racun2 = new Racun(Tip.DINARSKI,Valuta.RSD, 124, korisnik, banka);
                racuni.add(racun2);
            }
            return racuni;
        }
}
