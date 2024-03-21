package com.example.casestudy.util;

import com.example.casestudy.dto.PersonDTO;
import com.example.casestudy.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    PersonDTO personToPersonDTO(Person person);
    Person personDTOtoEntity(PersonDTO personDTO);
}
