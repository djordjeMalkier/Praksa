package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
