CREATE SCHEMA IF NOT EXISTS `sqlassessment` DEFAULT CHARACTER SET utf8 ;
USE `sqlassessment` ;

show tables;
select * from progress;
select * from users;

-- Q1 a
-- Top 25 schools with the most number of students in descending order on .edu domains
SELECT email_domain, COUNT(user_id) AS num_students
FROM users
GROUP BY 1
ORDER BY 2 DESC
LIMIT 25;

-- Q1 b 
-- all the cities with the number of students from the respective cities in descending order of the number of students
SELECT city, COUNT(user_id) AS students
FROM users
GROUP BY 1
ORDER BY 2 DESC
LIMIT 25;

-- Q1 c students in NY
SELECT city, COUNT(user_id) AS students
FROM users
WHERE city = "New York"
GROUP BY 1;

-- Q1 d
-- mobile_app column contains either mobile-user or empty. 
-- How many of these students are using the mobile app and how many are not
-- get total number of students first
SELECT COUNT(user_id) FROM users;

SELECT mobile_app, 
		ROUND(COUNT(user_id) / (SELECT COUNT(user_id) FROM users) * 100, 2) AS "%"
FROM users
GROUP BY 1;

-- Q1 e
-- How many students have completed sql from ALL Schools
SELECT COUNT(user_id) AS "students completed sql"
FROM progress
WHERE learn_sql = "completed";

-- Q1 f
-- List out all students’ details with the sign up date from 1st of March 2017 to 15th April 2017.
-- modify 'sign_up_at' column to DATETIME format first
ALTER TABLE users 
MODIFY sign_up_at DATETIME;

-- query based on required conditions
SELECT * 
FROM users
WHERE sign_up_at > '2017-03-01'
AND sign_up_at < '2017-04-15';

-- Q2 a
-- What courses are the New Yorkers students taking and have taken (both started and completed)? 
-- (List according to ascending order of email_domain)
SELECT users.email_domain, 
		users.country, 
        users.city, 
        progress.learn_cpp, 
        progress.learn_sql, 
        progress.learn_html,
        progress.learn_javascript,
        progress.learn_java
FROM users, progress
WHERE users.user_id = progress.user_id
AND users.city = "New York"
ORDER BY 1
LIMIT 25;

-- Q2 b
-- details of the students completed sql and java from their respective Schools (.edu domains)
SELECT users.email_domain, 
		users.country, 
        users.city, 
        users.user_id,
        progress.learn_sql, 
        progress.learn_java
FROM users, progress
WHERE users.user_id = progress.user_id
AND progress.learn_sql = "completed"
AND progress.learn_java = "completed"
ORDER BY 1
LIMIT 25;

-- Q2 c
-- students with their modules progress in the City that starts with ‘F’ or the City that ends with ‘D’
SELECT users.email_domain, 
        users.city, 
        users.country, 
        progress.learn_cpp, 
        progress.learn_sql, 
        progress.learn_html,
        progress.learn_javascript,
        progress.learn_java
FROM users
INNER JOIN progress
ON users.user_id = progress.user_id
WHERE users.city LIKE "F%" || users.city LIKE "%D"
LIMIT 25;

-- Q2 d
-- details of the students taking different courses from the School with the most number of students
-- Get email_domain that has max number of students first, then use as subquery
SELECT email_domain
FROM users
GROUP BY email_domain
HAVING COUNT(user_id) = (SELECT MAX(num_students)
							FROM (
								SELECT COUNT(user_id) AS num_students
                                FROM users
                                GROUP BY email_domain) t);
-- details
SELECT users.user_id, 
		users.email_domain, 
        users.city, 
        users.country, 
        progress.learn_cpp, 
        progress.learn_sql, 
        progress.learn_html,
        progress.learn_javascript,
        progress.learn_java
FROM users, progress
WHERE users.user_id = progress.user_id
AND users.email_domain = (SELECT email_domain
							FROM users
							GROUP BY email_domain
							HAVING COUNT(user_id) = (SELECT MAX(num_students)
														FROM (
															SELECT COUNT(user_id) AS num_students
															FROM users
															GROUP BY email_domain) t))
LIMIT 25;

-- Q2 e
-- module is most popular among the students from the School with the most number of students (Top School)? 
-- And which module is the least popular among the students?  
SELECT  COUNT(IF(progress.learn_cpp != '', progress.user_id, NULL)) AS learn_cpp, 
        COUNT(IF(progress.learn_sql != '', progress.user_id, NULL)) AS learn_sql, 
        COUNT(IF(progress.learn_html != '', progress.user_id, NULL)) AS learn_html, 
        COUNT(IF(progress.learn_javascript != '', progress.user_id, NULL)) AS learn_javascript, 
        COUNT(IF(progress.learn_java != '', progress.user_id, NULL)) AS learn_java
FROM users, progress
WHERE users.user_id = progress.user_id
AND users.email_domain = (SELECT email_domain
							FROM users
							GROUP BY email_domain
							HAVING COUNT(user_id) = (SELECT MAX(num_students)
														FROM (
															SELECT COUNT(user_id) AS num_students
															FROM users
															GROUP BY email_domain) AS t));
-- Most popular: learn_sql
-- Least popular: learn_java


-- check email domains to make sure all ends with ".edu"
SELECT distinct email_domain
FROM users
WHERE email_domain LIKE "%.edu";