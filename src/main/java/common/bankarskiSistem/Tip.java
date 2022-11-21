package common.bankarskiSistem;

import javax.persistence.*;

/**
 * Tip racuna moze da bude dinarski sa valutom RSD
 * ili devizni sa deviznim valutama
 */
@Entity
@Table(name = "tip")
public enum Tip {
    DINARSKI,DEVIZNI;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "naziv", nullable = false)
    private String naziv;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
