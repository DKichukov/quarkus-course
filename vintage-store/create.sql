
    create sequence t_artists_SEQ start with 1 increment by 50;

    create sequence t_items_SEQ start with 1 increment by 50;

    create sequence t_publishers_SEQ start with 1 increment by 50;

    create sequence t_purchase_order_line_SEQ start with 1 increment by 50;

    create sequence t_purchase_orders_SEQ start with 1 increment by 50;

    create sequence t_tracks_SEQ start with 1 increment by 50;

    create table Book (
        bn_of_pages integer,
        publication_date date,
        id bigint not null,
        publisher_fk bigint,
        isbn varchar(15),
        language varchar(255) check (language in ('ENGLISH','FRENCH','SPANISH','PORTUGUESE')),
        primary key (id)
    );

    create table CD (
        id bigint not null,
        genre varchar(100),
        music_company varchar(255),
        primary key (id)
    );

    create table Customer (
        created_date timestamp(6) with time zone not null,
        id bigserial not null,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(255) not null,
        primary key (id)
    );

    create table t_artists (
        created_date timestamp(6) with time zone not null,
        id bigint not null,
        name varchar(100) not null,
        bio varchar(3000),
        primary key (id)
    );

    create table t_items (
        price numeric(38,2) not null,
        artist_fk bigint,
        created_date timestamp(6) with time zone not null,
        id bigint not null,
        title varchar(100) not null,
        description varchar(300) not null,
        primary key (id)
    );

    create table t_publishers (
        created_date timestamp(6) with time zone not null,
        id bigint not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table t_purchase_order_line (
        quantity integer not null,
        created_date timestamp(6) with time zone not null,
        id bigint not null,
        item_fk bigint,
        purchase_order_fk bigint,
        primary key (id)
    );

    create table t_purchase_orders (
        purchase_order_date date,
        created_date timestamp(6) with time zone not null,
        customer_fk bigint,
        id bigint not null,
        primary key (id)
    );

    create table t_tracks (
        duration numeric(21,0) not null,
        cd_fk bigint,
        created_date timestamp(6) with time zone not null,
        id bigint not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists Book 
       add constraint FKl8lxbjh0wptss27owag6it4i7 
       foreign key (publisher_fk) 
       references t_publishers;

    alter table if exists Book 
       add constraint FKrc4aujt4u7vihi7kovrbbtxsv 
       foreign key (id) 
       references t_items;

    alter table if exists CD 
       add constraint FKaytv0uvt7n00ea6i2dnw4o78v 
       foreign key (id) 
       references t_items;

    alter table if exists t_items 
       add constraint FKr3152tukbog585dik5qwonldg 
       foreign key (artist_fk) 
       references t_artists;

    alter table if exists t_purchase_order_line 
       add constraint FKk5o0lynwj3vddwn397a24kwqj 
       foreign key (item_fk) 
       references t_items;

    alter table if exists t_purchase_order_line 
       add constraint FKffbfk27356l55yt28wd7w8mwp 
       foreign key (purchase_order_fk) 
       references t_purchase_orders;

    alter table if exists t_purchase_orders 
       add constraint FKpv85fajcr276h57r73xblo9ys 
       foreign key (customer_fk) 
       references Customer;

    alter table if exists t_tracks 
       add constraint FKd2cxlowirxhlmf3s87rc8jcvf 
       foreign key (cd_fk) 
       references CD;
