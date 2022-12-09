package com.github.joeri5.mindify.note;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note, Authentication authentication) {
        return noteService.createNote(note, authentication);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') || @noteService.isNoteOwner(#id, authentication)")
    public Note getNote(@PathVariable Long id) {
        return noteService.readNote(id);
    }

}
