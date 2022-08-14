package com.adria.springjpa.dao;

import com.adria.springjpa.entities.Compte;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;


@Transactional
public class ClassDAOImpl<T, ID> implements ClassDAO<T, ID> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public T save(T cp) {
        em.persist(cp);
        return cp;
    }

    @Override
    public List<T> findAll() {
        // ! get className ; programmation par réflexion
        Class<T> classEntity = (Class<T>) ((ParameterizedType) getClass( ).getGenericSuperclass( )).getActualTypeArguments( )[0];
        Query query = em.createQuery("select c from " + classEntity.getName( ) + " as c");
        return query.getResultList( );
    }

    @Override
    public T findByCode(ID code) {
        Class<T> classEntity = (Class<T>) ((ParameterizedType) getClass( ).getGenericSuperclass( )).getActualTypeArguments( )[0];
        return em.find(classEntity, code);

    }

    @Override
    public T update(T cp) {
        em.merge(cp);
        return cp;
    }

    @Override
    public void delete(ID id) {
        Class<T> classEntity = (Class<T>) ((ParameterizedType) getClass( ).getGenericSuperclass( )).getActualTypeArguments( )[0];
        T o = em.find(classEntity, id);
        em.remove(o);
    }
}
