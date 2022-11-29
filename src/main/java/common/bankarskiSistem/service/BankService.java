package common.bankarskiSistem.service;

import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.ExchangeRates;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.BankRepository;
import common.bankarskiSistem.repository.ConversionRepository;
import common.bankarskiSistem.repository.ExchangeRatesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    private ConversionRepository conversionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);


    /**
     *
     * @param bank the bank
     * @return bank that was created
     */
    public Bank createBank(Bank bank) throws NameOfTheBankAlreadyExistException {
        if(bank == null)
            throw new NullPointerException("The bank is null.");
        if(bankRepository.findByName(bank.getName()).isPresent())
            throw new NameOfTheBankAlreadyExistException("Name of the bank already exists.");

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
    public Bank updateBankName(String name, Bank bank) throws NameOfTheBankAlreadyExistException {
        if (name == null)
            throw new NullPointerException("The name is null.");
        if(bankRepository.findByIdBank(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        if(bankRepository.findByName(name).isPresent()) {
            throw new NameOfTheBankAlreadyExistException("Name already exist.");
        }
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

    public Bank addExchangeRates(ExchangeRates exchangeRates, Bank bank) {
        if (exchangeRates == null)
            throw new NullPointerException("The exchange rates is null.");
        if(bankRepository.findByIdBank(bank.getIdBank()).isEmpty())
            throw new NullPointerException("The bank does not exist.");
        Bank updatedBank = bankRepository.findByIdBank(bank.getIdBank()).get();
      //  ExchangeRates exchangeRatesMerged = entityManager.merge(exchangeRates);
        updatedBank.setExchangeRates(exchangeRates);
        return bankRepository.save(updatedBank);

     //   return updatedBank;

    }
    /**
     *
     * @param exchangeRates object of ExchangeRates
     * @return exchange rates that was created
     */
    public ExchangeRates createExchangeRates(ExchangeRates exchangeRates) {
        if(exchangeRates == null)
            throw new NullPointerException("The bank is null.");
        //ExchangeRates mergedExchangeRates = entityManager.merge(exchangeRates);
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
    public Set<User> getAllUsers(Bank bank) {
        if (bank == null)
            throw new NullPointerException("The bank is null.");
        Set<User> users = new HashSet<>();

        for (BankAccount account: bank.getBankAccounts()) {
            users.add(account.getUser());
        }

        return users;
    }


}
