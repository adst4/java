create database exam;

use exam;

create table test(qid int,que varchar(100),o1 varchar(50),o2 varchar(50),o3 varchar(50),o4 varchar(50),ans varchar(50));

insert into test values(1,'Which of the following function sets first n characters of a string to a given character?','strinit()','strnset()','strset()','
strcset()','strnset()');

insert into test values(3,'The library function used to find the last occurrence of a character in a string is','strnstr()','laststr()','
strrchr()','strstr()','strrchr()');

INSERT INTO test VALUES (5, 'Which SQL keyword is used to retrieve unique records from a database table?', 'SELECT DISTINCT', 'SELECT UNIQUE', 'SELECT UNIQUE RECORDS', 'SELECT UNIQUE VALUES', 'SELECT DISTINCT');



