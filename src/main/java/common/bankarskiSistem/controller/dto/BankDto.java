package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BankDto {
    Integer idBank;
    String name;
    String address;
    List<BankAccount> bankAccounts;
    ExchangeRatesDTO exchangeRatesDTO;

    @Override
    public String toString() {
        return "BankDto{" +
                "idBank=" + idBank +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", exchangeRates=" + exchangeRatesDTO +
                '}';
    }
}
