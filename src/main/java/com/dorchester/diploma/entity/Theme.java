package com.dorchester.diploma.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
public class Theme {
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

    @Column
    @Setter
    @Getter
    private boolean active;

    @Column
    @Setter
    @Getter
    private Integer progress;

    @Column
    @Setter
    @Getter
    private boolean access;

    @OneToMany
    @JoinColumn(name = "theme_id")
    @Setter
    @Getter
    private List<Chapter> chapters;

    @OneToMany
    @JoinColumn(name = "theme_id")
    @Setter
    @Getter
    private List<Test> tests;
}
