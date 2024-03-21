package com.example.casestudy.implementation;

import com.example.casestudy.dto.BookTrackDTO;
import com.example.casestudy.entity.BookTrack;
import com.example.casestudy.repository.BookTrackRepository;
import com.example.casestudy.service.BookTrackService;
import com.example.casestudy.util.BookTrackMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTrackServiceImpl implements BookTrackService {

    @Autowired
    BookTrackRepository bookTrackRepository;

    @Autowired
    BookTrackMapper bookTrackMapper;

    @Override
    public List<BookTrackDTO> getAllBookTracks() {
        return bookTrackRepository.findAll().stream()
                .map(bookTrack -> bookTrackMapper.bookTrackToBookTrackDTO(bookTrack))
                .toList();
    }

    @Override
    public Optional<BookTrackDTO> getBookTrackById(long id) {
        Optional<BookTrack> bookTrack = bookTrackRepository.findById(id);
        return Optional.ofNullable(bookTrackMapper.bookTrackToBookTrackDTO(bookTrack.get()));
    }

    @Override
    @Transactional
    public BookTrackDTO createBookTrack(BookTrackDTO bookTrackDTO) {
        BookTrack bookTrack = bookTrackMapper.bookTrackDTOtoEntity(bookTrackDTO);
        BookTrack savedBookTrack = bookTrackRepository.save(bookTrack);
        return bookTrackMapper.bookTrackToBookTrackDTO(savedBookTrack);
    }

    @Override
    @Transactional
    public BookTrackDTO updateBookTrack(BookTrackDTO bookTrackDTO) {
        BookTrack bookTrack = bookTrackMapper.bookTrackDTOtoEntity(bookTrackDTO);
        BookTrack savedBookTrack = bookTrackRepository.save(bookTrack);
        return bookTrackMapper.bookTrackToBookTrackDTO(savedBookTrack);
    }

    @Override
    @Transactional
    public void delete(long id) {
        bookTrackRepository.deleteById(id);
    }
}
