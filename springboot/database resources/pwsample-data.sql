use onepostdb;
show tables;
select * from users;

SELECT * FROM Users;

SELECT * FROM Post;
INSERT INTO Post (postTitle, postDescribe, postFull, user_id)
VALUES
('title 1', 'description 1', 'full-length 1', 1);

-- wait a couple of seconds before inserting again to see time diff
INSERT INTO Post (postTitle, postDescribe, postFull, user_id)
VALUES
('title 2', 'description 2', 'full-length 2', 1);

INSERT INTO Post (postTitle, postDescribe, postFull, user_id)
VALUES
('title 3', 'description 2', 'full-length 2', 2);

SELECT * FROM Post;

DELETE FROM Users
WHERE user_id=1;

INSERT INTO Users (username, password, email, role, enabled)
VALUES
('kitboga2', '60652', 'bestgoats2@yahoo.com', 'ROLE_USER', 1);

INSERT INTO Post (postTitle, postDescribe, postFull, user_id)
VALUES
('title 4', 'description 4', 'full-length 2', 3);

INSERT INTO Reply (reply, user_id, idPost)
VALUES
('Nice post!', 1, 1);


DELETE FROM Post WHERE idPost=1;
DELETE FROM UAPost WHERE idPost=2;
delete from Reply where idReply=14;

select * from Users;
select * from UAPost;
select * from PostReply;
select * from Post;
select * from Reply;

-- latest post & reply times for a user
SELECT MAX(postTime) FROM Post WHERE user_id=1; 
SELECT MAX(replyTime) FROM Reply WHERE user_id=1;

select postTime from Post where user_id=1;