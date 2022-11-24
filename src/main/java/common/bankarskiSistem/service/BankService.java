package common.bankarskiSistem.service;

import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.*;
import common.bankarskiSistem.repository.BankRepository;
import common.bankarskiSistem.repository.ConversionRepository;
import common.bankarskiSistem.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    private ConversionRepository conversionRepository;
    /**
     *
     * @param bank the bank
     * @return bank that was created
     */
    public Bank createBank(Bank bank) throws NameOfTheBankAlreadyExistException {
        if(bank == null)
            throw new NullPointerException("The bank is null.");
        if(bankRepository.findByName(bank.getName()).isEmpty())
            throw new NameOfTheBankAlreadyExistException("Name of the bank already exists.");
        return bankRepository.save(bank);
    }

    /**
     *
     * @param bank of the bank to be deleted
     */
    public Bank deleteBank(Bank bank) {
        if(bankRepository.findById(bank.getIdBank()).isPresent())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.deleteById(bank.getIdBank());

        return bank;
    }

    public Bank findById(Integer idBank){
        return bankRepository.findById(idBank).get();
    }

    /**
     *
     * @param name of the bank
     * @param bank of the bank
     */
    public Bank updateBankName(String name, Bank bank) {
        if (name == null)
            throw new NullPointerException("The name is null.");
        if(bankRepository.findById(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.findById(bank.getIdBank()).get().setName(name);

        return bank;
    }

    /**
     *
     * @param address of the bank
     * @param bank od the bank
     */
    public Bank updateBankAddress(String address, Bank bank) {
        if (address == null)
            throw new NullPointerException("The address is null.");
        if(bankRepository.findById(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.findById(bank.getIdBank()).get().setAddress(address);

        return bank;

    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rates that was created
     */
    public ExchangeRates createExchangeRates(ExchangeRates exchangeRates) {
        if(exchangeRates == null)
            throw new NullPointerException("The exchange rate is null.");
        return exchangeRatesRepository.save(exchangeRates);
    }

    /**
     * @param bank of bank
     * @return exchange rates
     */
    public ExchangeRates getExchangeRates(Bank bank) {
        if (bank == null)
            throw new NullPointerException("The bank is null.");

        return bank.getExchangeRates();
    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rates
     */
    public ExchangeRates updateExchangeRates(ExchangeRates exchangeRates) {
        for(Conversion conversion: exchangeRates.getConversions()) {
            if(Objects.equals(conversion.getExchangeRates().getIdExchangeRates(), exchangeRates.getIdExchangeRates()))
                conversionRepository.save(conversion);
        }
        return exchangeRates;
    }

    /**
     *
     * @param bank object
     * @return list of users
     */
    public List<User> getAllUsers(Bank bank) {
        if (bank == null)
            throw new NullPointerException("The bank is null.");
        List<User> users = new ArrayList<>();

        for (BankAccount account: bank.getBankAccounts()) {
            users.add(account.getUser());
        }
        return users;
    }


}
