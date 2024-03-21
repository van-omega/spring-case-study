package com.example.casestudy.implementation;

import com.example.casestudy.dto.PersonDTO;
import com.example.casestudy.entity.Person;
import com.example.casestudy.repository.PersonRepository;
import com.example.casestudy.service.PersonService;
import com.example.casestudy.util.PersonMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(librarian -> personMapper.personToPersonDTO(librarian))
                .toList();
    }

    @Override
    public Optional<PersonDTO> getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        return Optional.ofNullable(personMapper.personToPersonDTO(person.get()));
    }

    @Override
    @Transactional
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.personDTOtoEntity(personDTO);
        Person savedLibrarian= personRepository.save(person);
        return personMapper.personToPersonDTO(savedLibrarian);
    }

    @Override
    @Transactional
    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person person = personMapper.personDTOtoEntity(personDTO);
        Person savedLibrarian= personRepository.save(person);
        return personMapper.personToPersonDTO(person);
    }

    @Override
    @Transactional
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
