package common.bankarskiSistem.service;

import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.ExchangeRates;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.BankRepository;
import common.bankarskiSistem.repository.ConversionRepository;
import common.bankarskiSistem.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
        if(!bankRepository.findByName(bank.getName()).isEmpty())
            throw new NameOfTheBankAlreadyExistException("Name of the bank already exists.");
        //bank.setExchangeRates(exchangeRatesRepository.findById(bank.getExchangeRates().getIdExchangeRates()).get());
       return bankRepository.save(bank);

    }

    public Bank deleteBank(Bank bank) {
        if(bankRepository.findByIdBank(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        bankRepository.deleteByIdBank(bank.getIdBank());

        return bank;
    }

    public Bank findById(Integer idBank){
        if(bankRepository.findByIdBank(idBank).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        return bankRepository.findByIdBank(idBank).get();
    }

    /**
     *
     * @param name of the bank
     * @param bank of the bank
     */
    public Bank updateBankName(String name, Bank bank) {
        if (name == null)
            throw new NullPointerException("The name is null.");
        if(bankRepository.findByIdBank(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        Bank updatedBank = bankRepository.findByIdBank(bank.getIdBank()).get();
        updatedBank.setName(name);
        bankRepository.save(updatedBank);

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
        if(bankRepository.findByIdBank(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        Bank updatedBank = bankRepository.findByIdBank(bank.getIdBank()).get();
        updatedBank.setAddress(address);
        bankRepository.save(updatedBank);

        return bank;

    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rates that was created
     */
    public ExchangeRates createExchangeRates( ExchangeRates exchangeRates) {
        if(exchangeRates == null)
            throw new NullPointerException("The bank is null.");
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

    public ExchangeRates findByIdExchangeRates(Integer idExchangeRates) {
        if(exchangeRatesRepository.findByIdExchangeRates(idExchangeRates).isEmpty())
            throw new NullPointerException("The exchange rates do not exist.");
        return exchangeRatesRepository.findByIdExchangeRates(idExchangeRates).get();
    }

    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rates
     */
    public ExchangeRates updateExchangeRates(ExchangeRates exchangeRates,String name) {
        if(exchangeRatesRepository.findByIdExchangeRates(exchangeRates.getIdExchangeRates()).isEmpty())
            throw new NullPointerException("The exchanges rates do not exist.");
        ExchangeRates updatedExchangeRates = exchangeRatesRepository.findByIdExchangeRates(exchangeRates.getIdExchangeRates()).get();
        exchangeRatesRepository.save(updatedExchangeRates);
        updatedExchangeRates.setName(name);

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
