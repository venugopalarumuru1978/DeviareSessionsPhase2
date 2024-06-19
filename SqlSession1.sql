-- How to create database
-- create database <dbname>

create database  deviaredb4;

-- how to change from one db to another db
-- use <dbname>

use deviaredb4;

-- How to create a table
/*
	Create  table  <table_name>(
    colname  <data type>  [constraint], 
    colname  <data type>  [constraint], 
    ......);
    
    data types
    ------------
    int = integer
    decimal = float
    string = varchar
    date value = date
*/

create table student(
rollno  int  primary key, 
stdname varchar(30), 
course  varchar(10),
fees  float);

create table employee(
empno int primary key, empname varchar(30),
gender  char(1), job  varchar(20),
salary int, joindate  date, 
location varchar(10));

create table  personInfo(
personId int primary key, 
personName  varchar(20),
emailId  varchar(100));

-- How to add rows into table
/*
	Insert  into <table name>(col-1, col-2, ....)
    values(val1, val2, ...);
    
    Note :-  string and date values has to 
    enclose in single quotes
*/

insert into student(rollno, stdname, course, fees)
values(1002, 'Sravan Kumar', 'Java', 20000.00);

-- add multiple rows

insert into student(rollno, stdname, course, fees)
values(1003, 'Murali Kumar', 'Java', 20000.00),
(1004, 'Lavanya', 'Java', 20000.00),
(1005, 'Sahasra', 'Java', 20000.00);

--  how to retrive rows from table. 
/* 
select  <expression>  from <table name>
[where clause]  
[group by clause]
[having clause]
[order by clause]
*/
--  *  represents all columns
select * from student;
select * from employee;
select * from personinfo;


