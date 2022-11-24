package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ova klasa je zaduzena za sve u vezi sa Bankma. Klasa se pravi sa dva konstruktora.
 * Prvi konstruktor sa tri parametra  se koristi u koliko se Bank tek kreira i trenutno nema nijednog korisnika.
 * Drugi konstruktor sa cetiri parametra  u koliko zelimo da napravimo banku sa korisnicima.
 * I default-ni konstruktor.
 */

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBank", nullable = false)
    private Integer idBank;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "idAccount")
    private List<BankAccount> bankAccounts;
    @ManyToOne
    @JoinColumn(name = "idExchangeRates")
    private ExchangeRates exchangeRates;

    public Bank(String name, String address, ExchangeRates exchangeRates) {
        this.name = name;
        this.address = address;
        this.bankAccounts = new ArrayList<>();
        this.exchangeRates = exchangeRates;
    }

    public Bank(int idBank, String name, String address, List<BankAccount> bankAccounts, ExchangeRates exchangeRates) {
        this.idBank = idBank;
        this.name = name;
        this.address = address;
        this.bankAccounts = bankAccounts;
        this.exchangeRates = exchangeRates;
    }

    public Bank() {
        this.bankAccounts = new ArrayList<>();
    }


}
