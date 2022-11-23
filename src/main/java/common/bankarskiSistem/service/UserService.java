package common.bankarskiSistem.service;

import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByPersonalID(String personalID) throws NullPointerException {
        Optional<User> userOptional = userRepository.findById(personalID);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + personalID + "] not found");
        return userOptional.get();
    }

    public float payIn(String personalID, BankAccount account, float payment) {
        if (account == null) throw new NullPointerException("No account");

        if (payment <= 0)
            throw new IllegalArgumentException("Payment must be positive");

        User user = getUserByPersonalID(personalID);
        BankAccount bankAccount = getBankAccountByIdAccount(user, account.getIdAccount());
        bankAccount.setBalance(bankAccount.getBalance() + payment);
        userRepository.save(user);

        return bankAccount.getBalance();
    }

    public float payOut(String personalID, BankAccount account, float payment) {
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
            float convertedCurrency = 1;/*TODO accountFrom
                    .getBank()
                    .getExchangeRates()
                    .convert(accountFrom.getCurrency(), accountTo.getCurrency());*/
            payment *= convertedCurrency;
            payIn(personalID, accountTo, payment);
        } else {
            payOut(personalID, accountFrom, payment);
            payIn(personalID, accountTo, payment);
        }
    }

    public float getBalance(String personalID, BankAccount account) {
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

    public float getAllBalance(String personalID) {
        //TODO currency
        User user = getUserByPersonalID(personalID);
        return user.getBankAccounts().stream()
                .map(account -> getBalance(personalID, account))
                .reduce((float) 0, Float::sum);
    }

}
