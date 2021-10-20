package com.dorchester.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    @Column
    @Getter
    @Setter
    private String text;

    @Length(max = 255, message = "Message too long (more than 255)")
    @Column
    @Getter
    @Setter
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User author;

    @Column
    @Setter
    @Getter
    private String filename;

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }
}
