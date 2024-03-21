package com.example.casestudy.controller;

import com.example.casestudy.dto.AuthorDTO;
import com.example.casestudy.service.AuthorService;
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
@RequestMapping("/author")
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<AuthorDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AuthorDTO>> getAuthorById(@PathVariable(value = "id") Long authorId) {
        return ResponseEntity.ok().body(authorService.getAuthorById(authorId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok().body(authorService.updateAuthor(authorDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        authorService.delete(authorId);
        return ResponseEntity.ok().build();
    }

}
