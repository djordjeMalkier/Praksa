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
            throw new NullPointerException("Conversion " + currencyFrom + " to " + currencyTo + " not found");

        Conversion conversion = conversionOptional.get();

        return conversion.getValue();
    }


    public Conversion addConversion(Conversion conversion) {
        if(conversion == null)
            throw new NullPointerException("Null conversion");
        Conversion existingConversion
                = conversionRepository.findById(conversion.getIdConversion())
                .orElse(null);
        if (existingConversion == null)
            return conversionRepository.save(conversion);

        throw new NullPointerException("This conversion already exists!");
    }

    public Conversion updateConversion(Conversion conversion) {
        if(conversion == null)
            throw new NullPointerException("Null conversion");
        Conversion existingConversion
                = conversionRepository.findById(conversion.getIdConversion())
                .orElseThrow(() -> new NullPointerException("No such conversion exists!"));

        existingConversion.setCurrencyFrom(conversion.getCurrencyFrom());
        existingConversion.setCurrencyTo(conversion.getCurrencyTo());
        existingConversion.setValue(conversion.getValue());
        return conversionRepository.save(existingConversion);
    }

    public Conversion deleteConversion(Conversion conversion){
        if (conversion == null) throw new NullPointerException("Conversion does not exist");
        conversionRepository.delete(conversion);
        return conversion;
    }
}
