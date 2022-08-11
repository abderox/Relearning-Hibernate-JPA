package org.adria.metier.dao;

import org.adria.metier.entities.Compte;
import org.adria.metier.utils.TypeCompte;

import java.util.List;

public interface CompteRepository {
    Compte save(Compte cp);
    List<Compte> findAll();
    List<Compte> findByType(TypeCompte type);
    Compte findByCode(Long code);
    Compte update(Compte cp);
    void delete(Long id);
}
