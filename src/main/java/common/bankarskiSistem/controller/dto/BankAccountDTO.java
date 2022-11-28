package common.bankarskiSistem.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.bankarskiSistem.model.AccountType;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.Currency;
import common.bankarskiSistem.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccountDTO {
    private double balance;

    private Integer idAccount;

    private Currency currency;

    private AccountType accountType;

    private User user;

    private Bank bank;

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "balance=" + balance +
                ", idAccount=" + idAccount +
                ", currency=" + currency +
                ", accountType=" + accountType +
                ", user=" + user +
                ", bank=" + bank +
                '}';
    }
}
