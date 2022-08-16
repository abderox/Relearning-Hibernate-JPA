package com.example.demo1.serices;

import com.example.demo1.entities.Produit;

import java.util.List;

public interface ProduitService {
    Produit save(Produit produit);
    List<Produit> findAllProduits();
    List<Produit> findByName(String name);
    void delete(Long id);
    Produit update(Produit produit);
    void initialize();
}
