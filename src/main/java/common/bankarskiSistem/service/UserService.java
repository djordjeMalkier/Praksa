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
        Optional<User> user = userRepository.findById(personalId);
        if(user.
                isEmpty()) return false;
        user.ifPresent(u -> u.getBankAccounts().remove(bankAccount));
        user.ifPresent(u -> userRepository.save(u));
        return true;
    }

    public boolean deleteAllAccount(String personalId){
        Optional<User> user = userRepository.findById(personalId);
        if(user.isEmpty()) return false;
        user.ifPresent(u -> u.setBankAccounts(new ArrayList<BankAccount>()));
        user.ifPresent(u -> userRepository.save(u));
        return true;
    }

    public List<BankAccount> getAllAccounts(String personalId){
        Optional<User> user = userRepository.findById(personalId);
        return user.map(User::getBankAccounts).orElse(null);
    }


}
