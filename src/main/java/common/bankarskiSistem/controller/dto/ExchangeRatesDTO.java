package common.bankarskiSistem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ExchangeRatesDTO {
    private Integer idExchangeRates;
    private String name;

    @Override
    public String toString() {
        return "ExchangeRatesDTO{" +
                "idExchangeRates=" + idExchangeRates +
                ", name='" + name + '\'' +
                '}';
    }
}
