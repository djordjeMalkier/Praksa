package common.bankarskiSistem.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * EUR - euro
 * RSD - dinar
 * USD - americki dolar
 */
@Entity
@Table(name = "currency")
@Getter
public enum Currency {
    EUR, RSD, USD;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurrency", nullable = false)
    private int idCurrency;

    @Column(name = "name", nullable = false)
    private String name;

}
