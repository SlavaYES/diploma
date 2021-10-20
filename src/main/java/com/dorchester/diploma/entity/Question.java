package com.dorchester.diploma.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column
    @Setter
    @Getter
    private String title;

    @Column
    @Setter
    @Getter
    private Integer test_id;

    @Column
    @Setter
    @Getter
    private String answer;

    @Column
    @Setter
    @Getter
    private String filename;

    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Answer> answers;
}
