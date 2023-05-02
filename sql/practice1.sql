SHOW DATABASES;
USE courseservice;
show tables;


INSERT INTO Course (idCourseCode, name, credit)
VALUES
('biol_01', 'Biology 1', 8),
('phys_01','Physics 1', 8),
('art_01','Arts 1', 5),
('chem_01','Chemistry 1', 5),
('sport_01','Sport 1', 3);
select * from course;

INSERT INTO Country (idCountry, name, countryCode)
VALUES
(1, 'Singapore', 'SG'),
(2, 'Malaysia', 'MY'),
(3, 'Vietnam', 'VN'),
(4, 'Philippines', 'PH'),
(5, 'Thailand', 'TH'),
(6, 'Cambodia', 'KM');
select * from country;

-- import Module using csv or json AFTER inserting Course and Country due to PK and FK
SELECT * FROM module;

-- rename table
RENAME TABLE Module TO ModuleInfo;
RENAME TABLE ModuleInfo TO Module;

INSERT INTO Student(idStudent,firstName,lastName,email,address,birthDate,nationality)
VALUES
('1001','Jenny','Lim','jenny@email.com','Ang Mo Kio','1990-01-01',1),
('1002','Andy','Lau','andy@email.com','some address','1990-01-01',1),
('1003','Jacky','Chang','jacky@email.com','some address','1990-01-01',1),
('1004','Leon','Lai','leon@email.com','some address','1990-01-01',2),
('1005','Aaron','Kwok','aaron@email.com','some address','1990-01-01',2),
('1006','Annie','Lim','annie@email.com','some address','1990-01-01',2),
('1007','Joan','Lim','joan@email.com','some address','1990-01-01',3),
('1008','Faith','Yeo','faith@email.com','some address','1990-01-01',3),
('1009','Sue','Tan','sue@email.com','some address','1990-01-01',4),
('1010','Joe','Lau','joe@email.com','some address','1990-01-01',4),
('1011','Jimmy','Lee','jimmy@email.com','some address','1990-01-01',4),
('1012','Wendy','Ting','wendy@email.com','some address','1990-01-01',5),
('1013','Jo','Kwok','jo@email.com','some address','1990-01-01',5),
('1014','Kim','Lee','kim@email.com','some address','1990-01-01',6),
('1015','Tanny','Lau','tanny@email.com','some address','1990-01-01',6),
('1016','Ann','Lim','ann@email.com','Ang Mo Kio','1990-01-01',1),
('1017','Ben','Lau','ben@email.com','some address','1990-01-01',1),
('1018','Cat','Chang','cat@email.com','some address','1990-01-01',1),
('1019','Dawn','Lai','dawn@email.com','some address','1990-01-01',2),
('1020','Esther','Kwok','esther@email.com','some address','1990-01-01',2),
('1021','Ivy','Lim','Ivy@email.com','some address','1990-01-01',2),
('1022','June','Lim','june@email.com','some address','1990-01-01',3),
('1023','Ken','Yeo','ken@email.com','some address','1990-01-01',3),
('1024','Linn','Tan','linn@email.com','some address','1990-01-01',4),
('1025','Mandy','Lau','Mandy@email.com','some address','1990-01-01',4),
('1026','Peggy','Lee','peggy@email.com','some address','1990-01-01',4),
('1027','Rick','Ting','rick@email.com','some address','1990-01-01',5),
('1028','Sunny','Kwok','Sunny@email.com','some address','1990-01-01',5),
('1029','Donny','Lee','donny@email.com','some address','1990-01-01',6),
('1030','Cindy','Lau','cindy@email.com','some address','1990-01-01',6);

SELECT * FROM student;

