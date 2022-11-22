package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
