package com.github.joeri5.mindify.note;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.joeri5.mindify.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @JsonIgnoreProperties({
            "password",
            "locked",
            "enabled",
            "accountNonExpired",
            "accountNonLocked",
            "credentialsNonExpired",
            "username",
            "authorities",
            "role",
            "confirmationToken",
            "verified"
    })
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
