package com.adria.springbootdemo.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long idProduit;
    private String designation;
    private double prix;
    @ManyToOne
    @JoinColumn(name="ID_CAT")
    private Categorie categorie;
}
