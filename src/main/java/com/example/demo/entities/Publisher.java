package com.example.demo.entities;

import com.example.demo.dto.PublisherDto;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NIP
    private String nip;

    @REGON
    private String regon;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    @Transient
    public PublisherDto toDto() {
        PublisherDto dto = new PublisherDto();
        dto.setId(getId());
        dto.setName(getName());
        dto.setBooks(Optional.ofNullable(getBooks()).orElse(Collections.emptySet()).stream().map(Book::toDto).collect(Collectors.toList()));
        return dto;
    }

    @Transient
    public PublisherDto toCollectionlessDto() {
        PublisherDto dto = new PublisherDto();
        dto.setId(getId());
        dto.setName(getName());
        return dto;
    }
}
