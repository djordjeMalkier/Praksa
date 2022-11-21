package common.bankarskiSistem;

import javax.persistence.*;

/**
 * EUR - euro
 * RSD - dinar
 * USD - americki dolar
 */
@Entity
@Table(name = "valuta")
public enum Valuta {
    EUR, RSD, USD;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name =  "naziv", nullable = false)
    private String naziv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
