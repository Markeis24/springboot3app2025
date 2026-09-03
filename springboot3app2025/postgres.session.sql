create table usr_usuario (
    usr_id bigint generated always as identity,
    usr_nome varchar(100) not null,
    usr_senha varchar(255) not null,
    primary key (usr_id),
    constraint usr_nome_uk unique (usr_nome)
);

create table aut_autorizacao (
    aut_id bigint generated always as identity,
    aut_nome varchar(50) not null,
    primary key (aut_id),
    constraint aut_nome_uk unique (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint,
    aut_id bigint,
    primary key (usr_id, aut_id),
    constraint uau_usr_fk
        foreign key (usr_id) references usr_usuario(usr_id),
    constraint uau_aut_fk
        foreign key (aut_id) references aut_autorizacao(aut_id)
);

insert into aut_autorizacao(aut_nome) values ('ADMIN'), ('USER');