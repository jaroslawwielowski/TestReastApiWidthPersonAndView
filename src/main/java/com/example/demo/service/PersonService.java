package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.impl.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService implements BaseService<PersonDto, Long> {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public PersonDto save(PersonDto dto) {

        Person person = new Person(dto);
        return personRepository.save(person).toDto();
    }

    @Override
    public PersonDto update(PersonDto dto) {
        return null;
    }

    @Override
    public PersonDto find(Long id) {
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        return null;
    }

    @Override
    public Collection<PersonDto> getAll() {
        return null;
    }
}
