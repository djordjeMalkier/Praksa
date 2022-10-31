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
                System.out.println();
                int choice = uslugeBanke(sc);
                switch (choice) {
                    case 1 -> {
                        Korisnik korisnik = kreirajKorisnika(banka, sc);
                        if(korisnik != null) {
                            napraviRacune(korisnik, banka, sc);
                        }
                    }
                    case 2 -> {
                        uplati(banka, sc);
                        System.out.println();
                    }
                    case 3 -> {
                        isplati(banka, sc);
                        System.out.println();
                    }
                    case 4 -> {
                        otvoriRacun(banka, sc);
                        System.out.println();
                    }
                    case 5 -> {
                        stanjeSvihRacuna(banka, sc);
                        System.out.println();
                    }
                    case 6 -> {
                        stanjeRacuna(banka, sc);
                        System.out.println();
                    }
                    case 7 -> {
                        transfer(banka, banke, sc);
                        System.out.println();
                    }
                    case 8 -> {
                        zatvoriRacun(banka, sc);
                        System.out.println();
                    }
                    case 9 -> System.exit(1);
                }

            }
        }

    private static Banka odabirBanke(ArrayList<Banka> banke, Scanner sc) {
        for (int i = 0; i < banke.size(); i++) {
            System.out.print(i+1 + ") ");
            System.out.println(banke.get(i));
            System.out.println();
        }
        System.out.println("Odaberi redni broj banke: ");

        int odabir = -1;
        if (sc.hasNextLine()) {
            odabir = ucitajInt(sc);
        }

        if (odabir <= 0 || odabir > banke.size())
            throw new IndexOutOfBoundsException("Nevalidan broj banke");

        return banke.get(odabir-1);
    }

    private static int ucitajInt(Scanner sc) {
        int num;
        try {
            num = Integer.parseInt(sc.nextLine());
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Nevalidan unos broja");
            throw e;
        }
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
        return ucitajInt(sc);
    }

    private static Korisnik kreirajKorisnika(Banka banka,Scanner sc) {

        System.out.println("Unesite ime, prezime, adresu i jmbg: ");

        String ime = sc.nextLine();
        String prezime = sc.nextLine();
        String adresa = sc.nextLine();
        String jmbg = sc.nextLine();

        if(jmbg.length() != 13 || !jmbg.matches("[0-9]+")) {
            System.out.println("Nevalidan jmbg!");
            return null;
        }

        Korisnik korisnik = new Korisnik(ime, prezime, adresa, jmbg);
        banka.getKorisnici().add(korisnik);

        return korisnik;
    }
    private static void uplati (Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int choice;
        if (korisnik != null) {
            korisnik.ispisiRacune();
            System.out.println("Izaberite racun za uplatu: ");
            choice = ucitajInt(sc) - 1;
            System.out.println("Unesite iznos uplate: ");
            int iznos = ucitajInt(sc);
            korisnik.uplata(korisnik.getRacuni().get(choice), iznos);
        }
        else System.out.println("Ne postoji korisnik! ");
    }

    private static void isplati(Banka banka, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int choice;
        if (korisnik != null){
            korisnik.ispisiRacune();
            choice = ucitajInt(sc);
            System.out.println("Unesite iznos isplate: ");
            int iznos = ucitajInt(sc);
            korisnik.isplata(korisnik.getRacuni().get(choice), iznos);
        }
        else System.out.println("Ne postoji korisnik! ");
    }

    private  static void otvoriRacun(Banka banka,Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);

        if(korisnik != null) {
            napraviRacune(korisnik, banka, sc);
        } else {
            System.out.println("Ne postoji korisnik!");
        }

    }

    private static void stanjeSvihRacuna(Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        if(korisnik != null){
            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR));
        } else {
            System.out.println("Ne postoji korisnik!");
        }
    }

    private static void stanjeRacuna(Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int choice;
        if (korisnik != null) {
            korisnik.ispisiRacune();
            System.out.println("Izaberite racun: ");
            choice = ucitajInt(sc)-1;
            Racun racun = korisnik.getRacuni().get(choice);
            System.out.println("Stanje je: " + korisnik.proveraStanja(racun,racun.getValuta()));
        }
        else System.out.println("Ne postoji korisnik! ");


    }

    private static void transfer(Banka banka, ArrayList<Banka> banke, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        korisnik.ispisiRacune();

        System.out.println("Izaberite racun sa kog vrsite transfer: ");
        int transferSaRacuna = ucitajInt(sc);
        Racun racun = korisnik.getRacuni().get(transferSaRacuna);

        System.out.println("Unesite broj racuna na koji vrsite transfer: ");
        int transferNaRacun = ucitajInt(sc);

        Racun racunZaTransfer = null;
        for (Banka b : banke)
            for (Korisnik k: b.getKorisnici())
                for (Racun r: k.getRacuni())
                    if (r.getBrojRacuna() == transferNaRacun) {
                        racunZaTransfer = r;
                        break;
                    }

        if (racunZaTransfer == null) {
            System.out.println("Ne postoji racun ni u jednoj banci");
            return;
        }

        System.out.println("Unesite iznos: ");
        float iznosTransfera = Float.parseFloat(sc.nextLine());
        Korisnik primalac = racunZaTransfer.getKorisnik();
        banka.prebaciNovacKorisniku(korisnik, racun, primalac, racunZaTransfer, iznosTransfera);
    }

    private static void zatvoriRacun(Banka banka, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);

        int choice;
        if (korisnik != null) {
            korisnik.ispisiRacune();
            System.out.println("Izaberite racun za brisanje: ");
            choice = ucitajInt(sc) - 1;
            korisnik.obrisiRacun(korisnik.getRacuni().get(choice));
        } else System.out.println("Ne postoji korisnik!");

    }

    private static void napraviRacune(Korisnik korisnik, Banka banka, Scanner sc){
        System.out.println("Unesite tip racuna: DEVZINI/DINARSKI ");
        String tip = sc.nextLine();
        if(tip.toUpperCase().equals(Tip.DEVIZNI.toString())){
            Racun racun = new Racun(Tip.DEVIZNI,Valuta.EUR, korisnik, banka);
            Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, korisnik, banka);
            banka.dodajRacun(racun, korisnik);
            banka.dodajRacun(racun3, korisnik);
        }
        else if (tip.toUpperCase().equals(Tip.DINARSKI.toString())){
            Racun racun2 = new Racun(Tip.DINARSKI,Valuta.RSD, korisnik, banka);
            banka.dodajRacun(racun2, korisnik);
        }

    }
}
