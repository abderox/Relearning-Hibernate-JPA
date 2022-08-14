package com.adria.springbootdemo.repositories;

import com.adria.springbootdemo.entities.Categorie;
import com.adria.springbootdemo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {



}
