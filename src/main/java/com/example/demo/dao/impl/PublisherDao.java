package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.entities.Publisher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

@Component
@Transactional
public class PublisherDao extends AbstractBaseDao<Publisher, Long> implements BaseDao<Publisher, Long> {
    @Override
    public Publisher find(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    @Override
    public void delete(Publisher entity) {

    }

    @Override
    public Collection<Publisher> findAll() {
        return entityManager.createQuery("SELECT b FROM Publisher b", Publisher.class).getResultList();
    }

}