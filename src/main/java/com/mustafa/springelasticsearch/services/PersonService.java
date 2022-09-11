package com.mustafa.springelasticsearch.services;

import com.mustafa.springelasticsearch.entity.Person;
import com.mustafa.springelasticsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public List<Person> getByCustomQuery(String search) {
        return personRepository.getByCustomQuery(search);
    }

    public List<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameLikeOrSurnameLike(name, surname);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
