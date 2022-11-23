package common.bankarskiSistem.model;

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
@Table(name = "exchangeRates")
@Getter
@Setter
@NoArgsConstructor
public class ExchangeRates {
    @Id
    private Integer idExchangeRates;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idConversion")
    private List<Conversion> conversions;

    @OneToMany(mappedBy = "idBank")
    private List<Bank> banks;

}
