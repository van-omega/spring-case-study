package com.example.casestudy.util;

import com.example.casestudy.dto.LibrarianDTO;
import com.example.casestudy.entity.Librarian;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LibrarianMapper {
    LibrarianDTO librarianToLibrarianDTO(Librarian librarian);
    Librarian librarianDTOtoEntity(LibrarianDTO librarianDTO);
}
