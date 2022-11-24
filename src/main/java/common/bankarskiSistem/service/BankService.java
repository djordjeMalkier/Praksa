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
import java.util.Optional;
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
     * @throws NameOfTheBankAlreadyExistException
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
        if(bankRepository.findById(idBank).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.findById(idBank).get().setName(name);
    }

    /**
     *
     * @param address of the bank
     * @param idBank od the bank
     */
    public void updateBankAddress(String address, Integer idBank) {
        if (address == null)
            throw new NullPointerException("The address is null.");
        if(bankRepository.findById(idBank).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.findById(idBank).get().setAddress(address);
    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rate that was created
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
    public Optional<ExchangeRates> getExchangeRates(Bank bank) {
        if (bank == null)
            throw new NullPointerException("The bank is null.");
        return bankRepository.getExchangeRates(bank);

    }

    public void updateExchangeRates(ExchangeRates exchangeRates) {
        for(Conversion conversion: exchangeRates.getConversions()) {
            if(conversion.getExchangeRates().getIdExchangeRates() == exchangeRates.getIdExchangeRates())
                conversionRepository.updateConversion(conversion);
        }
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
