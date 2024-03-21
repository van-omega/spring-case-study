package com.example.casestudy.service;

import com.example.casestudy.dto.LibrarianDTO;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {
    List<LibrarianDTO> getAllLibrarians();
    Optional<LibrarianDTO> getLibrarianById(long id);
    LibrarianDTO createLibrarian(LibrarianDTO librarianDTO);
    LibrarianDTO updateLibrarian(LibrarianDTO librarianDTO);
    void delete(long id);
}
