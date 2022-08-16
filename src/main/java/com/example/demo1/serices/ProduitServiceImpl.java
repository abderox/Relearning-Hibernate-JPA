package com.example.demo1.serices;

import com.example.demo1.entities.Produit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProduitServiceImpl implements ProduitService {

    private Long productIndex = 0L;
    private Map<Long, Produit> produits = new HashMap<>( );

    @Override
    public Produit save(Produit produit) {
        if ( produit.getId( ) == null ) produit.setId(++productIndex);
        return produits.put(productIndex, produit);
    }

    @Override
    public List<Produit> findAllProduits() {
        return new ArrayList<>(produits.values( ));
    }

    @Override
    public List<Produit> findByName(String name) {
        return produits.values( ).stream( ).filter(produit -> produit.getName( ).contains(name)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        produits.remove(id);
    }

    @Override
    public Produit update(Produit produit) {
        produits.replace(produit.getId( ), produit);
        return produits.get(produit.getId( ));
    }

    @Override
    public void initialize() {
        save(new Produit( null,"ord",1450));
        save(new Produit( null,"bard",120.12));
        save(new Produit( null,"pc",1340));
        save(new Produit( null,"ord",120.12));
        save(new Produit( null,"lapt",120.12));
        save(new Produit( null,"ord",1240));
        save(new Produit( null,"bbc",120.12));
        save(new Produit( null,"ord",6000));
        save(new Produit( null,"milo",4520));
    }
}
