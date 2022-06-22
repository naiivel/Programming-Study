CREATE TABLE tbl_book1(
	num INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(300) NOT NULL,
	author VARCHAR(300) NOT NULL,
	regdate TIMESTAMP default now()
);

DESC tbl_book;

INSERT INTO tbl_book1(title,author) VALUES('혼자공부하는 자바','신용권');
SELECT*FROM tbl_book1;

rollback;

-- table 상태 정보 확인
show table status WHERE name = 'tbl_book1';
-- auto_increment 현재값 수정하는 방법
ALTER TABLE Bigdata.tbl_book AUTO_INCREMENT = 1;

SELECT * FROM tbl_book;























