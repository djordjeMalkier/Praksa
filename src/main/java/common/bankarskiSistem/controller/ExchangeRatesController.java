package common.bankarskiSistem.controller;

import common.bankarskiSistem.controller.dto.ExchangeRatesDTO;
import common.bankarskiSistem.controller.dto.ExchangeRatesMapper;
import common.bankarskiSistem.model.ExchangeRates;
import common.bankarskiSistem.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value="/exchangeRates")
@RequiredArgsConstructor
@RestController
public class ExchangeRatesController {
    @Autowired
    private final BankService bankService;
    private final ExchangeRatesMapper mapperER = ExchangeRatesMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<ExchangeRatesDTO> saveExchangeRates(@RequestBody ExchangeRatesDTO exchangeRatesDTO) {
        ExchangeRates savedExchangeRates;
        try {
            savedExchangeRates = bankService.createExchangeRates(mapperER.convertToEntity(exchangeRatesDTO));

        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
        return ok(mapperER.convertToDTO(savedExchangeRates));
    }
}
