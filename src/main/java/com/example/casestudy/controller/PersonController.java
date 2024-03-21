package com.example.casestudy.controller;

import com.example.casestudy.dto.PersonDTO;
import com.example.casestudy.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/person")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/")
    public List<PersonDTO> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonDTO>> getPersonById(@PathVariable(value = "id") Long personId) {
        return ResponseEntity.ok().body(personService.getPersonById(personId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createPerson(@Valid @RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok().body(personService.updatePerson(personDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonDTO> deletePerson(@PathVariable(value = "id") Long personId) {
        personService.delete(personId);
        return ResponseEntity.ok().build();
    }
}
