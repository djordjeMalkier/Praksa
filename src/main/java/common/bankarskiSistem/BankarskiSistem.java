package common.bankarskiSistem;

import common.bankarskiSistem.database.Database;
import common.bankarskiSistem.database.DatabaseImplementation;
import common.bankarskiSistem.database.PostgreRepository;
import common.bankarskiSistem.database.settings.Settings;
import common.bankarskiSistem.database.settings.SettingsImplementation;
import common.bankarskiSistem.resources.data.Row;
import common.bankarskiSistem.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankarskiSistem {
        public static Database database;
        public static void main(String[] args) {
           Settings settings = initSettings();
           database = new DatabaseImplementation(new PostgreRepository(settings));

            //INICIJALIZACIJA IZ BAZE
            List<Kurs> kursevi = ucitajKurseveIzBaze(database);
            List<Banka> banke = ucitajBankeIzBaze(database, kursevi);
            List<Korisnik> korisnici = ucitajKorisnikeIzBaze(database);
            List<Racun> racuni = ucitajRacuneIzBaze(database, banke, korisnici);
            dodajRacune(racuni, banke);

            Scanner sc = new Scanner(System.in);

            while(true) {
                Banka banka;
                try {
                    banka = odabirBanke(banke, sc);
                } catch (IndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                    continue;
                }

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
                    default -> System.err.println("Nevalidan izbor");
                }

            }
        }

    private static void dodajRacune(List<Racun> racuni, List<Banka> banke) {
        for (Racun racun : racuni) {
            Banka bankaKojojSeDodajeRacun =
                    banke.stream().filter(b -> b.getIdBanke() == racun.getBanka().getIdBanke())
                            .findAny()
                            .orElse(null);
            if (bankaKojojSeDodajeRacun == null) {
                System.err.println("Greska kod izbora banke");
                return;
            }
            Korisnik korisnikRacuna = racun.getKorisnik();
            bankaKojojSeDodajeRacun.dodajRacunUListu(racun, korisnikRacuna);
        }
    }

    private static List<Korisnik> ucitajKorisnikeIzBaze(Database database) {
        List<Korisnik> korisnici = new ArrayList<>();
        List<Row> rows = database.readDataFromQuery("SELECT * FROM \"Korisnik\"");
        for (Row row : rows) {
            String ime = row.getFields().get("ime").toString().trim();
            String prezime = row.getFields().get("prezime").toString().trim();
            String adresa = row.getFields().get("adresa").toString().trim();
            String jmbg = row.getFields().get("jmbg").toString().trim();
            int idKorisnika = Integer.parseInt(row.getFields().get("idKorisnik").toString().trim());
            korisnici.add(new Korisnik(ime,
                    prezime,
                    adresa,
                    jmbg,
                    idKorisnika));
        }
        return korisnici;
    }

    private static List<Racun> ucitajRacuneIzBaze(Database database, List<Banka> banke, List<Korisnik> korisnici) {
        List<Racun> racuni = new ArrayList<>();
        List<Row> rows = database.readDataFromQuery("SELECT * FROM \"Racun\"");
        for (Row row : rows) {

            Tip tipRacuna = Tip.values()[Integer.parseInt(row.getFields().get("idTip").toString())-1];
            Valuta valuta = Valuta.values()[Integer.parseInt(row.getFields().get("idValuta").toString())-1];
            int idKorisnik = Integer.parseInt(row.getFields().get("idKorisnik").toString());
            Korisnik korisnik = korisnici.stream().filter(k -> k.getIdKorisnik() == idKorisnik).findAny().orElse(null);
            int idBanke = Integer.parseInt(row.getFields().get("idBanka").toString());
            Banka banka = banke.stream().filter(b -> b.getIdBanke() == idBanke).findAny().orElse(null);
            int brojRacuna = Integer.parseInt(row.getFields().get("brojRacuna").toString());
            racuni.add(new Racun(
                    tipRacuna,
                    valuta,
                    korisnik,
                    banka,
                    Float.parseFloat(row.getFields().get("stanje").toString()),
                    brojRacuna
            ));
        }
        return racuni;
    }

    private static List<Banka> ucitajBankeIzBaze(Database database, List<Kurs> kursevi) {
        List<Banka> banke = new ArrayList<>();
        List<Row> rows = database.readDataFromQuery("SELECT * FROM \"Banka\"");
        for (Row row : rows) {
            banke.add(new Banka(Integer.parseInt(row.getFields().get("idBanka").toString()),
                    row.getFields().get("ime").toString().trim(),
                    row.getFields().get("adresa").toString().trim(),
                    kursevi.get(Integer.parseInt(row.getFields().get("idKurs").toString())-1)));
        }
        return banke;
    }

    private static List<Kurs> ucitajKurseveIzBaze(Database database) {
        List<Kurs> kursevi = new ArrayList<>();

        List<Row> rows = database.readDataFromQuery("SELECT * FROM \"Kurs\"");
        for (Row row : rows) {
            kursevi.add(new Kurs(Integer.parseInt(row.getFields().get("idKurs").toString()), new float[][] {
                    {1F, Float.parseFloat(row.getFields().get("EUR_RSD").toString()), Float.parseFloat(row.getFields().get("EUR_RSD").toString())},
                    {Float.parseFloat(row.getFields().get("RSD_EUR").toString()), 1F, Float.parseFloat(row.getFields().get("RSD_USD").toString())},
                    {Float.parseFloat(row.getFields().get("USD_EUR").toString()), Float.parseFloat(row.getFields().get("USD_RSD").toString()), 1F}
            }));
        }
        return kursevi;
    }

    private static Banka odabirBanke(List<Banka> banke, Scanner sc) {
        for (Banka banka : banke) {
            System.out.println(banka);
            System.out.println();
        }
        System.out.println("Odaberi ID banke: ");

        int odabir = -1;
        if (sc.hasNextLine()) {
            odabir = ucitajInt(sc);
        }

        if (odabir <= 0 || odabir > banke.size())
            throw new IndexOutOfBoundsException("Nevalidan broj banke");

        int finalOdabir = odabir;
        return banke.stream().filter(b -> b.getIdBanke() == finalOdabir)
                .findAny()
                .orElse(null);
    }

    private static int ucitajInt(Scanner sc) {
        int num;
        try {
            num = Integer.parseInt(sc.nextLine());
            return num;
        } catch (NumberFormatException e) {
            System.err.println("Nevalidan unos broja");
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
            System.err.println("Nevalidan jmbg!");
            return null;
        }

        Korisnik korisnik = new Korisnik(ime, prezime, adresa, jmbg);
        banka.getKorisnici().add(korisnik);
        database.insertDataForQuery("Insert into \"Korisnik\" (jmbg, ime, prezime, adresa) values(" + "'" + jmbg + "'" + "," + "'" + ime + "'" +
                "," + "'" + prezime + "'" + "," + "'" + adresa + "')" );

        return korisnik;
    }
    private static void uplati (Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int idBrojRacunaUplata;
        if (korisnik != null) {
            korisnik.ispisiRacune(banka);
            System.out.println("Izaberite racun za uplatu: ");
            idBrojRacunaUplata = ucitajInt(sc);
            Racun racunZaUplatu = korisnik.getRacuni().stream()
                    .filter(r -> r.getBrojRacuna() == idBrojRacunaUplata)
                    .findAny()
                    .orElse(null);
            if (racunZaUplatu == null) {
                System.err.println("Nevalidan broj racuna");
                return;
            }
            System.out.println("Unesite iznos uplate: ");
            int iznos = ucitajInt(sc);
            korisnik.uplata(racunZaUplatu, iznos);
        }
        else System.err.println("Ne postoji korisnik! ");
    }

    private static void isplati(Banka banka, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int choice;
        if (korisnik != null){
            korisnik.ispisiRacune(banka);
            System.out.println("Izaberite racun: ");
            choice = ucitajInt(sc);
            System.out.println("Unesite iznos isplate: ");
            int iznos = ucitajInt(sc);
            Racun racunZaIsplatu = korisnik.getRacuni().stream().filter(r -> r.getBrojRacuna() == choice).findAny().orElse(null);
            if (racunZaIsplatu == null) {
                System.err.println("Nevalidan broj racuna");
                return;
            }
            korisnik.isplata(racunZaIsplatu, iznos);
        }
        else System.err.println("Ne postoji korisnik! ");
    }

    private  static void otvoriRacun(Banka banka,Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);

        if(korisnik != null) {
            napraviRacune(korisnik, banka, sc);
        } else {
            System.err.println("Ne postoji korisnik!");
        }

    }

    private static void stanjeSvihRacuna(Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        if(korisnik != null){
            System.out.println(korisnik.stanjeSvihRacuna(Valuta.EUR) + " " + Valuta.EUR);
        } else {
            System.err.println("Ne postoji korisnik!");
        }
    }

    private static void stanjeRacuna(Banka banka, Scanner sc){
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        int idRacunaOdabir;
        if (korisnik != null) {
            korisnik.ispisiRacune(banka);
            System.out.println("Izaberite racun: ");
            idRacunaOdabir = ucitajInt(sc);
            Racun racun = korisnik.getRacuni().stream()
                    .filter(r -> r.getBrojRacuna() == idRacunaOdabir)
                    .findAny()
                    .orElse(null);
            if (racun == null) {
                System.err.println("Nevalidan broj racuna");
                return;
            }
            System.out.println("Stanje je: " + korisnik.proveraStanja(racun,racun.getValuta()) + " " + racun.getValuta());
        }
        else System.err.println("Ne postoji korisnik! ");


    }

    private static void transfer(Banka banka, List<Banka> banke, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);
        if (korisnik == null) {
            System.err.println("Ne postoji korisnik");
            return;
        }
        korisnik.ispisiRacune(banka);

        System.out.println("Izaberite racun sa kog vrsite transfer: ");
        int transferSaRacuna = ucitajInt(sc);
        Racun racun = korisnik.getRacuni().stream().filter(r -> r.getBrojRacuna() == transferSaRacuna).findAny().orElse(null);
        if (racun == null) {
            System.err.println("Ne postoji racun");
            return;
        }

        System.out.println("Unesite broj racuna na koji vrsite transfer: ");
        int transferNaRacun = ucitajInt(sc);

        Racun racunZaTransfer = korisnik.getRacuni().stream().filter(r -> r.getBrojRacuna() == transferNaRacun).findAny().orElse(null);
        if (racunZaTransfer == null) {
            System.err.println("Ne postoji racun");
            return;
        }

        for (Banka b : banke)
            for (Korisnik k: b.getKorisnici())
                for (Racun r: k.getRacuni())
                    if (r.getBrojRacuna() == transferNaRacun) {
                        racunZaTransfer = r;
                        break;
                    }

        System.out.println("Unesite iznos: ");
        float iznosTransfera = Float.parseFloat(sc.nextLine());
        if (iznosTransfera <= 0) {
            System.err.println("Iznos mora biti pozitivan, bato...");
            return;
        }
        Korisnik primalac = racunZaTransfer.getKorisnik();
        banka.prebaciNovacKorisniku(korisnik, racun, primalac, racunZaTransfer, iznosTransfera);
    }

    private static void zatvoriRacun(Banka banka, Scanner sc) {
        System.out.println("Unesite jmbg: ");
        String jmbg = sc.nextLine();
        Korisnik korisnik = banka.nadjiKorisnika(jmbg);

        int idRacunaOdabir;
        if (korisnik != null) {
            korisnik.ispisiRacune(banka);
            System.out.println("Izaberite racun za brisanje: ");
            idRacunaOdabir = ucitajInt(sc);
            Racun racun = korisnik.getRacuni().stream()
                    .filter(r -> r.getBrojRacuna() == idRacunaOdabir)
                    .findAny()
                    .orElse(null);
            if (racun == null) {
                System.err.println("Nevalidan broj racuna");
                return;
            }
            korisnik.obrisiRacun(racun);
        } else System.err.println("Ne postoji korisnik!");
    }

    private static void napraviRacune(Korisnik korisnik, Banka banka, Scanner sc){
        System.out.println("Unesite tip racuna: DEVZINI / DINARSKI ");
        String tip = sc.nextLine();
        if(tip.toUpperCase().equals(Tip.DEVIZNI.toString())){
            Racun racun = new Racun(Tip.DEVIZNI,Valuta.EUR, korisnik, banka, -1);
            Racun racun3 = new Racun(Tip.DEVIZNI,Valuta.USD, korisnik, banka, -1);
            banka.dodajRacun(racun, korisnik);
            banka.dodajRacun(racun3, korisnik);
        }
        else if (tip.toUpperCase().equals(Tip.DINARSKI.toString())){
            Racun racun2 = new Racun(Tip.DINARSKI,Valuta.RSD, korisnik, banka, -1);
            banka.dodajRacun(racun2, korisnik);
        }

    }

    private static Settings initSettings() {
        Settings settingsImplementation = new SettingsImplementation();
        settingsImplementation.addParameter("ip", Constants.IP);
        settingsImplementation.addParameter("database", Constants.DATABASE);
        settingsImplementation.addParameter("username", Constants.USERNAME);
        settingsImplementation.addParameter("password", Constants.PASSWORD);
        return settingsImplementation;
    }
}
