package org.adria.metier.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adria.metier.utils.TypeCompte;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="COMPTES")
@Data  @AllArgsConstructor @NoArgsConstructor
public class Compte implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE")
    private Long id;

    @Column(name = "SOLDE")
    private double  solde;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

}