INSERT INTO Course_Student(idCourseCode, idStudent)
VALUES
('biol_01', '1001'),
('biol_01', '1002'),
('biol_01', '1003'),
('biol_01', '1004'),
('biol_01', '1005'),
('biol_01', '1006'),
('biol_01', '1007'),
('biol_01', '1008'),
('phys_01', '1006'),
('phys_01', '1007'),
('phys_01', '1008'),
('phys_01', '1009'),
('phys_01', '1010'),
('phys_01', '1011'),
('phys_01', '1012'),
('phys_01', '1013'),
('phys_01', '1014'),
('art_01', '1001'),
('art_01', '1002'),
('art_01', '1003'),
('art_01', '1004'),
('art_01', '1005'),
('chem_01', '1015'),
('chem_01', '1016'),
('chem_01', '1017'),
('chem_01', '1018'),
('chem_01', '1019'),
('chem_01', '1020'),
('chem_01', '1021'),
('chem_01', '1022'),
('sport_01', '1023'),
('sport_01', '1024'),
('sport_01', '1025'),
('sport_01', '1026'),
('sport_01', '1027'),
('sport_01', '1028'),
('sport_01', '1029'),
('sport_01', '1030');

select * from course_student;
SELECT * FROM Course_Student;
Select * from Course;
SELECT * FROM Module;

SELECT DISTINCT nationality FROM student;

-- Student (comma) Country is joining the 2 tables (INNER JOIN)
SELECT * 
FROM Student, Country
WHERE nationality = idCountry;

-- Same as above
SELECT * 
FROM Student INNER JOIN Country
WHERE nationality = idCountry;

-- Students from either Singapore or Malaysia
SELECT Student.firstName, Student.lastname, Country.name
FROM Student, Country
WHERE Student.nationality = Country.idCountry
AND Country.name = 'Singapore'
OR Country.name = 'Malaysia'
ORDER BY 3;

-- UPDATE
UPDATE Student 
SET email = "andylau@gmail.com", address = "Ang Mo Kio Ave 2"
WHERE idStudent = "1002";

-- DELETE "Jenny Lim"
DELETE FROM Course_Student 
WHERE idStudent = "1001";

-- COUNT no. of students from singapore and malaysia
SELECT COUNT(idStudent), Country.name
FROM Student, Country
WHERE Student.nationality = Country.idCountry
AND Country.idCountry IN (1, 2)
group by Country.name;

SELECT SUM(credit) AS "Total Credit for Art"
FROM Course
INNER JOIN Module
ON Course.idCourseCode = Module.idCourseCode
AND Course.idCourseCode = "art_01";

SELECT * FROM Student
WHERE firstName LIKE '_en%';

SELECT * FROM Course
WHERE credit = (SELECT MAX(credit) FROM Course);


SELECT MAX(credit)
FROM Course;

SELECT * FROM Student;

-- Q1 show the Students’ first name, email, and the name of their nationality in text from the result output
SELECT Student.firstName, Student.email, Country.name
FROM Student, Country
WHERE Student.nationality = Country.idCountry;

-- Q2 exclude Singapore
SELECT Student.firstName, Student.email, Country.name
FROM Student, Country
WHERE Student.nationality = Country.idCountry
AND Country.idCountry != 1;

-- Q3 show all the Course name and the Student first name and last name that is enrolled in the course.
SELECT Course.name, Student.firstName, Student.lastName
FROM Course, Student, Course_Student
WHERE Course.idCourseCode = Course_Student.idCourseCode
AND Course_Student.idStudent = Student.idStudent;

-- Q4 show the student’s name with course name = Arts 01
SELECT Course.name, Student.firstName, Student.lastName
FROM Course, Student, Course_Student
WHERE Course.idCourseCode = Course_Student.idCourseCode
AND Course_Student.idStudent = Student.idStudent
AND Course.idCourseCode = 'art_01';

-- Q5 all the modules that Andy Lau is taking in the result.
SELECT Module.name, Student.firstName, Student.lastName
FROM Module, Student, Course_Student
WHERE Student.firstName = 'Andy' AND Student.lastName = 'Lau'
AND Module.idCourseCode = Course_Student.idCourseCode
AND Course_Student.idStudent = Student.idStudent;

