--access h2 db @ localhost:8080/h2-console
--create table customer (id integer not null, birth_date timestamp(6), name varchar(255), pass varchar(255), primary key (id))
insert into customer values(1,CURRENT_TIMESTAMP(),'HarishT','passHT');
insert into customer values(2,CURRENT_TIMESTAMP(), 'YogeshT','passYT');
insert into customer values(3,CURRENT_TIMESTAMP(), 'RishT','passRT');