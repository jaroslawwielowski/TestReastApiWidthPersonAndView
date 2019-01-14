package com.example.demo.entities;


import com.example.demo.dto.AuthorDto;
import org.hibernate.validator.constraints.pl.PESEL;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @PESEL
    private String pesel;

    @REGON
    private String regon;


    private LocalDate yearOfBirth;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Author(String firstName) {
        this.firstName = firstName;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Transient
    public AuthorDto toDto() {
        AuthorDto dto = this.toCollectionlessDto();
        dto.setBooks(Optional.ofNullable(this.getBooks()).orElse(Collections.emptySet()).stream().map(Book::toDto).collect(Collectors.toList()));
        return dto;
    }

    @Transient
    public AuthorDto toCollectionlessDto() {
        AuthorDto dto = new AuthorDto();
        dto.setId(this.getId());
        dto.setFirstName(this.getFirstName());
        dto.setLastName(this.getLastName());
        dto.setYearOfBirth(this.getYearOfBirth());
        return dto;
    }
}