-- all the modules that Andy Lau is taking and their respective credits
SELECT Module.name, Student.firstName, Student.lastName, Course.credit
FROM Module, Student, Course_Student, Course
WHERE Student.firstName = 'Andy' AND Student.lastName = 'Lau'
AND Module.idCourseCode = Course_Student.idCourseCode
AND Course.idCourseCode = Module.idCourseCode
AND Course_Student.idStudent = Student.idStudent;

-- Q6 show total credit that Andy Lau is taking
SELECT Student.firstName, SUM(Course.credit) AS Credit
FROM Module, Student, Course_Student, Course
WHERE Student.firstName = 'Andy' AND Student.lastName = 'Lau'
AND Module.idCourseCode = Course_Student.idCourseCode
AND Course.idCourseCode = Module.idCourseCode
AND Course_Student.idStudent = Student.idStudent;

-- Q7 show the total credit for all the students in descending order.
SELECT Student.firstName, SUM(Course.credit) AS Credit
FROM Module, Student, Course_Student, Course
WHERE Module.idCourseCode = Course_Student.idCourseCode
AND Course.idCourseCode = Module.idCourseCode
AND Course_Student.idStudent = Student.idStudent
GROUP BY Student.firstName
ORDER BY 2 DESC;

-- Q8 List of Countries with the total number of students.
SELECT Country.name AS Country, COUNT(Country.name) AS "Number of Students"
FROM Student, Country
WHERE Student.nationality = Country.idCountry
GROUP BY name
ORDER BY 1;

-- Q9 List of Countries with the total number of students greater than 5
SELECT Country.name AS Country, COUNT(Country.name) AS "Number of Students"
FROM Student, Country
WHERE Student.nationality = Country.idCountry
GROUP BY name
HAVING COUNT(Country.name) > 5
ORDER BY 1;

-- Q10 show the Course name & credit, Module name, Student first name & last name
SELECT Course.name AS "Course", Course.credit, Module.name AS "Module", Student.firstName, Student.lastName
FROM Module, Student, Course_Student, Course
WHERE Module.idCourseCode = Course_Student.idCourseCode
AND Course_Student.idStudent = Student.idStudent
AND Course.idCourseCode = Module.idCourseCode;

-- Q11 show the Course name & credit, total number of students’ enrolment
-- multiple JOINs in 'WHERE' from Course_Student, get the Student id and Course id
-- use Course id to get back all the modules belonging to each Course id
-- use Student id to get back all the students
-- the 'WHERE' will return the modules for each student 
SELECT Course.name AS "Course", Course.credit, COUNT(Course.name) AS "Number of Enrollment"
FROM Module, Course, Student, Course_Student
WHERE Module.idCourseCode = Course.idCourseCode
AND Module.idCourseCode = Course_Student.idCourseCode
AND Course_Student.idStudent = Student.idStudent
GROUP BY 1, 2;

-- Q11 Alternative
SELECT name, credit, COUNT(name)
FROM 
	(SELECT Course.name AS "name", Course.credit AS "credit"
		FROM Module, Student, Course_Student, Course
		WHERE Module.idCourseCode = Course_Student.idCourseCode
		AND Course_Student.idStudent = Student.idStudent
		AND Course.idCourseCode = Module.idCourseCode) AS everything
GROUP BY 1, 2;

-- Q11 Alternative using JOINs
SELECT c.name, c.credit, COUNT(c.name)
FROM 
	(SELECT * FROM Course) AS c
    
    RIGHT OUTER JOIN
    (SELECT * FROM Course_Student) AS cs
    ON cs.idCourseCode = c.idCourseCode
    
    RIGHT OUTER JOIN
    (SELECT idStudent FROM Student) AS s
    ON cs.idStudent = s.idStudent
    
    LEFT OUTER JOIN
    (SELECT * FROM Module) AS m
    ON m.idCourseCode = c.idCourseCode
GROUP BY 1, 2;

-- Modules, Courses and credits
SELECT 
Module.idCourseCode, 
Course.name, Module.name,
Course.credit
FROM Module, Course
WHERE Module.idCourseCode = Course.idCourseCode;
