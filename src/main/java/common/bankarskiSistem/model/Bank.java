package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Ova klasa je zaduzena za sve u vezi sa Bankma. Klasa se pravi sa dva konstruktora.
 * Prvi konstruktor sa tri parametra  se koristi u koliko se Bank tek kreira i trenutno nema nijednog korisnika.
 * Drugi konstruktor sa cetiri parametra  u koliko zelimo da napravimo banku sa korisnicima.
 * I default-ni konstruktor.
 */

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBank", nullable = false)
    private Integer idBank;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "idAccount")
    private List<BankAccount> bankAccounts;
    @ManyToOne
    @JoinColumn(name = "id")
    private ExchangeRates exchangeRates;

    public Bank(int idBank, String name, String address, ExchangeRates exchangeRates) {
        this.idBank = idBank;
        this.name = name;
        this.address = address;
        this.bankAccounts = new ArrayList<>();
        this.exchangeRates = exchangeRates;
        //his.idKurs = kurs.getID();
    }

    public Bank(int idBank, String name, String address, List<BankAccount> bankAccounts, ExchangeRates exchangeRates) {
        this.idBank = idBank;
        this.name = name;
        this.address = address;
        this.bankAccounts = bankAccounts;
        this.exchangeRates = exchangeRates;
        //this.idKurs = kurs.getID();
    }

    public Bank() {
        this.exchangeRates = new ArrayList<>();
    }

   /* public int vratiID(Racun racun) {
        String query = "Select \"brojRacuna\" from \"Racun\" where \"brojRacuna\" = '" + racun.getBrojRacuna() + "'";
        List<Row> brojRacuna = BankrskiSistem.database.readDataFromQuery(query);
        int id = Integer.parseInt(brojRacuna.get(0).getFields().get("brojRacuna").toString());
        return id;
    }*/

    /**
     *
     * @param racun - racun korisnika u banci koji se dodaje korisniku

     * @param korisnik - korisnik kojem se dodaje racun
     */
   /* public void dodajRacun(Racun racun, Korisnik korisnik) {
        if(korisnici.contains(korisnik)) {
            String query = "Insert into \"Racun\" (\"stanje\", \"idValuta\", \"idTip\", \"idKorisnik\", \"idBank\") values(" +
                    racun.getStanje() +
                    "," + (racun.getIdValuta()+1) + "," +
                    (racun.getIdTip()+1) + "," +
                    (vratiID(korisnik)) + "," +
                    idBank + ")";
            List<Row> row = BankrskiSistem.database.insertDataForQuery(query);
            int brojRacuna = Integer.parseInt(row.get(row.size()-1).getFields().get("brojRacuna").toString());
            racun.setBrojRacuna(brojRacuna);
            korisnik.getRacuni().add(racun);

        }
        else {

            korisnici.add(korisnik);
            korisnik.getRacuni().add(racun);
        }
    }*/

   /* public void dodajRacunUListu(Racun racun, Korisnik korisnik) {
        if(korisnici.contains(korisnik)) {
            korisnik.getRacuni().add(racun);
        }
        else {
            korisnici.add(korisnik);
            korisnik.getRacuni().add(racun);
        }
    }*/

    /**
     *
     * @param racun - racun koji se brise iz banke
     */
    /*public void obrisiRacun(Racun racun) {
        Korisnik korisnik = racun.getKorisnik();
        try {
            korisnik.getRacuni().remove(racun);
        } catch (NullPointerException exception) {
            System.out.println("Ne postoji korisnik.");
        }
    }*/

    /**
     * Ova metoda je zaduzena za prebacivanje novca sa jednog korisnickog racuna korisnika koji je posiljalac
     * na racun korisnika koji je primalac.
     * @param posiljalac - korisnik sa cijeg se racuna salje novac
     * @param racunPosiljalaca - racun posiljaoca sa kojeg se skida novac
     * @param primalac - korisnik na ciji se racun uplacuje novac
     * @param racunPrimalaca racun primaoca na koji se uplacuje novac
     * @param iznos - iznos koji se uplacuje u valuti u kojoj zeli da posalje novac
     */

    /*public void prebaciNovacKorisniku(Korisnik posiljalac, Racun racunPosiljalaca, Korisnik primalac,
                                      Racun racunPrimalaca, float iznos){
       if(racunPosiljalaca.getValuta() != racunPrimalaca.getValuta()){
            float iznos1=iznos;
             iznos1 *= kurs.convert(racunPosiljalaca.getValuta(), racunPrimalaca.getValuta());
            float stanje1=racunPosiljalaca.getStanje();
            posiljalac.isplata(racunPosiljalaca, iznos);

            if(stanje1!=racunPosiljalaca.getStanje())
                primalac.uplata(racunPrimalaca, iznos1);

        } else{
            float stanje1=racunPosiljalaca.getStanje();
            posiljalac.isplata(racunPosiljalaca, iznos);

            if(stanje1!=racunPosiljalaca.getStanje())
                primalac.uplata(racunPrimalaca, iznos);

        }

    }*/

    /**
     * Trazenje korisnika u bazi banke prema jmbg-u.
     * @param jmbg - jmbg korisnika
     * @return - Korisnik sa unetim jmbg-om.
     */

    /*public Korisnik nadjiKorisnika(String jmbg){
        return korisnici.stream()
                .filter(korisnik -> korisnik.getJmbg().equals(jmbg))
                .findAny()
                .orElse(null);
    }*/

    /*public String toString() {
        return "ID: "+ idBank + " Bank: " + name + " na adresi: " + address + " broj korisnika=" + korisnici.size();
        //+ "\nKursna lista: " + getKurs().toString();
    }*/
}
