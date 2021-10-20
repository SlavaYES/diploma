package com.dorchester.diploma.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
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
    private Integer percent;

    @Column
    @Setter
    @Getter
    private Integer theme_id;

    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "test_id")
    private List<Question> questions;

    public Test(String title) {
        this.title = title;
    }
}
