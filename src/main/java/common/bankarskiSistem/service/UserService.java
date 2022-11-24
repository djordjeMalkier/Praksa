package common.bankarskiSistem.service;

import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConversionService conversionService;

    // UPDATE user
    public void updateUser(User user) {
        if(user == null)
            throw new NullPointerException("Null user");
        User existingUser
                = userRepository.findById(user.getPersonalId())
                .orElse(null);
        if (existingUser == null)
            throw new NullPointerException("No such user exists!");

        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAddress(user.getAddress());
        userRepository.save(existingUser);
    }

    // CREATE user
    public User saveUser(User user) {
        if(user == null)
            throw new NullPointerException("Null user");
        User existingUser
                = userRepository.findById(user.getPersonalId())
                .orElse(null);
        if (existingUser == null)
            return userRepository.save(user);

        throw new NullPointerException("This user already exists!");
    }

    // DELETE user by personal id (jmbg)
    public void deleteUserByPersonalId(String id) {
        if(id == null)
            throw new NullPointerException("Null personal id");
        User existingUser
                = userRepository.findById(id)
                .orElse(null);
        if (existingUser == null)
            throw new NullPointerException("No such user exists!");

        userRepository.deleteById(id);
    }

    //CREATE BANK ACCOUNT for user
    public BankAccount createBankAccount(User user, BankAccount bankAccount) {
        if(user == null)
            throw new NullPointerException("Null user");
        if(bankAccount == null)
            throw new NullPointerException("Null bank account");
        User existingUser
                = userRepository.findById(user.getPersonalId())
                .orElse(null);
        if (existingUser == null)
            throw new NullPointerException("This bank account already exists!");

        List<BankAccount> accounts = user.getBankAccounts();
        accounts.add(bankAccount);
        user.setBankAccounts(accounts);
        userRepository.save(user);
        return bankAccount;
    }

    public double payIn(String personalID, BankAccount account, float payment) {
        if (account == null) throw new NullPointerException("No account");

        if (payment <= 0)
            throw new IllegalArgumentException("Payment must be positive");

        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, account.getIdAccount());
        bankAccount.setBalance(bankAccount.getBalance() + payment);
        userRepository.save(user);

        return bankAccount.getBalance();
    }

    public double payOut(String personalID, BankAccount account, float payment) {
        if (account == null) throw new NullPointerException("No account");

        if (payment <= 0)
            throw new IllegalArgumentException("Payout must be positive");
        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, account.getIdAccount());
        if (payment > bankAccount.getBalance())
            throw new ArithmeticException("Payout is greater than balance");
        bankAccount.setBalance(bankAccount.getBalance() - payment);
        userRepository.save(user);

        return bankAccount.getBalance();
    }

    public void transfer(String personalID, BankAccount accountFrom, BankAccount accountTo, float payment) {
        if (accountFrom == null || accountTo == null)
            throw new NullPointerException("No accounts");

        if (payment <= 0)
            throw new IllegalArgumentException("Payout must be positive");

        if (accountFrom.getCurrency() != accountTo.getCurrency()) {
            payOut(personalID, accountFrom, payment);
            double convertedCurrency = conversionService.convert(
                    accountFrom.getCurrency(),
                    accountTo.getCurrency(),
                    accountFrom.getBank());
            payment *= convertedCurrency;
            payIn(personalID, accountTo, payment);
        } else {
            payOut(personalID, accountFrom, payment);
            payIn(personalID, accountTo, payment);
        }
    }

    public double getBalance(String personalID, BankAccount account) {
        //TODO currency
        if (account == null) throw new NullPointerException("No account");
        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, account.getIdAccount());
        return bankAccount.getBalance();
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

    public double getAllBalance(String personalID) {
        //TODO currency
        User user = getUserByPersonalID(personalID);
        return user.getBankAccounts().stream()
                .map(account -> getBalance(personalID, account))
                .reduce((double) 0, Double::sum);
    }

    public boolean deleteAccount(String personalId, BankAccount bankAccount){
        User user = getUserByPersonalID(personalId);
        if(bankAccount != null) {
            user.getBankAccounts().remove(bankAccount);
            userRepository.save(user);
            return true;
        } else throw new NullPointerException("The bank account does not exist!");
    }

    public boolean deleteAllAccounts(String personalId){
        User user = getUserByPersonalID(personalId);
        user.setBankAccounts(new ArrayList<BankAccount>());
        userRepository.save(user);
        return true;
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
        Optional<User> userOptional = userRepository.findById(personalID);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + personalID + "] not found");
        return userOptional.get();
    }
}
