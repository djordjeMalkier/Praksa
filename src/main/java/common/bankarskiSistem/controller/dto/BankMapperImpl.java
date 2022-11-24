package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Bank;

public class BankMapperImpl implements BankMapper{
    @Override
    public BankDto convertToDTO(Bank bank) {
        if (bank == null)
            return null;

        BankDto bankDto = new BankDto();
        bankDto.setIdBank(bank.getIdBank());
        bankDto.setName(bank.getName());
        bankDto.setAddress(bank.getAddress());
        bankDto.setBankAccounts(bank.getBankAccounts());
        bankDto.setExchangeRates(bank.getExchangeRates());
        return bankDto;
    }

    @Override
    public Bank convertToEntity(BankDto bankDto){
        if ( bankDto == null ) {
            return null;
        }
        Bank bank = new Bank();
        bank.setIdBank(bankDto.getIdBank());
        bank.setName(bankDto.getName());
        bank.setAddress(bankDto.getAddress());
        bank.setBankAccounts(bankDto.getBankAccounts());
        bank.setExchangeRates(bankDto.getExchangeRates());

        return bank;
    }
}
