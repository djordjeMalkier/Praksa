package common.bankarskiSistem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankarskiSistem {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
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

            while(true) {
                Banka banka = odabirBanke(banke, sc);
                int choice = uslugeBanke(sc);
                switch (choice) {
                    case 1 -> {
                        Korisnik korisnik = kreirajKorisnika(banka, sc);
                        napraviRacune(korisnik, banka, sc);
                    }
                    case 2 -> uplati(banka, sc);
                    case 3 -> isplati(banka, sc);
                    case 4 -> otvoriRacun(banka, sc);
                    case 5 -> stanjeSvihRacuna(banka, sc);
                    case 6 -> stanjeRacuna(banka,sc);
                    case 7 -> {
                        //transfer

                    }
                    case 8 -> {
                        //zatvori racun
                    }
                    case 9 -> System.exit(1);
                }

            }
        }

        private static void stanjeSvihRacuna(Banka banka, Scanner sc){
            System.out.println("Unesite jmbg: ");
            String jmbg = sc.nextLine();
            Korisnik korisnik = banka.nadjiKorisnika(jmbg);
            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR));
        }

        private  static void otvoriRacun(Banka banka,Scanner sc){
            System.out.println("Unesite jmbg: ");
            String jmbg = sc.nextLine();
            Korisnik korisnik = banka.nadjiKorisnika(jmbg);
            napraviRacune(korisnik, banka, sc);

        }

    private static void isplati(Banka banka, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int choice;
        if (korisnik != null){
            korisnik.ispisiRacune();
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("Unesite iznos isplate: ");
            int iznos = Integer.parseInt(sc.nextLine());
            korisnik.isplata(korisnik.getRacuni().get(choice), iznos);
        }
        else System.out.println("Ne postoji korisnik! ");
    }

    private static int uslugeBanke(Scanner sc) {
        System.out.println("1 - Postani Korisnik:\n" +
                "2 - Uplata\n" +
                "3 - Isplata\n" +
                "4 - Otvor novi racun\n" +
                "5 - Stanje svih racuna korisnika\n" +
                "6 - Stanje\n" +
                "7 - Transfer\n" +
                "8 - Zatvori racun\n" +
                "9 - Izlaz");
        return Integer.parseInt(sc.nextLine());
    }

    private static Korisnik kreirajKorisnika(Banka banka,Scanner sc) {

        System.out.println("Unesite ime, prezime, adresu i jmbg: ");

        String ime = sc.nextLine();
        String prezime = sc.nextLine();
        String adresa = sc.nextLine();
        String jmbg = sc.nextLine();
        Korisnik korisnik = new Korisnik(ime, prezime, adresa, jmbg);
        banka.getKorisnici().add(korisnik);

        return korisnik;
    }

    private static Banka odabirBanke(ArrayList<Banka> banke, Scanner sc) {
        for (int i = 0; i < banke.size(); i++) {
            System.out.println(i+1 + ")");
            System.out.println(banke.get(i));
            System.out.println();
        }
        System.out.println("Odaberi redni broj banke: ");

        int odabir = -1;
        if (sc.hasNextLine()) {
            odabir = Integer.parseInt(sc.nextLine());
        }

        if (odabir <= 0 || odabir > banke.size())
            throw new IndexOutOfBoundsException("Nevalidan broj banke");

        return banke.get(odabir-1);
    }

    private static void napraviRacune(Korisnik korisnik, Banka banka, Scanner sc){
            System.out.println("Unesite tip racuna: ");
            String tip = sc.nextLine();
            if(tip.toUpperCase().equals(Tip.DEVIZNI.toString())){
                Racun racun = new Racun(Tip.DEVIZNI,Valuta.EUR, 123, korisnik, banka);
                Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, 100, korisnik, banka);
                banka.dodajRacun(racun, korisnik);
                banka.dodajRacun(racun3, korisnik);
            }
            else if (tip.toUpperCase().equals(Tip.DINARSKI.toString())){
                Racun racun2 = new Racun(Tip.DINARSKI,Valuta.RSD, 124, korisnik, banka);
                banka.dodajRacun(racun2, korisnik);
            }

        }

        private static void uplati (Banka banka, Scanner sc){
            System.out.println("Unesite jmbg: ");
            String jmbg = sc.nextLine();
            Korisnik korisnik = banka.nadjiKorisnika(jmbg);
            int choice;
            if (korisnik != null) {
                korisnik.ispisiRacune();
                System.out.println("Izaberite racun za uplatu: ");
                choice = Integer.parseInt(sc.nextLine())-1;
                System.out.println("Unesite iznos uplate: ");
                int iznos = Integer.parseInt(sc.nextLine());
                korisnik.uplata(korisnik.getRacuni().get(choice), iznos);
            }
            else System.out.println("Ne postoji korisnik! ");
        }

        private static void stanjeRacuna(Banka banka, Scanner sc){
            System.out.println("Unesite jmbg: ");
            String jmbg = sc.nextLine();
            Korisnik korisnik = banka.nadjiKorisnika(jmbg);
            int choice;
            if (korisnik != null) {
                korisnik.ispisiRacune();
                System.out.println("Izaberite racun: ");
                choice = Integer.parseInt(sc.nextLine())-1;
                Racun racun = korisnik.getRacuni().get(choice);
                System.out.println("Stanje je: " + korisnik.proveraStanja(racun,racun.getValuta()));
            }
            else System.out.println("Ne postoji korisnik! ");


        }
}
