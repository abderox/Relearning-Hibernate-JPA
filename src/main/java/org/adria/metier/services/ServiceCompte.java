package org.adria.metier.services;

import org.adria.metier.dao.CompteRepository;
import org.adria.metier.dao.EntityManagerFactorySingleton;
import org.adria.metier.entities.Compte;
import org.adria.metier.utils.TypeCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class ServiceCompte implements CompteRepository {

    private EntityManager em;
    private EntityTransaction et;
    public ServiceCompte() {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        et = em.getTransaction( );
    }

    @Override
    public Compte save(Compte cp) {
        try {
            et.begin( );
            em.persist(cp);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace( );
            et.rollback();
        }
        return cp;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public List<Compte> findAll() {
        List<Compte> comptes = null;
        try {
            et.begin( );
            Query query =em.createNamedQuery("Compte.findAll",Compte.class);
            comptes = query.getResultList();

            et.commit();
        } catch (Exception e) {
            e.printStackTrace( );
            et.rollback();
        }
        assert comptes != null;
        return comptes;
    }

    @Override
    public List<Compte> findByType(TypeCompte type) {
        List<Compte> comptes = null;

        try {
            et.begin( );
            Query query =em.createNativeQuery("SELECT * FROM COMPTES where type=(:x)",Compte.class);
             query.setParameter("x", type.equals(TypeCompte.COURANT)?"COURANT":"EPARGNE");

            comptes = query.getResultList();

            et.commit();
        } catch (Exception e) {
            e.printStackTrace( );
            et.rollback();
        }
        assert comptes != null;
        return comptes;

    }

    @Override
    public Compte findByCode(Long code) {
        Compte cp = null;
        try {
            et.begin();
             cp = em.find(Compte.class,code);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace( );
            et.rollback();
        }
        assert cp != null;
        return cp;
    }

    @Override
    public Compte update(Compte cp) {
        et.begin();
        em.merge(cp);
        et.commit();
        return cp;
    }

    @Override
    public void delete(Long id) {
    et.begin();
        em.flush();
        em.clear();
        Query query = em.createNativeQuery("DELETE from COMPTES  WHERE CODE = :id",Compte.class);
        query.setParameter("id", id);
        query.executeUpdate();
    et.commit();
    }
}
