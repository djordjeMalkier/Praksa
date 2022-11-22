package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Integer> {
    Optional<ExchangeRates> getByName(String name);
}
