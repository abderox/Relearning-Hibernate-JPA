package com.adria.springbootdemo.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
public class Categorie implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long idCategorie;
    private String nomCategorie;
    // ! la collection va rester vide au départ , pas de consommation mémoire
    @OneToMany(mappedBy = "categorie",fetch= FetchType.LAZY)
    private Collection<Produit> produits;



}
