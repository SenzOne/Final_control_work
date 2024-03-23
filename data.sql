# create database Human_Friends;
# use Human_Friends;

drop table if exists Pets;
create table Pets
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);

drop table if exists Pack_animals;
create table Pack_animals
(
    id        int auto_increment primary key,
    type      varchar(50),
    name      varchar(50) not null,
    birthDate date        not null,
    commands  varchar(100)
);


insert into Pets (type, name, birthDate, commands)
values ('Fido', 'Dog', '2020-01-01', 'Sit stay fetch'),
       ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
       ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
       ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
       ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
       ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
       ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
       ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

insert into Pack_animals (type, name, birthDate, commands)
values  ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
        ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
        ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
        ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
        ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
        ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
        ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
        ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');

