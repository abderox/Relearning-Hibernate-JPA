package com.adria.springbootdemo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE")
    private Long id;

    @Column(name = "SOLDE")
    private double solde;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TypeCompte type;

}

