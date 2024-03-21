package com.example.casestudy.util;

import com.example.casestudy.dto.AuthorDTO;
import com.example.casestudy.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {
    AuthorDTO authorEntityToAuthorDTO(Author author);
    Author authorDTOtoEntity(AuthorDTO authorDTO);
}
