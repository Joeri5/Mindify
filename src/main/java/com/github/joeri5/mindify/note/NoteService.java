package com.github.joeri5.mindify.note;

import com.github.joeri5.mindify.note.exceptions.NoteNotFoundException;
import com.github.joeri5.mindify.user.User;
import com.github.joeri5.mindify.user.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class NoteService {

    private final UserService userService;

    private final NoteRepository noteRepository;

    public Note createNote(Note note, Authentication authentication) {
        User author = userService.extractFromAuthentication(authentication);
        note.setAuthor(author);

        return noteRepository.save(note);
    }

    public Note readNote(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public boolean isNoteOwner(Long id, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (!(principal instanceof User user)) {
            return false;
        }

        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return note.getAuthor().getEmail().equals(user.getUsername());
    }

}
