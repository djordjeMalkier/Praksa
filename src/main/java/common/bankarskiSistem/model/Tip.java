package common.bankarskiSistem.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Tip racuna moze da bude dinarski sa valutom RSD
 * ili devizni sa deviznim valutama
 */
@Entity
@Table(name = "Tip")
@Getter
public enum Tip {
    DINARSKI,DEVIZNI;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTip", nullable = false)
    private int idTip;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "idTip")
    private List<Racun> racuni;

}
