package common.bankarskiSistem.controller;

import common.bankarskiSistem.controller.dto.ConversionDTO;
import common.bankarskiSistem.controller.dto.ConversionMapper;
import common.bankarskiSistem.controller.dto.ExchangeRatesDTO;
import common.bankarskiSistem.controller.dto.ExchangeRatesMapper;
import common.bankarskiSistem.model.Conversion;
import common.bankarskiSistem.model.ExchangeRates;
import common.bankarskiSistem.service.BankService;
import common.bankarskiSistem.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value="/exchangeRates")
@RequiredArgsConstructor
@RestController
public class ExchangeRatesController {
    @Autowired
    private final BankService bankService;
    @Autowired
    private final ConversionService conversionService;
    private final ExchangeRatesMapper mapperER = ExchangeRatesMapper.INSTANCE;
    private final ConversionMapper mapperC = ConversionMapper.INSTANCE;

    @PostMapping("/add")
    public ResponseEntity<ExchangeRatesDTO> saveExchangeRates(@RequestBody ExchangeRatesDTO exchangeRatesDTO) {
        ExchangeRates savedExchangeRates;
        try {
            savedExchangeRates = bankService.createExchangeRates(mapperER.convertToEntity(exchangeRatesDTO));

        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
        return ok(mapperER.convertToDTO(savedExchangeRates));
    }

    @PutMapping("/update")
    public ResponseEntity<ExchangeRatesDTO> updateExchangeRates(@RequestParam Integer idExchangeRates, @RequestBody ExchangeRatesDTO updatedExchangeRates){
        ExchangeRates exchangeRates;
        try{
             exchangeRates = bankService.findByIdExchangeRates(idExchangeRates);
             bankService.updateExchangeRates(exchangeRates,updatedExchangeRates.getName());



        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }

        return ok(mapperER.convertToDTO(exchangeRates));
    }

    @PostMapping("/addConversion")
    public ResponseEntity<ConversionDTO> addConversion(@RequestBody ConversionDTO conversionDTO) {
        Conversion conversion;
        try {
            conversion = conversionService.addConversion(mapperC.convertToEntity(conversionDTO));

        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
        return ok(mapperC.convertToDTO(conversion));
    }

    @PutMapping("/updateConversion")
    public ResponseEntity<ConversionDTO> updateConversion(@RequestBody ConversionDTO updatedConversion){
        Conversion conversion;
        try{
            conversion = conversionService.updateConversion(mapperC.convertToEntity(updatedConversion));

        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }

        return ok(mapperC.convertToDTO(conversion));
    }

    @DeleteMapping("/deleteConversion")
    public String deleteConversion(@RequestParam Integer idConversion) {
        Conversion conversion;
        try{
            conversion = conversionService.findByIdConversion(idConversion);
            conversionService.deleteConversion(conversion);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        ok(mapperC.convertToDTO(conversion));
        return "The conversion is deleted successfully.";
    }

    @GetMapping("/getConversion")
    public ResponseEntity<ConversionDTO> getConversionById(@RequestParam(value = "h") Integer idConversion) {
        Conversion conversion;
        try{
            conversion = conversionService.findByIdConversion(idConversion);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapperC.convertToDTO(conversion));
    }

}
