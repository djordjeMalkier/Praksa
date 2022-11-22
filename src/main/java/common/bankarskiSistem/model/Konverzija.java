package common.bankarskiSistem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Konverzija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idKonverzije", nullable = false)
    private Long idKonverzije;

    @OneToOne
    private Valuta from;

    @OneToOne
    private Valuta to;

    @Column(name = "value", nullable = false)
    private double value;

}
