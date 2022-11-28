package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Conversion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ExchangeRatesDTO {
    private Integer idExchangeRates;
    private String name;

    private List<Conversion> conversions;

    //private List<Bank> banks;

    /*@Override
    public String toString() {
        return "ExchangeRatesDTO{" +
                "idExchangeRates=" + idExchangeRates +
                ", name='" + name + '\'' +
                ", conversions=" + conversions +
                ", banks=" + banks +
                '}';
    }*/

    @Override
    public String toString() {
        return "ExchangeRatesDTO{" +
                "idExchangeRates=" + idExchangeRates +
                ", name='" + name + '\'' +
                ", conversions=" + conversions +
                '}';
    }
}
