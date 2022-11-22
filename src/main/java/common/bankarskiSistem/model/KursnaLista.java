package common.bankarskiSistem.model;

import common.bankarskiSistem.model.Konverzija;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Kurs klasa u sebi sadrzi tabelu kurseva za EUR,RSD i USD.
 * Tabela je predstavljena preko matrice redom kolone i redovi : EUR, RSD, USD.
 * U tabeli je predstavljena vrstom jedinica valute u vrednosti druge valute sa presekom odgovarajuce kolone.
 */

@Entity
@Table(name = "kursnaLista")
@Getter
@Setter
@NoArgsConstructor
public class KursnaLista {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idKonverzije")
    private List<Konverzija> konverzije;


    public KursnaLista(int idKurs) {
        this.id = idKurs;
    }


}
