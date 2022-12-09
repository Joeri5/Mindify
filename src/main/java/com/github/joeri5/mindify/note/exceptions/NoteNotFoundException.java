package com.github.joeri5.mindify.note.exceptions;

import org.springframework.web.client.RestClientException;

public class NoteNotFoundException extends RestClientException {

    public NoteNotFoundException(Long id) {
        super("Job with id:" + id + "was not found");
    }
}
