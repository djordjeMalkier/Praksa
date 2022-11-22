package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ova klasa je zaduzena za sve u vezi sa bankama. Klasa se pravi sa dva konstruktora.
 * Prvi konstruktor sa tri parametra  se koristi u koliko se banka tek kreira i trenutno nema nijednog korisnika.
 * Drugi konstruktor sa cetiri parametra  u koliko zelimo da napravimo banku sa korisnicima.
 * I default-ni konstruktor.
 */

@Entity
@Table(name = "banka")
@Getter
@Setter
public class Banka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBanka", nullable = false)
    private int idBanke;
    @Column(name="idKurs")
    private int idKurs;
    @Column(name="ime")
    private String ime;
    @Column(name="adresa")
    private String adresa;

    @OneToMany(mappedBy = "brojRacuna")
    private List<Racun> racuni;
    @ManyToOne
    @JoinColumn(name = "idKurs")
    private KursnaLista kurs;

    public Banka(int idBanke, String ime, String adresa, KursnaLista kurs) {
        this.idBanke = idBanke;
        this.ime = ime;
        this.adresa = adresa;
        this.racuni = new ArrayList<>();
        this.kurs = kurs;
        //his.idKurs = kurs.getID();
    }

    public Banka(int idBanke, String ime, String adresa, List<Racun> racuni, KursnaLista kurs) {
        this.idBanke = idBanke;
        this.ime = ime;
        this.adresa = adresa;
        this.racuni = racuni;
        this.kurs = kurs;
        //this.idKurs = kurs.getID();
    }

    public Banka() {
        this.racuni = new ArrayList<>();
    }

   /* public int vratiID(Racun racun) {
        String query = "Select \"brojRacuna\" from \"Racun\" where \"brojRacuna\" = '" + racun.getBrojRacuna() + "'";
        List<Row> brojRacuna = BankarskiSistem.database.readDataFromQuery(query);
        int id = Integer.parseInt(brojRacuna.get(0).getFields().get("brojRacuna").toString());
        return id;
    }*/

    /**
     *
     * @param racun - racun korisnika u banci koji se dodaje korisniku

     * @param korisnik - korisnik kojem se dodaje racun
     */
    public void dodajRacun(Racun racun, Korisnik korisnik) {
        /*if(korisnici.contains(korisnik)) {
            String query = "Insert into \"Racun\" (\"stanje\", \"idValuta\", \"idTip\", \"idKorisnik\", \"idBanka\") values(" +
                    racun.getStanje() +
                    "," + (racun.getIdValuta()+1) + "," +
                    (racun.getIdTip()+1) + "," +
                    (vratiID(korisnik)) + "," +
                    idBanke + ")";
            List<Row> row = BankarskiSistem.database.insertDataForQuery(query);
            int brojRacuna = Integer.parseInt(row.get(row.size()-1).getFields().get("brojRacuna").toString());
            racun.setBrojRacuna(brojRacuna);
            korisnik.getRacuni().add(racun);

        }
        else {

            korisnici.add(korisnik);
            korisnik.getRacuni().add(racun);
        }*/
    }

    public void dodajRacunUListu(Racun racun, Korisnik korisnik) {
        /*if(korisnici.contains(korisnik)) {
            korisnik.getRacuni().add(racun);
        }
        else {
            korisnici.add(korisnik);
            korisnik.getRacuni().add(racun);
        }*/
    }

    /**
     *
     * @param racun - racun koji se brise iz banke
     */
    public void obrisiRacun(Racun racun) {
        /*Korisnik korisnik = racun.getKorisnik();
        try {
            korisnik.getRacuni().remove(racun);
        } catch (NullPointerException exception) {
            System.out.println("Ne postoji korisnik.");
        }*/
    }

    /**
     * Ova metoda je zaduzena za prebacivanje novca sa jednog korisnickog racuna korisnika koji je posiljalac
     * na racun korisnika koji je primalac.
     * @param posiljalac - korisnik sa cijeg se racuna salje novac
     * @param racunPosiljalaca - racun posiljaoca sa kojeg se skida novac
     * @param primalac - korisnik na ciji se racun uplacuje novac
     * @param racunPrimalaca racun primaoca na koji se uplacuje novac
     * @param iznos - iznos koji se uplacuje u valuti u kojoj zeli da posalje novac
     */

    public void prebaciNovacKorisniku(Korisnik posiljalac, Racun racunPosiljalaca, Korisnik primalac,
                                      Racun racunPrimalaca, float iznos){
       /* if(racunPosiljalaca.getValuta() != racunPrimalaca.getValuta()){
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

        }*/

    }

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
        return "ID: "+ idBanke + " Banka: " + ime + " na adresi: " + adresa + " broj korisnika=" + korisnici.size();
        //+ "\nKursna lista: " + getKurs().toString();
    }*/
}
