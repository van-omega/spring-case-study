package com.example.casestudy.service;

import com.example.casestudy.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();
    Optional<BookDTO> getBookById(long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void delete(long id);
}
