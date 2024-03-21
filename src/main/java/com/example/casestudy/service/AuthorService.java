package com.example.casestudy.service;

import com.example.casestudy.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    Optional<AuthorDTO> getAuthorById(long id);
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    AuthorDTO updateAuthor(AuthorDTO authorDTO);
    void delete(long id);
}
