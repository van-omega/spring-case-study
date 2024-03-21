package com.example.casestudy.implementation;

import com.example.casestudy.dto.BookDTO;
import com.example.casestudy.entity.Author;
import com.example.casestudy.entity.Book;
import com.example.casestudy.repository.BookRepository;
import com.example.casestudy.service.BookService;
import com.example.casestudy.util.BookMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> bookMapper.bookEntityToBookDTO(book))
                .toList();
    }

    @Override
    public Optional<BookDTO> getBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return Optional.ofNullable(bookMapper.bookEntityToBookDTO(book.get()));
    }

    @Override
    @Transactional
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOtoEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookEntityToBookDTO(savedBook);
    }

    @Override
    @Transactional
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOtoEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookEntityToBookDTO(savedBook);
    }

    @Override
    @Transactional
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
