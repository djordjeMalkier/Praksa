package common.bankarskiSistem.service;

import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int payIn(BankAccount bank) {

        return 0;
    }

    public boolean deleteAccount(String personalId, BankAccount bankAccount){
        User user = getUserByPersonalID(personalId);
        if(bankAccount != null) {
            user.getBankAccounts().remove(bankAccount);
            userRepository.save(user);
            return true;
        } else throw new NullPointerException("The bank account does not exist!");
    }

    public boolean deleteAllAccount(String personalId){
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
        Optional<User> userOptional = userRepository.findById(personalID);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + personalID + "] not found");
        return userOptional.get();
    }


}
