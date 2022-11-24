package common.bankarskiSistem.service;

import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.Conversion;
import common.bankarskiSistem.model.Currency;
import common.bankarskiSistem.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversionService {

    @Autowired
    private ConversionRepository conversionRepository;

    public double convert(Currency currencyFrom, Currency currencyTo, Bank bank) {
        if (currencyFrom == null || currencyTo == null)
            throw new NullPointerException("Null currency");
        if (bank == null)
            throw new NullPointerException("Null bank");
        Optional<Conversion> conversionOptional =
                conversionRepository.findByCurrencyFromAndCurrencyToAndExchangeRates(
                        currencyFrom, currencyTo, bank.getExchangeRates());
        if(conversionOptional.isEmpty())
            throw new NullPointerException("Conversion not found");

        Conversion conversion = conversionOptional.get();

        return conversion.getValue();
    }

    public boolean deleteConversion(Conversion conversion){
        if (conversion == null) throw new NullPointerException("Conversion does not exist");
        conversionRepository.delete(conversion);
        return true;
    }
}
