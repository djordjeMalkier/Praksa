package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idConversion", nullable = false)
    private Integer idConversion;

    @Enumerated(EnumType.STRING)
    @Column(name = "currencyFrom", nullable = false)
    private Currency currencyFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "currencyTo", nullable = false)
    private Currency currencyTo;

    @Column(name = "value", nullable = false)
    private double value;

    @ManyToOne
    @JoinColumn(name = "idExchangeRates")
    private ExchangeRates exchangeRates;

}
