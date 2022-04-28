package com.foxal.springsecurityapp.authwebapp.controllers;

import com.foxal.springsecurityapp.authwebapp.models.Note;
import com.foxal.springsecurityapp.authwebapp.models.User;
import com.foxal.springsecurityapp.authwebapp.repositories.NoteRepository;
import com.foxal.springsecurityapp.authwebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/notes")
    public String notes(Model model, Authentication authentication) {
        List<Note> notesList = noteRepository.findByUserId(userRepository.findByUsername(authentication.getName()).getId());
        model.addAttribute("notesList", notesList);

        return "notes";
    }

    @GetMapping("/add_new_note")
    public String showNoteAddForm(Model model) {
        model.addAttribute("note", new Note());

        return "new_note";
    }

    @PostMapping("/save_note")
    public String addNote(String title, String note, Authentication authentication) {
        Note tmpNote = new Note();

        tmpNote.setTitle(title);
        tmpNote.setNote(note);
        tmpNote.setUserId(userRepository.findByUsername(authentication.getName()).getId());

        noteRepository.save(tmpNote);

        return "redirect:/notes";
    }
}

