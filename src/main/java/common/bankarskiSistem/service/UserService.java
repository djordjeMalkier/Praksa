package common.bankarskiSistem.service;

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
        if(id == null)
            throw new NullPointerException("Null personal id");
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            throw new NullPointerException("User [" + id + "] not found");
        return userOptional.get();
    }

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
}