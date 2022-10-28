package common.bankarskiSistem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankarskiSistem {
        public static void main(String[] args) {

            ArrayList<Banka> banke = new ArrayList<>();
            banke.add(new Banka("Intesa", "Adresa 1", new Kurs(new float[][] {
                    {1F, 117.3F, .98F},
                    {.0085F, 1F, .0083F},
                    {1.02F, 120.04F, 1F}
            })));
            banke.add(new Banka("Erste", "Adresa 2", new Kurs(new float[][] {
                    {1F, 117.3F, .95F},
                    {.0083F, 1F, .0080F},
                    {1.05F, 121.04F, 1F}
            })));

            Banka banka = odabirBanke(banke);
            Korisnik korisnik = kreirajKorisnika();
            napraviRacune("devizni", korisnik, banka);
        }

    private static Korisnik kreirajKorisnika() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite ime, prezime, adresu i jmbg: ");
        String ime = "", prezime = "", adresa = "", jmbg = "";

        ime = sc.nextLine();
        prezime = sc.nextLine();
        adresa = sc.nextLine();
        jmbg = sc.nextLine();

        sc.close();

        return new Korisnik(ime, prezime, adresa, jmbg);
    }

    private static Banka odabirBanke(ArrayList<Banka> banke) {
        for (int i = 0; i < banke.size(); i++) {
            System.out.println(i+1 + ")");
            System.out.println(banke.get(i));
            System.out.println();
        }
        System.out.println("Odaberi redni broj banke: ");
        Scanner sc = new Scanner(System.in);
        int odabir = -1;
        if (sc.hasNextInt()) {
            odabir = sc.nextInt();
        }
        sc.close();

        if (odabir <= 0 || odabir > banke.size())
            throw new IndexOutOfBoundsException("Nevalidan broj banke");

        return banke.get(odabir-1);
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
