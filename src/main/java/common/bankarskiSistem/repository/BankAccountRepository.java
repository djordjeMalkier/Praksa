package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
