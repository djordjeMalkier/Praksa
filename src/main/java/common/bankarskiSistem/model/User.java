package common.bankarskiSistem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @Column(name="personal_id", nullable = false)
    private String personalId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts;

    public User(String personalId, String name, String surname, String address) {
        this.personalId = personalId;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.bankAccounts = new ArrayList<>();
    }

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
