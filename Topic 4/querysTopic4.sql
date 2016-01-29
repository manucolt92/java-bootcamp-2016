#practice 1
create database highschool;

use highschool;

create table student (student_id int not null auto_increment,
student_firstname varchar(40) not null,
student_lastname varchar(40) not null,
student_dateofbirth date not null,
primary key (student_id));

create table teacher (teacher_id int not null auto_increment,
teacher_firstname varchar(40) not null,
teacher_lastname varchar (40) not null,
teacher_dateofbirth date not null,
primary key (teacher_id));

create table course (course_id int not null auto_increment,
course_name varchar (40) not null,
course_assignedteacher int not null,
course_hoursbyweek int not null,
primary key (course_id),
foreign key (course_assignedteacher) references teacher (teacher_id));

create table schedulecourse (schedulecourse_id int not null,
schedulecourse_day varchar(40) not null,
schedulecourse_starts time not null,
schedulecourse_ends time not null,
foreign key (schedulecourse_id) references course(course_id));

create table notes (notesstudent_id int not null,
notesstudent_course int not null,
notesstudent_firstnote int not null,
notesstudent_secondnote int not null,
notesstudent_thirdnote int not null,
notesstudent_finalnote real not null,
foreign key (notesstudent_id) references student(student_id),
foreign key (notesstudent_course) references course (course_id));

#practice 2

insert into teacher values (default, 'Juan', 'Aguirre', '1885-02-25'),
(default, 'Monica', 'Garrido', '1854-07-31'),
(default, 'Alberto', 'Einstein', '1880-02-21');

insert into course values (default, 'Math', 1, 8),
(default, 'History', 2, 6),
(default, 'Geography', 3, 6);

insert into student values	(default,'Carlos','Primero','1993-01-04'),
(default,'Carlos','Segundo','1993-02-04'),
(default,'Carlos','Tercero','1993-03-04'),
(default,'Carlos','Cuarto','1993-04-04'),
(default,'Carlos','Quinto','1993-05-04'),
(default,'Carlos','Sexto','1993-06-04'),
(default,'Carlos','Septimo','1993-07-04'),
(default,'Carlos','Octavo','1993-08-04'),
(default,'Carlos','Noveno','1993-09-04'),
(default,'Carlos','Decimo','1993-10-04'),
(default,'Juan','Primero','1993-01-04'),
(default,'Juan','Segundo','1993-02-04'),
(default,'Juan','Tercero','1993-03-04'),
(default,'Juan','Cuarto','1993-04-04'),
(default,'Juan','Quinto','1993-05-04'),
(default,'Juan','Sexto','1993-06-04'),
(default,'Juan','Septimo','1993-07-04'),
(default,'Juan','Octavo','1993-08-04'),
(default,'Juans','Noveno','1993-09-04'),
(default,'Juan','Decimo','1993-10-04'),
(default,'Pio','Primero','1993-01-04'),
(default,'Pio','Segundo','1993-02-04'),
(default,'Pio','Tercero','1993-03-04'),
(default,'Pio','Cuarto','1993-04-04'),
(default,'Pio','Quinto','1993-05-04'),
(default,'Pio','Sexto','1993-06-04'),
(default,'Pio','Septimo','1993-07-04'),
(default,'Pio','Octavo','1993-08-04'),
(default,'Pio','Noveno','1993-09-04'),
(default,'Pio','Decimo','1993-10-04');

insert into notes values
(1,1,3,7,3,4.33),
(2,1,8,9,9,8.33),
(3,1,1,10,7,6.0),
(4,1,5,6,7,6.0),
(5,1,6,7,8,7.0),
(6,1,5,9,9,7.66),
(7,1,7,7,7,7.0),
(8,1,8,8,8,8.0),
(9,1,9,9,9,9.0),
(10,1,10,10,10,10.0),
(11,2,4,5,3,4.0),
(12,2,7,5,9,7.0),
(13,2,5,5,1,3.66),
(14,2,9,8,7,8.0),
(15,2,6,5,4,5.0),
(16,2,9,1,9,6.33),
(17,2,7,7,7,7.0),
(18,2,6,6,6,6.0),
(19,2,9,2,2,4.33),
(20,2,4,4,3,3.66),
(21,3,5,6,7,6.0),
(22,3,3,1,1,1.66),
(23,3,9,8,7,8.0),
(24,3,7,8,9,8.0),
(25,3,9,8,8,8.33),
(26,3,1,9,9,6.33),
(27,3,10,6,8,8.0),
(28,3,9,2,10,7.0),
(29,3,8,4,4,5.33),
(30,3,3,7,7,5.66);

insert into schedulecourse values
(1,'Monday','09:00:00','13:00:00'),
(1,'Wednesday','09:00:00','13:00:00'),
(2,'Tuesday','09:00:00','13:00:00'),
(2,'Thursday','09:00:00','11:00:00'),
(3,'Thursday','11:00:00','13:00:00'),
(3,'Friday','09:00:00','13:00:00');

#practice 3

select course_name,
	   teacher_lastname, teacher_firstname,
	   student_lastname, student_firstname
from course
join notes on notesstudent_course=course_id
join student on student_id=notesstudent_id
join teacher on teacher_id=course_assignedteacher
where course_name='History'
order by student_lastname;

#practice 4

select (select count(*) from notes
		join course on course_id=notesstudent_course 
		where course_id=2 and notesstudent_finalnote<4) /
		(select count(*) from notes
		join course on course_id=notesstudent_course
		where course_id=2) * 100
as PercentageOfStudentsFailed;

#practice 5

select teacher_lastname, teacher_firstname,
	   schedulecourse_day, schedulecourse_starts, schedulecourse_ends,
       course_name
from teacher
join course on course_assignedteacher=teacher_id
join schedulecourse on schedulecourse_id=course_id
where teacher_id=1
order by schedulecourse_day;

    








