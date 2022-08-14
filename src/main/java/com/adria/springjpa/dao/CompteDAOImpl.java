package com.adria.springjpa.dao;

import com.adria.springjpa.TypeCompte;
import com.adria.springjpa.entities.Compte;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CompteDAOImpl implements CompteDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Compte save(Compte cp) {

        em.persist(cp);

        return cp;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public List<Compte> findAll() {
        List<Compte> comptes = null;

        Query query = em.createQuery("select c from Compte c",Compte.class);


        comptes = query.getResultList( );

        System.out.println(comptes );

        return comptes;
    }

    @Override
    public List<Compte> findByType(TypeCompte type) {
        List<Compte> comptes = null;

        Query query = em.createNativeQuery("SELECT * FROM COMPTES where type=(:x)", Compte.class);
        query.setParameter("x", type.equals(TypeCompte.COURANT) ? "COURANT" : "EPARGNE");

        comptes = query.getResultList( );


        assert comptes != null;
        return comptes;

    }

    @Override
    public Compte findByCode(Long code) {
        Compte cp = null;

        cp = em.find(Compte.class, code);


        assert cp != null;
        return cp;
    }

    @Override
    public Compte update(Compte cp) {

        em.merge(cp);

        return cp;
    }

    @Override
    public void delete(Long id) {

        em.flush( );
        em.clear( );
        Query query = em.createNativeQuery("DELETE from COMPTES  WHERE CODE = :id", Compte.class);
        query.setParameter("id", id);
        query.executeUpdate( );

    }
}
