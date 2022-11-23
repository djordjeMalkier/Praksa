package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Integer> {

    Optional<ExchangeRates> getExchangeRates(Bank bank);
    List<BankAccount> getBankAccounts(Bank bank);

    Optional<Bank> findByName(String name);
}
