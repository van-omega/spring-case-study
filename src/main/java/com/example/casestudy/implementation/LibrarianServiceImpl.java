package com.example.casestudy.implementation;

import com.example.casestudy.dto.LibrarianDTO;
import com.example.casestudy.entity.Librarian;
import com.example.casestudy.repository.LibrarianRepository;
import com.example.casestudy.service.LibrarianService;
import com.example.casestudy.util.LibrarianMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    LibrarianRepository librarianRepository;

    @Autowired
    LibrarianMapper librarianMapper;

    @Override
    public List<LibrarianDTO> getAllLibrarians() {
        return librarianRepository.findAll().stream()
                .map(librarian -> librarianMapper.librarianToLibrarianDTO(librarian))
                .toList();
    }

    @Override
    public Optional<LibrarianDTO> getLibrarianById(long id) {
        Optional<Librarian> librarian = librarianRepository.findById(id);
        return Optional.ofNullable(librarianMapper.librarianToLibrarianDTO(librarian.get()));
    }

    @Override
    @Transactional
    public LibrarianDTO createLibrarian(LibrarianDTO librarianDTO) {
        Librarian librarian = librarianMapper.librarianDTOtoEntity(librarianDTO);
        Librarian savedLibrarian= librarianRepository.save(librarian);
        return librarianMapper.librarianToLibrarianDTO(savedLibrarian);
    }

    @Override
    @Transactional
    public LibrarianDTO updateLibrarian(LibrarianDTO librarianDTO) {
        Librarian librarian = librarianMapper.librarianDTOtoEntity(librarianDTO);
        Librarian savedLibrarian= librarianRepository.save(librarian);
        return librarianMapper.librarianToLibrarianDTO(savedLibrarian);
    }

    @Override
    @Transactional
    public void delete(long id) {
        librarianRepository.deleteById(id);
    }
}
