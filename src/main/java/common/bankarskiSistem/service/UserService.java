package common.bankarskiSistem.service;

import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByPersonalId(String id) throws NullPointerException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + id + "] not found");
        return userOptional.get();
    }

    // UPDATE user
    public void update(User user) {
        userRepository
                .findById(user.getPersonalId()) // returns Optional<User>
                .ifPresent(userUpdated -> {
                    userUpdated.setName(user.getName());
                    userUpdated.setSurname(user.getSurname());
                    userUpdated.setAddress(user.getAddress());

                    userRepository.save(userUpdated);
                });
    }

    // DELETE user by personal id (jmbg)
    public void deleteByPersonalId(String id) {
        if(userRepository.existsByPersonalId(id)){
            userRepository.deleteById(id);
        }
    }

    // CREATE user
    public User save(User user) {
        return userRepository.save(user);
    }

    //CREATE ACCOUNT for user
    public void createBankAccount(User user, BankAccount bankAccount) {
        userRepository
                .findById(user.getPersonalId()) // returns Optional<User>
                .ifPresent(userUpdated -> {
                    List<BankAccount> accounts = user.getBankAccounts();
                    accounts.add(bankAccount);
                    userUpdated.setBankAccounts(accounts);
                    userRepository.save(userUpdated);
                });
    }

}
