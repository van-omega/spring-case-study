package com.example.casestudy.controller;

import com.example.casestudy.dto.LibrarianDTO;
import com.example.casestudy.service.LibrarianService;
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
@RequestMapping("/librarian")
public class LibrarianController {

    LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService){
        this.librarianService = librarianService;
    }

    @GetMapping("/")
    public List<LibrarianDTO> getAllLibrarians(){
        return librarianService.getAllLibrarians();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LibrarianDTO>> getLibrarianById(@PathVariable(value = "id") Long librarianId) {
        return ResponseEntity.ok().body(librarianService.getLibrarianById(librarianId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public LibrarianDTO createLibrarian(@Valid @RequestBody LibrarianDTO librarianDTO) {
        return librarianService.createLibrarian(librarianDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LibrarianDTO> updateLibrarian(@Valid @RequestBody LibrarianDTO librarianDTO) {
        return ResponseEntity.ok().body(librarianService.updateLibrarian(librarianDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LibrarianDTO> deleteLibrarian(@PathVariable(value = "id") Long librarianId) {
        librarianService.delete(librarianId);
        return ResponseEntity.ok().build();
    }
}
