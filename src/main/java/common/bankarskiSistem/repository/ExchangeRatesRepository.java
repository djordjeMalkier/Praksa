package common.bankarskiSistem.repository;

import common.bankarskiSistem.model.ExchangeRates;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExchangeRatesRepository extends CrudRepository<ExchangeRates, Integer> {
    Optional<ExchangeRates> getByName(String name);
    Optional<ExchangeRates> findExchangeRatesByBankId(Integer idBank);
}
