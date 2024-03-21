package com.example.casestudy.util;

import com.example.casestudy.dto.BookDTO;
import com.example.casestudy.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    BookDTO bookEntityToBookDTO(Book book);
    Book bookDTOtoEntity(BookDTO bookDTO);
}
