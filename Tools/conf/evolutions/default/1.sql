# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table genre (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_genre primary key (id))
;

create table tool (
  id                        bigint not null,
  title                     varchar(255),
  summary                   varchar(255),
  url                       varchar(255),
  genre_id                  bigint,
  constraint pk_tool primary key (id))
;

create table users (
  id                        bigint not null,
  username                  varchar(255),
  password_hash             varchar(255),
  constraint pk_users primary key (id))
;

create sequence genre_seq;

create sequence tool_seq;

create sequence users_seq;

alter table tool add constraint fk_tool_genre_1 foreign key (genre_id) references genre (id) on delete restrict on update restrict;
create index ix_tool_genre_1 on tool (genre_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists genre;

drop table if exists tool;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists genre_seq;

drop sequence if exists tool_seq;

drop sequence if exists users_seq;

