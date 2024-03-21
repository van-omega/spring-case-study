package com.example.casestudy.controller;

import com.example.casestudy.dto.BookTrackDTO;
import com.example.casestudy.service.BookTrackService;
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
@RequestMapping("/book-track")
public class BookTrackController {

    BookTrackService bookTrackService;

    @Autowired
    public BookTrackController(BookTrackService bookTrackService){
        this.bookTrackService = bookTrackService;
    }

    @GetMapping("/")
    public List<BookTrackDTO> getAllBookTracks(){
        return bookTrackService.getAllBookTracks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookTrackDTO>> getBookTrackById(@PathVariable(value = "id") Long bookTrackId) {
        return ResponseEntity.ok().body(bookTrackService.getBookTrackById(bookTrackId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public BookTrackDTO createBookTrack(@Valid @RequestBody BookTrackDTO bookTrackDTO) {
        return bookTrackService.createBookTrack(bookTrackDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookTrackDTO> updateBookTrack(@Valid @RequestBody BookTrackDTO bookTrackDTO) {
        return ResponseEntity.ok().body(bookTrackService.updateBookTrack(bookTrackDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookTrackDTO> deleteBookTrack(@PathVariable(value = "id") Long bookTrackId) {
        bookTrackService.delete(bookTrackId);
        return ResponseEntity.ok().build();
    }
}
