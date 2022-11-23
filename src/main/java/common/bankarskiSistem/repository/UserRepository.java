package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> getAllByName(String name);
    Optional<User> getAllBySurname(String surname);
    Optional<User> getAllByNameAndSurname(String name, String surname);
    boolean existsByPersonalId(String personalId);
}
