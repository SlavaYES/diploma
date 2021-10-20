package com.dorchester.diploma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column
    @Setter
    @Getter
    private String text;

    @Column
    @Setter
    @Getter
    private Integer question_id;
}
