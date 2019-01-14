package com.example.demo.service.impl;

import com.example.demo.dao.impl.BookDao;
import com.example.demo.dao.impl.PublisherDao;
import com.example.demo.dto.PublisherDto;
import com.example.demo.entities.Publisher;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PublisherService implements BaseService<PublisherDto, Long> {
    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    @Autowired
    public PublisherService(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @Override
    public PublisherDto save(PublisherDto dto) {
        Publisher publisher = new Publisher(dto.getName());
        if (Objects.nonNull(dto.getBooks()) && !dto.getBooks().isEmpty()) {
            publisher.setBooks(dto.getBooks().stream().map(el -> bookDao.find(el.getId())).collect(Collectors.toSet()));
        }
        publisherDao.save(publisher);
        return publisher.toDto();
    }

    @Override
    public PublisherDto update(PublisherDto dto) {
        Publisher publisher = publisherDao.find(dto.getId());
        publisher.setName(dto.getName());
        publisherDao.update(publisher);
        return publisher.toDto();
    }

    @Override
    public PublisherDto find(Long id) {
        return publisherDao.find(id).toDto();
    }

    @Override
    public Boolean remove(Long id) {
        Publisher book = publisherDao.find(id);
        publisherDao.delete(book);
        return true;
    }

    @Override
    public Collection<PublisherDto> getAll() {
        return publisherDao.findAll().stream().filter(Objects::nonNull).map(Publisher::toDto)
                .collect(Collectors.toList());
    }
}