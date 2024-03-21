package com.example.casestudy.service;

import com.example.casestudy.dto.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonDTO> getAllPersons();
    Optional<PersonDTO> getPersonById(long id);
    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO updatePerson(PersonDTO personDTO);
    void delete(long id);
}
