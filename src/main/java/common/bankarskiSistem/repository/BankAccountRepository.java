package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
