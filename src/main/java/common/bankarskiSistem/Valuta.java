package common.bankarskiSistem;

import lombok.Getter;

import javax.persistence.*;

/**
 * EUR - euro
 * RSD - dinar
 * USD - americki dolar
 */
@Entity
@Table(name = "valuta")
@Getter
public enum Valuta {
    EUR, RSD, USD;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idValuta", nullable = false)
    private int idValuta;

    @Column(name = "naziv", nullable = false)
    private String naziv;

}
