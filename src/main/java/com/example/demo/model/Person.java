package com.example.demo.model;

import com.example.demo.dto.PersonDto;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private String email;

    @OneToOne(fetch = FetchType.EAGER , cascade = ALL)
    private PersonDetails personDetails;

    public Person() {
    }

    public Person(PersonDto personDto) {
       this.setEmail(personDto.getEmail());
       this.setLogin(personDto.getLogin());
       this.setPassword(personDto.getPassword());
       if (Objects.nonNull(personDto.getDetails())){
           PersonDetails personDetails = new PersonDetails(personDto.getDetails());
           this.setPersonDetails(personDetails);
       }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    @Transient
    public PersonDto toDto(){
        PersonDto personDto = new PersonDto();
        personDto. setEmail(this.email);
        personDto.setLogin(this.login);
        personDto.setId(this.id);
        if (this.personDetails != null){
            personDto.setDetails(this.personDetails.toDto());
        }
        personDto.setPassword(this.password);
        return personDto;
    }
}
