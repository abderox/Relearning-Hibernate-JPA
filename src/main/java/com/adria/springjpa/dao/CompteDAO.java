package com.adria.springjpa.dao;

import com.adria.springjpa.TypeCompte;
import com.adria.springjpa.entities.Compte;

import java.util.List;

public interface CompteDAO {
    Compte save(Compte cp);
    List<Compte> findAll();
    List<Compte> findByType(TypeCompte type);
    Compte findByCode(Long code);
    Compte update(Compte cp);
    void delete(Long id);
}
