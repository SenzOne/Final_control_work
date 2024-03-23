# create database Human_Friends;
# use Human_Friends;

drop table if exists cats;
create table cats
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);


drop table if exists dogs;
create table dogs
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);


drop table if exists hamsters;
create table hamsters
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);


drop table if exists horses;
create table horses
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);


drop table if exists camels;
create table camels
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);

drop table if exists donkeys;
create table donkeys
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);

insert into cats (type, name, birthDate, commands)
values ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
       ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
       ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

insert into dogs (type, name, birthDate, commands)
values ('Fido', 'Dog', '2020-01-01', 'Sit stay fetch'),
       ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
       ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll');

insert into hamsters (name, type, birthDate, commands)
values
    ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
    ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin');

insert into horses (type, name, birthDate, commands)
values ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
       ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
       ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop');

insert into camels (type, name, birthDate, commands)
values ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
       ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
       ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');

insert into donkeys (type, name, birthDate, commands)
values ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
       ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick');


