--access h2 db @ localhost:8080/h2-console

--Customer table
--Schema
--create table customer (id integer not null, birth_date timestamp(6), name varchar(255), pass varchar(255), primary key (id))
insert into customer values(1001,CURRENT_TIMESTAMP(),'HarishT','passHT');
insert into customer values(1002,CURRENT_TIMESTAMP(), 'YogeshT','passYT');
insert into customer values(1003,CURRENT_TIMESTAMP(), 'RishT','passRT');


--Customer order table
--Schema
--create table cus_order (customer_id integer, id integer not null, item_description varchar(255), primary key (id))
insert into customer_order values(1001,1101,'Grooming items');
insert into customer_order values(1003,1102,'Kitchen items');
insert into customer_order values(1001,1103,'Automobile spare parts');
insert into customer_order values(1003,1104,'Electronic items');