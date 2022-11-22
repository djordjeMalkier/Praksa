package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByPersonalId(String personalId);
}
