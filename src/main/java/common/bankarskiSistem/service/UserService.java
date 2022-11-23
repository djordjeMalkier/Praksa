package common.bankarskiSistem.service;

import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int payIn(BankAccount bank) {

        return 0;
    }

}
