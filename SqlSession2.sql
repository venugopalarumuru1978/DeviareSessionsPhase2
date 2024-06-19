select * from student;
/* 
select  <expression>  from <table name>
[where clause]    - to specify condition to retrive specific rows
[group by clause]
[having clause]
[order by clause]
*/

-- Query :-  Show the student information based on rollno.
select * from student where rollno=1002;

--  Query :- Show all students who having "Java" Course
select * from student where course='java';

--  Query :- Show all students who having "Python" Course
select * from student where course='python';

-- How to delete rows from table
-- Delete  from  <table name> [where clause]

delete from student; --  it will delete all the rows
delete from  student where rollno=1003;
delete from student where course='java';

-- How to modify existing row values
-- update <tablename>  set <colname>=<value> [where clause]

update student set  stdname='Geeta Sai Sahasra' where rollno=1005;
update student set fees=30000.00 where rollno=1004;

/* 
Commit, Rollback
These two commands are used perform some operation on following
commands : Insert / Update / Delete (DML - (Data Manipulation Lang) Operations)

commit :-  this command is used to make dml operations permentently in db table.
rollback :-  this command is used to cancel dml operation from db table.
 
*/

set autocommit = 0;   -- this command allows stop auto commit 
set autocommit = 1;    -- this command allows start auto commit

select * from student;

delete from student where rollno=1009;
rollback;

commit;

update student set stdname='Kiran Kumar' where rollno=1004;
rollback;

Insert into student(rollno, stdname, course, fees)
values(1234, 'Baskar', 'java', 12000.00);
rollback;