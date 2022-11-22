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
    private Long idConversion;

    @OneToOne
    private Currency from;

    @OneToOne
    private Currency to;

    @Column(name = "value", nullable = false)
    private double value;

    @ManyToOne
    @JoinColumn(name = "idExchangeRates")
    private ExchangeRates exchangeRates;

}
