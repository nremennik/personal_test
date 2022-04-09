SELECT table_schema,table_name FROM information_schema.tables
ORDER BY table_schema,table_name;

select * from information_schema.tables where table_name = 'tables';
SELECT datname FROM pg_database WHERE datistemplate = false;
select * from pg_database where datname= 'opinions';
SELECT * FROM information_schema.tables WHERE table_schema = 'opinions';
create table question_answer
(
    id          serial PRIMARY KEY,
    question      varchar not null,
    answer  varchar,
    views   numeric not null DEFAULT 0
);
drop table question_answer;

create table user_role
(
    id          integer,
    role      varchar not null,
    constraint role_pk primary key (id,role),
    constraint role_fk foreign key (id) references users(id)

);
commit;
-- ROLE_USER
-- ROLE_ADMIN
select * from users;
select * from user_role;
select * from information_schema.tables;

drop table users;
delete from users where current_user='web';

create table users(
                            id          SERIAL primary key,
                            login       varchar(50) not null unique,
                            password    varchar(50) not null,
                            email       varchar(50),
                            telephone    varchar(10))
;

drop table users;
commit;
insert into users(login, password,email,telephone)
values ('Test1','pass1','email1','telephone1');
insert into users(login, password,email,telephone)
values ('Test2','pass2','email2','telephone2');
insert into users(login, password,email,telephone)
values ('Test3','pass3','email3','telephone3');
alter table users drop column password;
alter table users drop column email;

select * from users;
insert into users(login,telephone)
values ('Test1','telephone1');
insert into users(login, telephone)
values ('Test2','telephone2');
insert into users(login, telephone)
values ('Test3','telephone3');


insert into user_role(id,role)
values (1,'ROLE_USER');
insert into user_role(id,role)
values (1,'ROLE_ADMIN');
drop table question_answer;
delete from user_role
where id=1;
delete from users
where id<4;


select *
from question_answer;

delete  from user_role
where id=1;
select * from users;
alter table users
ADD COLUMN role VARCHAR;
commit;
ALTER TABLE users
    DROP COLUMN role;
update users set role = 'ADMIN'
where id=1;
update users set role = 'USER'
where id=3;
commit;
insert into question_answer(question, answer)
values ('How add Default Values?','In a table definition, default values are listed after the column data type. For example: price numeric DEFAULT 9.99');