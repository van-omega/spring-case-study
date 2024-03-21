package com.example.casestudy.implementation;

import com.example.casestudy.dto.AuthorDTO;
import com.example.casestudy.entity.Author;
import com.example.casestudy.repository.AuthorRepository;
import com.example.casestudy.service.AuthorService;
import com.example.casestudy.util.AuthorMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> authorMapper.authorEntityToAuthorDTO(author))
                .toList();
    }

    @Override
    public Optional<AuthorDTO> getAuthorById(long id) {
        Optional<Author> author = authorRepository.findById(id);
        return Optional.ofNullable(authorMapper.authorEntityToAuthorDTO(author.get()));
    }

    @Override
    @Transactional
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDTOtoEntity(authorDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorEntityToAuthorDTO(savedAuthor);
    }

    @Override
    @Transactional
    public AuthorDTO updateAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDTOtoEntity(authorDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorEntityToAuthorDTO(savedAuthor);
    }

    @Override
    @Transactional
    public void delete(long id) {
        authorRepository.deleteById(id);
    }
}
