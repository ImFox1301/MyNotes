package com.foxal.springsecurityapp.authwebapp.repositories;

import com.foxal.springsecurityapp.authwebapp.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
    Note findNoteById(Long id);
}
