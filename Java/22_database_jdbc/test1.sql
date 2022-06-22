SELECT * FROM member_tbl;

CREATE TABLE student(
	stuNo INT PRIMARY KEY auto_increment,
	stuName VARCHAR(50),
	stuDept VARCHAR(50),
	stuGrade INT,
	stuClass char(1)DEFAULT 'A',
	stuGender char(1) DEFAULT 'F',
	stuDate TIMESTAMP DEFAULT now()
);

show tables;

commit;
SELECT * FROM student;
DESC student;

call checkYear('바비킴');

SELECT*FROM userTbl;