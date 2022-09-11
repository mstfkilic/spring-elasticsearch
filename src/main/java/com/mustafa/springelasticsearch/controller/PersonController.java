package com.mustafa.springelasticsearch.controller;

import com.mustafa.springelasticsearch.entity.Person;
import com.mustafa.springelasticsearch.repository.PersonRepository;
import com.mustafa.springelasticsearch.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setName("Mustafa");
        person.setSurname("Kılıç");
        person.setAddress("İstanbul");
        person.setBirthDate(Calendar.getInstance().getTime());
        person.setId("k0001");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPersonList(@PathVariable String search) {
        List<Person> personList = personService.findByNameAndSurname(search,search);
        return ResponseEntity.ok(personList);
    }
}
