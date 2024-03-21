package com.example.casestudy.repository;

import com.example.casestudy.entity.BookTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTrackRepository extends JpaRepository<BookTrack, Long> {
}
