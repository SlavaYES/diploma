create table answer
(
    id              integer not null,
    text            varchar(255),
    question_id     integer,
    primary key (id)
) engine=InnoDB;

create table question
(
    id              integer not null,
    title           varchar(2048) not null,
    test_id         integer,
    answer          varchar(255) not null,
    filename        varchar(255),
    primary key (id)
) engine=InnoDB;

create table test
(
    id              integer not null,
    title           varchar(255),
    description     varchar(255),
    percent         integer,
    theme_id        integer,
    primary key (id)
) engine=InnoDB;

create table list_item
(
    id              integer not null,
    title           varchar(2048),
    item_chapter_id integer,
    primary key (id)
) engine=InnoDB;

create table item_chapter
(
    id              integer not null,
    title           varchar(255),
    text            varchar(2048),
    filename        varchar(255),
    chapter_id      integer,
    primary key (id)
) engine=InnoDB;

create table chapter
(
    id              integer not null,
    title           varchar(255),
    description     varchar(255),
    theme_id        integer,
    primary key (id)
) engine=InnoDB;

create table theme
(
    id              integer not null,
    title           varchar(255),
    description     varchar(255),
    active          bit,
    progress        integer,
    access          bit,
    primary key (id)
) engine=InnoDB;

alter table list_item
    add constraint list_item_fk
        foreign key (item_chapter_id) references item_chapter (id);

alter table item_chapter
    add constraint item_chapter_theme_fk
        foreign key (chapter_id) references chapter (id);

alter table chapter
    add constraint
        foreign key (theme_id) references theme (id);

alter table answer
    add constraint answer_question
        foreign key (question_id) references question (id);

alter table question
    add constraint test_question_fk
        foreign key (test_id) references test (id);

alter table test
    add constraint test_theme_fk
        foreign key (theme_id) references theme (id);
