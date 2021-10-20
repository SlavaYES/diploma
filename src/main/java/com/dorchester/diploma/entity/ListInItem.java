package com.dorchester.diploma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "list_item")
public class ListInItem {
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
    private Integer item_chapter_id;
}
