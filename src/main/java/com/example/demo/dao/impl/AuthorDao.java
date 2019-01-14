package com.example.demo.dao.impl;


import com.example.demo.dao.BaseDao;
import com.example.demo.entities.Author;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

@Component
@Transactional
public class AuthorDao extends AbstractBaseDao<Author, Long> implements BaseDao<Author, Long> {

    @Override
    public Author find(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void delete(Author entity) {

    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT b FROM Author b", Author.class).getResultList();
    }

}
