package com.dorchester.diploma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_chapter")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column
    @Setter
    @Getter
    private String title;

    @OneToMany
    @JoinColumn(name = "item_chapter_id")
    @Setter
    @Getter
    private List<ListInItem> listsInItem;

    @Column
    @Setter
    @Getter
    private Integer chapter_id;
}
