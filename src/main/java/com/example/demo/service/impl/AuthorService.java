package com.example.demo.service.impl;


import com.example.demo.dao.impl.AuthorDao;
import com.example.demo.dao.impl.BookDao;
import com.example.demo.dto.AuthorDto;
import com.example.demo.entities.Author;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthorService implements BaseService<AuthorDto, Long> {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    @Autowired
    public AuthorService(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @Override
    public AuthorDto save(AuthorDto dto) {
        Author author = new Author(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setYearOfBirth(dto.getYearOfBirth());
        if (Objects.nonNull(dto.getBooks()) && !dto.getBooks().isEmpty()) {
            author.setBooks(dto.getBooks().stream().map(el -> bookDao.find(el.getId())).collect(Collectors.toSet()));
        }
        authorDao.save(author);
        return author.toDto();
    }

    @Override
    public AuthorDto update(AuthorDto dto) {
        Author author = authorDao.find(dto.getId());
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setYearOfBirth(dto.getYearOfBirth());
        author = authorDao.update(author);
        return author.toDto();
    }

    @Override
    public AuthorDto find(Long id) {
        Author author = authorDao.find(id);
        if (Objects.nonNull(author)) {
            return author.toDto();
        }
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        Author book = authorDao.find(id);
        authorDao.delete(book);
        return true;
    }

    @Override
    public Collection<AuthorDto> getAll() {
        return authorDao.findAll().stream().filter(Objects::nonNull).map(Author::toDto).collect(Collectors.toList());
    }
}