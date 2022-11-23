package common.bankarskiSistem.service;

import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.ExchangeRates;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.BankRepository;
import common.bankarskiSistem.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankService {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    /**
     *
     * @param bank object of Bank
     * @return bank that was created
     */
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    /**
     *
     * @param idBank of the bank to be deleted
     */
    public void deleteBank(Integer idBank) {
        bankRepository.deleteById(idBank);
    }

    /**
     *
     * @param name of the bank
     * @param idBank of the bank
     */
    public void updateBankName(String name, Integer idBank) {
        bankRepository.getReferenceById(idBank).setName(name);
    }

    /**
     *
     * @param address of the bank
     * @param idBank od the bank
     */
    public void updateBankAddress(String address, Integer idBank) {
        bankRepository.getReferenceById(idBank).setAddress(address);
    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rate that was created
     */
    public ExchangeRates createExchangeRates(ExchangeRates exchangeRates) {
        return exchangeRatesRepository.save(exchangeRates);
    }

    /**
     * @param bank of bank
     * @return exchange rates
     */
    public Optional<ExchangeRates> getExcangeRates(Bank bank) {
        return bankRepository.getExchangeRates(bank);

    }

   /* public void updateExchangeRates(Integer idConversion,ExchangeRates exchangeRates, double value ) {
        exchangeRates.getConversions().get(idConversion).setValue(value);
    }*/

    //public createConvert();

    /**
     *
     * @param bank object
     * @return list of users
     */
    public List<User> getAllUsers(Bank bank) {
        List<User> users = new ArrayList<>();
        for (BankAccount account: bankRepository.getBankAccounts(bank)) {
            users.add(account.getUser());
        }
        return users;
    }


}
