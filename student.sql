create database backend6_7;

use backend6_7;

create table student(
	id int primary key auto_increment, 
	name varchar(100) not null, 
	age int, 
	course varchar(100) not null
);
