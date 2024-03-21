package com.example.casestudy.service;

import com.example.casestudy.dto.BookTrackDTO;

import java.util.List;
import java.util.Optional;

public interface BookTrackService {
    List<BookTrackDTO> getAllBookTracks();
    Optional<BookTrackDTO> getBookTrackById(long id);
    BookTrackDTO createBookTrack(BookTrackDTO bookTrackDTO);
    BookTrackDTO updateBookTrack(BookTrackDTO bookTrackDTO);
    void delete(long id);
}
