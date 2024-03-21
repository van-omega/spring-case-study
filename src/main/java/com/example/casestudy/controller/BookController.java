package com.example.casestudy.controller;

import com.example.casestudy.dto.BookDTO;
import com.example.casestudy.service.BookService;
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
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookDTO>> getBookById(@PathVariable(value = "id") Long bookId) {
        return ResponseEntity.ok().body(bookService.getBookById(bookId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(bookService.updateBook(bookDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable(value = "id") Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.ok().build();
    }
}
