package common.bankarskiSistem.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Tip racuna moze da bude dinarski sa valutom RSD
 * ili devizni sa deviznim valutama
 */
@Entity
@Table(name = "type")
@Getter
public enum AccountType {
    DINAR, FOREIGN ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idType", nullable = false)
    private int idType;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "idAccount")
    private List<BankAccount> idAccount;

}
