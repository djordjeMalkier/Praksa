package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String personalId;

    private String name;

    private String surname;

    private String address;
    private List<BankAccount> bankAccounts;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID='" + personalId + '\'' +
                ", address='" + address + '\'' +
                "}";
    }
}
