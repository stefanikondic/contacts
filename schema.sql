
    create table contact (
       id bigint not null,
        email varchar(255),
        name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=MyISAM;

    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM;

    insert into hibernate_sequence values ( 1 );
