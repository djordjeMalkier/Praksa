package common.bankarskiSistem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Klasa Korisnik u sebi sadrzi sve podatke u vezi sa njim i njegovim racunima.
 * {@link #Korisnik(String, String, String, String)} konstruktor bez racuna, ukoliko se kreira korisnik bez ikakvih racuna i bez id-a.
 *  konstruktor korisnika ukoliko korisnik vec ima neke racune
 */
@Entity
@Table(name = "Korisnik")
@NoArgsConstructor
@Getter
@Setter

public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="jmbg", nullable = false)
    private String jmbg;

    @Column(name="ime", nullable = false)
    private String ime;

    @Column(name="prezime", nullable = false)
    private String prezime;



    @Column(name="idAdresa", nullable = false)
    private String adresa;

    @OneToMany(mappedBy="idKorisnik")
    private List<Racun> racuni;





    public Korisnik(String ime, String prezime, String adresa, String jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.jmbg = jmbg;
        this.racuni = new ArrayList<>() {
        };
    }



    public Korisnik(String ime, String prezime, String jmbg, String adresa, List<Racun> racuni) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.racuni = racuni;

    }


    /**
     * Metoda vraca iznos sredstava na svim korisnikovim racunima i prikazuje se u odredjenoj valuti.
     * @param valuta - valuta u kojoj korisnik zeli da vidi raspoloziva sredstva
     * @return - sumirana raspoloziva sredstva korisnika u odredjenoj valuti.
     */

    public float stanjeSvihRacuna(Valuta valuta) {
        return racuni.stream()
                .map(racun -> proveraStanja(racun, valuta))
                .reduce((float) 0, Float::sum);
    }

    /**
     * Provera raspolozivih sredstava na nekom od korisnikovih racuna.
     * @param racun - racun za koji se proveravaju sredstva
     * @param valuta - valuta u kojoj se prikazuju raspoloziva sredstva
     * @return - stanje racuna u valuti
     */

 public float proveraStanja(Racun racun, Valuta valuta) {
        if (racun == null) throw new NullPointerException("Prosledjen je null racun");
        if (valuta == null) throw new NullPointerException("Nije prosledjena validna valuta");
        return 0;
        //return racun.getStanje() * racun.getBanka().getKurs().convert(racun.getValuta(), valuta);
    } //TODO:Promeniti ovo za konverziju

    /**
     * Uplata sredstava na korisnikov racun
     * @param racun - racun na koji se uplacuju sredstva
     * @param iznos - iznos koji se upacujue
     * @return - stanje nakon uplate
     */
    public float uplata(Racun racun, float iznos) {
        if (racun == null) throw new NullPointerException("Prosledjen je null racun");

        if (iznos <= 0) {
            System.out.println("Iznos za uplatu mora biti pozitivan");
        } else {
            racun.setStanje(racun.getStanje() + iznos);
            //IZMENA
            BankarskiSistem.database.updateDataForQuery("UPDATE \"Racun\" SET stanje = " +
                    (racun.getStanje()) + " WHERE \"brojRacuna\" = " +
                    racun.getBrojRacuna());
        }

        return racun.getStanje();
    }

    /**
     * Isplata sredstava na korisnikov racun
     * @param racun - racun sa kojeg se skidaju sredstva
     * @param iznos - iznos koji se skida
     * @return - stanje nakon isplate
     */
    public float isplata(Racun racun, float iznos) {
        if (racun == null) throw new NullPointerException("Prosledjen je null racun");

        if(iznos > racun.getStanje())
            System.out.println("Iznos je veci od stanja na racunu. ");
        else {
            racun.setStanje(racun.getStanje() - iznos);
            BankarskiSistem.database.updateDataForQuery("UPDATE \"Racun\" SET stanje = " +
                    (racun.getStanje()) + " WHERE \"brojRacuna\" = " +
                    racun.getBrojRacuna());
            //Zatvaranje racuna u slucaju da je iznos nula
            if (Math.signum(racun.getStanje()) == 0)
                obrisiRacun(racun);
        }

        return racun.getStanje();
    }

    /**
     * Transfer korisnikovih sredstava izmedju racuna korisnika u banci.
     * @param saRacuna - racun sa kojeg se uzima novac
     * @param naRacun - racun na koji se novac prebacuje
     * @param iznos - iznos koji se prebacuje
     * Metoda vodi racuna o knvertovanju valute ukoliko su racuni razlicitih valuta.
     */
    public void transferIzmedjuRacuna(Racun saRacuna, Racun naRacun, float iznos) {
        if (saRacuna == null || naRacun == null) throw new NullPointerException("Prosledjen je null racun");

        if (iznos <= 0) {
            System.out.println("Iznos za uplatu mora biti pozitivan");
        } else if (saRacuna.getValuta() != naRacun.getValuta()) {
                isplata(saRacuna, iznos);
              /*  float konvertovanaValuta = saRacuna.getBanka().getKurs().convert(saRacuna.getValuta(), naRacun.getValuta());
                iznos *= konvertovanaValuta;
                uplata(naRacun, iznos);*/ //TODO: Ovde se poziva convert, promeniti
            } else {
                isplata(saRacuna, iznos);
                uplata(naRacun, iznos);
            }
    }

    /**
     * Zatvaranje svih korisnikovih racuna odredjenog tipa.
     * @param tipRacuna - tip racuna koji korisnik zeli da zatvori
     */

    public void zatvoriSveRacune(Tip tipRacuna) {
        if (tipRacuna == null) throw new NullPointerException("Prosledjen je null tip racuna");

        racuni = racuni.stream()
                .filter(racun -> racun.getTipRacuna() != tipRacuna)
                .toList();
    }

    /**
     * Brisanje racuna korisnika.
     * @param racun - racun koji se brise
     * @return - uspesnost brisanja racuna
     */

    public boolean obrisiRacun(Racun racun) {
        if (racun == null) throw new NullPointerException("Nije prosledjen racun");
        BankarskiSistem.database.deleteDataForQuery(
                "DELETE FROM \"Racun\" WHERE \"brojRacuna\" = " + racun.getBrojRacuna());
        return racuni.remove(racun);
    }

    public void ispisiRacune(){
        System.out.println("---Racuni---");
        IntStream.range(0, racuni.size())
                .forEach(i ->
                    System.out.println(racuni.get(i).getBrojRacuna() + " " + racuni.get(i).getTipRacuna()
                    + " " + racuni.get(i).getStanje() +  " "  + racuni.get(i).getValuta()));
        System.out.println("---******---");
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", adresa='" + adresa + '\'' +
                ", ukupno racuna=" + racuni.size() +

                "}";
    }

    public void ispisiRacune(Banka banka) {
        System.out.println("---Racuni---");
        for (Racun racun : racuni) {
            if (racun.getBanka().getIdBanke() == banka.getIdBanke())
                System.out.println(racun.getBrojRacuna() + " " + racun.getTipRacuna()
                        + " " + racun.getStanje() +  " "  + racun.getValuta());
        }
        System.out.println("---******---");
    }
}
