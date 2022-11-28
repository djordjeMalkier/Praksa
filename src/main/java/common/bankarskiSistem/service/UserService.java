package common.bankarskiSistem.service;

import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.exceptions.EntityAlreadyExistsException;
import common.bankarskiSistem.exceptions.EntityNotFoundException;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.Currency;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConversionService conversionService;

    @PersistenceContext
    private EntityManager entityManager;

    // UPDATE user
    public User updateUser(User user) throws EntityNotFoundException {
        if(user == null)
            throw new NullPointerException("Null user");
        User existingUser
                = userRepository.findById(user.getPersonalId())
                .orElse(null);
        if (existingUser == null)
            throw new EntityNotFoundException("User not found!");

        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAddress(user.getAddress());
        return userRepository.save(existingUser);
    }

    // CREATE user
    public User saveUser(User user) throws EntityAlreadyExistsException {
        if(user == null)
            throw new NullPointerException("Null user");
        User existingUser
                = userRepository.findByPersonalId(user.getPersonalId())
                .orElse(null);
        if (existingUser == null) {
            if(!user.getBankAccounts().isEmpty()){
                for(BankAccount account : user.getBankAccounts()){
                    account.setUser(user);
                }
            }
            return userRepository.save(user);
        }

        throw new EntityAlreadyExistsException("This user already exists!");
    }

    // DELETE user by personal id (jmbg)
    public User deleteUserByPersonalId(String id) throws EntityNotFoundException {
        if(id == null)
            throw new NullPointerException("Null personal id");
        Optional<User> userOptional = userRepository.findByPersonalId(id);
        if (userOptional.isEmpty())
            throw new EntityNotFoundException("User not found!");
        userRepository.deleteByPersonalId(id);
        return userOptional.get();
    }

    //CREATE BANK ACCOUNT for user
    public BankAccount createBankAccount(BankAccount bankAccount) throws EntityAlreadyExistsException {
        if(bankAccount == null)
            throw new NullPointerException("Null bank account");
        User existingUser = getUserByPersonalID(bankAccount.getUser().getPersonalId());
        if (existingUser == null)
            throw new EntityAlreadyExistsException("This bank account already exists!");

        BankAccount bankAccountMerged = entityManager.merge(bankAccount);
        existingUser.addAccount(bankAccountMerged);
        userRepository.save(existingUser);
        return bankAccountMerged;
    }

    public double payIn(String personalID, Integer idAccount, double payment) {
        if (idAccount == null) throw new NullPointerException("No account");

        if (payment <= 0)
            throw new IllegalArgumentException("Payment must be positive");

        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, idAccount);
        bankAccount.setBalance(bankAccount.getBalance() + payment);
        userRepository.save(user);

        return bankAccount.getBalance();
    }

    public double payOut(String personalID, Integer idAccount, double payment)
                                throws IllegalArgumentException, ArithmeticException {
        if (idAccount == null) throw new NullPointerException("No account");

        if (payment <= 0)
            throw new IllegalArgumentException("Payout must be positive");
        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, idAccount);
        if (payment > bankAccount.getBalance())
            throw new ArithmeticException("Payout is greater than balance");
        bankAccount.setBalance(bankAccount.getBalance() - payment);
        userRepository.save(user);

        return bankAccount.getBalance();
    }

    public double transfer(String personalID, Integer idAccountFrom, Integer idAccountTo, double payment) {
        if (idAccountFrom == null || idAccountTo == null)
            throw new NullPointerException("No accounts");

        if (payment <= 0)
            throw new IllegalArgumentException("Payout must be positive");

        BankAccount accountFrom = getBankAccountByID(personalID, idAccountFrom);
        BankAccount accountTo = getBankAccountByID(personalID, idAccountTo);


        if (accountFrom.getCurrency() != accountTo.getCurrency()) {
            payOut(personalID, accountFrom.getIdAccount(), payment);
            double convertedCurrency = conversionService.convert(
                    accountFrom.getCurrency(),
                    accountTo.getCurrency(),
                    accountFrom.getBank());
            payment *= convertedCurrency;
            payIn(personalID, accountTo.getIdAccount(), payment);
            return payment;
        } else {
            payOut(personalID, accountFrom.getIdAccount(), payment);
            payIn(personalID, accountTo.getIdAccount(), payment);
            return payment;
        }
    }

    public double getBalance(String personalID, Integer idAccount, Optional<Currency> currencyTo) {
        if (idAccount == null) throw new NullPointerException("No account");
        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, idAccount);
        double conversionRate = 1;

        if (currencyTo.isPresent()) {
            if (!currencyTo.get().equals(bankAccount.getCurrency()))
                conversionRate = conversionService.convert(bankAccount.getCurrency(),
                    currencyTo.get(),
                    bankAccount.getBank());
        }
        return bankAccount.getBalance() * conversionRate;
    }

    private BankAccount getBankAccountByIdAccount(User user, Integer idAccount) {
        Optional<BankAccount> bankAccountOptional = user.getBankAccounts()
                .stream()
                .filter(ba -> Objects.equals(ba.getIdAccount(), idAccount))
                .findAny();
        if (bankAccountOptional.isEmpty())
            throw new NullPointerException("Account [" + idAccount + "] not found");
        return bankAccountOptional.get();
    }

    public double getAllBalance(String personalID, Optional<Currency> currencyTo) {
        User user = getUserByPersonalID(personalID);
        Optional<Currency> finalCurrencyTo = currencyTo.isEmpty() ?  Optional.of(Currency.EUR) : currencyTo;
        return user.getBankAccounts().stream()
                .map(account -> getBalance(personalID, account.getIdAccount(), finalCurrencyTo))
                .reduce((double) 0, Double::sum);
    }

    public BankAccount deleteAccount(String personalId, BankAccount bankAccount){
        User user = getUserByPersonalID(personalId);
        if(bankAccount != null) {
            user.getBankAccounts().remove(bankAccount);
            userRepository.save(user);
            return bankAccount;
        } else throw new NullPointerException("The bank account does not exist!");
    }

    public List<BankAccount> deleteAllAccounts(String personalId){
        User user = getUserByPersonalID(personalId);
        List<BankAccount> bankAccounts = user.getBankAccounts();
        user.setBankAccounts(new ArrayList<BankAccount>());
        userRepository.save(user);
        return bankAccounts;
    }

    public List<BankAccount> getAllAccounts(String personalId){
        User user = getUserByPersonalID(personalId);
        return user.getBankAccounts();
    }

    public BankAccount getBankAccountByID(String personalId, Integer accountId){
        User user = getUserByPersonalID(personalId);
        for (BankAccount bankAccount : user.getBankAccounts()){
            if(bankAccount.getIdAccount().equals(accountId)) return bankAccount;
        }
        return null;
    }

    public User getUserByPersonalID(String personalID) throws NullPointerException {
        if(personalID == null)
            throw new NullPointerException("Null personal id");
        Optional<User> userOptional = userRepository.findByPersonalId(personalID);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + personalID + "] not found");
        return userOptional.get();
    }
}
