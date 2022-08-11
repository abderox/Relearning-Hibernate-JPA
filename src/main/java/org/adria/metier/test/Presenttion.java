package org.adria.metier.test;

import org.adria.metier.dao.EntityManagerFactorySingleton;
import org.adria.metier.entities.Compte;
import org.adria.metier.utils.TypeCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class Presenttion {

    public static void main(String[] args)  {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager( );
        EntityTransaction et = em.getTransaction( );


        Compte cp = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp1 = new Compte(null, 2000, new Date( ), TypeCompte.COURANT);
        Compte cp2 = new Compte(null, 402580.99, new Date( ), TypeCompte.COURANT);
        Compte cp3 = new Compte(null, 420.65, new Date( ), TypeCompte.EPARGNE);
        Compte cp4 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp5 = new Compte(null, 70000, new Date( ), TypeCompte.COURANT);
        Compte cp6 = new Compte(null, 402580.99, new Date( ), TypeCompte.EPARGNE);
        Compte cp7 = new Compte(null, 3450, new Date( ), TypeCompte.COURANT);
        Compte cp8 = new Compte(null, 40000, new Date( ), TypeCompte.EPARGNE);
        Compte cp9 = new Compte(null, 10000, new Date( ), TypeCompte.COURANT);
        Compte cp11 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp12 = new Compte(null, 2000, new Date( ), TypeCompte.COURANT);
        Compte cp13 = new Compte(null, 402580.99, new Date( ), TypeCompte.COURANT);
        Compte cp14 = new Compte(null, 420.65, new Date( ), TypeCompte.EPARGNE);
        Compte cp15 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp16 = new Compte(null, 70000, new Date( ), TypeCompte.COURANT);
        Compte cp17 = new Compte(null, 402580.99, new Date( ), TypeCompte.EPARGNE);
        Compte cp18 = new Compte(null, 3450, new Date( ), TypeCompte.COURANT);
        Compte cp19 = new Compte(null, 40000, new Date( ), TypeCompte.EPARGNE);
        Compte cp20 = new Compte(null, 10000, new Date( ), TypeCompte.COURANT);

        List<Compte> comptesList = Arrays.asList(cp, cp1, cp2, cp3,cp4, cp5, cp6, cp7, cp8,cp9, cp11, cp12, cp13, cp14, cp15,cp16, cp17, cp18, cp19, cp20);
        Iterator<Compte> it = comptesList.iterator( );

        long t1 = 0;
        long t2 = 0;

        try {

            et.begin( );

            int count = 0;
            int batchSize = 5;
            t1 = System.currentTimeMillis();
            while (it.hasNext()) {

                em.persist(it.next());
                count++;
                if(count % batchSize==0)
                {
//                    em.flush();
//                    em.clear();
                    et.commit();
                    et.begin();
                }

            }
            et.commit( );
            t2 = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace( );
            et.rollback();
        } finally {
            em.close();
            System.out.println("DONE");
            System.out.println("Elapsed time : "+((float)(t2-t1)/1000) +" s");
        }

    }
}
