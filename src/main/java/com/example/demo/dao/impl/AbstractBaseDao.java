package com.example.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public abstract class AbstractBaseDao<E, I extends Serializable> {

    @PersistenceContext
    protected EntityManager entityManager;

    public E save(E entity){
        entityManager.persist(entity);
        return entity;
    }

    public E update(E entity){
        return entityManager.merge(entity);
    }

    private void delete(E entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
