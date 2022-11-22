package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Klasa racun sadrzi jedinstveni broj racuna koji pripada samo jednom {@link Korisnik}
 * i stanje raspolozovih sredstava u odredjenoj valuti.
 * Racun pipada samo jednoj banci i samo jednom korisniku i definisan je tip racuna
 * {@link Tip}
 */
@Entity
@Table (name = "bankAccount")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
    @Column(name = "balance", nullable = false)
    private float balance;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAccount", nullable = false)
    private Integer idAccount;

    @ManyToOne
    @JoinColumn(name="idCurrency")
    private Currency currency;
    @ManyToOne
    @JoinColumn(name="idType")
    private AccountType accountType;
    @ManyToOne
    @JoinColumn(name="personalId")
    private User user;
    @ManyToOne
    @JoinColumn(name="idBank")
    private Bank bank;

    public BankAccount(AccountType accountType, Currency currency, User user, Bank bank, int idAccount) {
        if(tipRacuna == null || valuta == null || korisnik == null || banka == null) {
            throw new NullPointerException("Null value while creating account");
        }
        this.accountType = accountType;
        this.balance = 0;
        this.currency = currency;
        this.idAccount = idAccount;
        this.user = user;
        this.bank = bank;
    }

    public BankAccount(AccountType accountType, Currency currency, User user, Bank bank, float balance, int idAccount) {
        this(accountType, currency, user, bank, idAccount);
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", idAccount=" + idAccount +
                ", currency=" + currency +
                ", account type=" + accountType +
                ", user=" + user +
                ", bank=" + bank +
                '}';
    }
}
