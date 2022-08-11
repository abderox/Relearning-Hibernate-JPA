package org.adria.metier.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton{
    private static final EntityManagerFactory EMF;
    static {
        EMF = Persistence.createEntityManagerFactory("UP_BK");
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return EMF;
    }
}
