package common.bankarskiSistem.service;

import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
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
     * @param name of the bank
     * @param address of the bank
     * @return bank that was created
     * @throws NameOfTheBankAlreadyExistException
     */
    public Bank createBank(String name, String address) throws NameOfTheBankAlreadyExistException {
        if (name == null)
            throw new NullPointerException("The name is null.");
        if (address == null)
            throw new NullPointerException("The address is null.");

        Bank bank = new Bank();
        bank.setName(name);
        bank.setAddress(address);

        if(bankRepository.findByName(bank.getName()).isPresent())
            throw new NameOfTheBankAlreadyExistException("Name of the bank already exists.");
        return bankRepository.save(bank);
    }

    /**
     *
     * @param idBank of the bank to be deleted
     */
    public void deleteBank(Integer idBank) {
        if(bankRepository.findById(idBank).isPresent())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.deleteById(idBank);
    }

    /**
     *
     * @param name of the bank
     * @param idBank of the bank
     */
    public void updateBankName(String name, Integer idBank) {
        if (name == null)
            throw new NullPointerException("The name is null.");
        if(bankRepository.findById(idBank).isPresent())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.getReferenceById(idBank).setName(name);
    }

    /**
     *
     * @param address of the bank
     * @param idBank od the bank
     */
    public void updateBankAddress(String address, Integer idBank) {
        if (address == null)
            throw new NullPointerException("The address is null.");
        if(bankRepository.findById(idBank).isPresent())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.getReferenceById(idBank).setAddress(address);
    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rate that was created
     */
    public ExchangeRates createExchangeRates(ExchangeRates exchangeRates) {
        if(exchangeRates == null)
            throw new NullPointerException("The excenge rate is null.");
        return exchangeRatesRepository.save(exchangeRates);
    }

    /**
     * @param bank of bank
     * @return exchange rates
     */
    public Optional<ExchangeRates> getExcangeRates(Bank bank) {
        if (bank == null)
            throw new NullPointerException("The bank is null.");
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
        if (bank == null)
            throw new NullPointerException("The bank is null.");
        List<User> users = new ArrayList<>();
        if (bankRepository.getBankAccounts(bank) == null)
            throw new NullPointerException("There is no accounts in this bank.");
        for (BankAccount account: bankRepository.getBankAccounts(bank)) {
            users.add(account.getUser());
        }
        return users;
    }


}
