package common.bankarskiSistem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
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
@Transactional
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExchangeRates", nullable = false)
    private Integer idExchangeRates;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "exchangeRates")
    private List<Conversion> conversions;

    @OneToMany(mappedBy = "exchangeRates", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bank> banks;

}
