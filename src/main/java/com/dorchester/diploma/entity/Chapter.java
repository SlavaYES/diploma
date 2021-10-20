package com.dorchester.diploma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chapter {
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
    private String description;

    @OneToMany
    @JoinColumn(name = "chapter_id")
    @Setter
    @Getter
    private List<Item> items;

    @Column
    @Setter
    @Getter
    private Integer theme_id;
}
