-- ctrl + enter //커리문 실행
-- Create 명령어를 이용하여 database 또는 table 등 데이터를 정의하는 구조를 생성
-- CEATE SCHEMA `sqldb`;  공백이 들어가면 ``로 감싸야함

use sqldb;


CREATE TABLE `sqldb`.`member_tbl` (
  `member_id` VARCHAR(50) NOT NULL COMMENT '회원을 구분짓는 아이디',
  `member_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '회원의 이름',
  `member_addr` VARCHAR(45) NULL COMMENT '회원 배송 주소',
  PRIMARY KEY (`member_id`))
COMMENT = '회원정보에 대한 정보';

/*
	talble 이름 : product_tbl
    상품이름 : product_name varchar(50),
    상품가격 : cost INT,
    제조날짜 : make_date VARCHAR(20);member_tblmember_tbl
    남은수량 : amount : INT NULL
*/


-- 지정된 데이터베이스의 테이블 이름 정보 확인
show tables;

-- product_tbl의 모든 열의 정보 검색
SELECT * FROM product_tbl;

-- sqldb schema or database 삭제
DROP DATABASE sqldb;

-- ------------------------------------
-- sqldb schema/database 생성
CREATE DATABASE sqldb;

-- testdb database/schema 생성
-- testdb가 존재하지 않으면 create
CREATE SCHEMA IF NOT EXISTS testdb;

-- testdb 삭제
DROP DATABASE IF EXISTS testDB;
CREATE DATABASE testDB;

USE testdb;
-- 사용자 정보를 저장하는 테이블
CREATE TABLE IF NOT EXISTS userTbl(
	userID char(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr char(2) NOT NULL,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate date
);

-- 상품 정보를 저장하는 테이블
CREATE TABLE IF NOT EXISTS prodTbl(
	num INT(8) NOT NULL PRIMARY KEY,
    userID char(8) NOT NULL,
    prodName char(6),
    groupName char(4),
    price char(5),
    count smallint NOT NULL
);


show tables;

DESCRIBE usertbl; -- = DESC usertbl;

-- 정의된 정보를 수정하는 keyword - ALTER
-- table 이름 수정
-- ALTER TABLE prodTbl RENAME buyTBL 

-- byTBL에 있는 price 속성에 dataType을 INT로 변경
ALTER TABLE buyTBL MODIFY price INT;

-- 변경 확인
DESC buytbl;

-- buyTBL의 num 속성을 변경
ALTER TABLE buyTBL MODIFY num INT AUTO_INCREMENT; -- primary와 int만 auto increment 지정가능

-- buyTBL count열의 이름과 속성 변경
-- amount로 변경
ALTER TABLE buyTBL CHANGE count amount smallint NOT NULL;

-- 테이블에 행의 정보를 추가하는 DML 
-- INSERT INTO VALUES
INSERT INTO userTBL VALUES('PJS','박주신',1988,'평양',null,null,162,'1989-8-8');
SELECT * FROM userTBL;
INSERT INTO userTBL VALUES('PJS','박재신',1988,'평양',null,null,182,'1989-10-8');
SELECT * FROM userTBL;

INSERT INTO buyTbl values(null, 'PJS', "운동화", '의류', 30,1);
SELECT * FROM buytbl;

INSERT INTO buyTbl values(null, 'PTH', "세탁기", '전자', 400, 2);
SELECT * FROM buytbl;

-- buytbl의 userId 열정보를 userTBL 테이블에 userId의 외래키로 지정 
ALTER TABLE buyTBL ADD CONSTRAINT FOREIGN KEY(userID)
REFERENCES userTBL(userID);

DESC buyTBL;

SELECT * FROM buytbl;
SELECT * FROM usertbl;

TRUNCATE buyTBL;
TRUNCATE userTBL;

-- 테이블에 존재하는 특정 행의 정보를 삭제하는 DML.  DELETE FROM table명
DELETE FROM userTBL; -- WHERE 0 = 0;

-- SELECT column명 FROM table 명 WHERE 조건절
SELECT * FROM userTBL WHERE name = '김범수';   -- 조건절: name속성의 값이 '김범수'와 일치하는 사용자의 행의 *(모든)정보 부르기
-- userTBL 에서 userID가 BBK인 사람을 검색
SELECT * FROM usertbl WHERE userID = 'BBK'; 

-- 1970년 이후에 출생하고 키가 182이상인 사람 검색
SELECT * FROM usertbl WHERE birthyear > 1970 && height >= 182;

-- userTbl에서 경기에 사는 사람의 이름과 주소만 검색
SELECT name,addr FROM usertbl WHERE addr = '경기';

-- userTbl에서 1970 ~ 1979 사이에 태어난 사람의 이름
SELECT name FROM userTBl WHERE birthyear >= 1970 && birthyear <= 1979;

-- 키가 180이상 183이하인 사람의 이름,주소,키 정보 검색
SELECT name,addr,height FROM userTbl WHERE height>=180 && height<=183;

-- BETWEEN 범위값 AND 범위값
SELECT * FROM userTBL WHERE height BETWEEN 180 AND 183; -- 180과 183사이  133Line과 동일

-- userTBL에서 주소가 '경남'이거나 '전남'이거나 '경북'인 사람 검색
SELECT * FROM userTBL WHERE addr='경남' or addr = '전남' or addr = '경북';

-- WHERE IN : 동일한 속성에서 특정 조건들을 만족하는 정보를 검색
SELECT * FROM userTBL WHERE addr IN('경북','경기','전남');

-- LIKE wildcard[ % || _ ]를 활용한 검색 
-- 와일드 카드를 이용하여 1970년대 출생한 사람 찾기 1970 ~ 1979
SELECT * FROM userTBL WHERE birthyear LIKE '197_';

-- usertbl에서 성이 '김'씨인 모든 사용자 정보 검색
SELECT * FROM userTBL WHERE name LIKE '김__';

-- userTBL에서 이름 사이에 '시'가 들어가는 사용자 검색
SELECT * FROM userTBL WHERE name LIKE '_시_';

-- 김으로 시작하고 뒤에는 무슨값이든 상관x
SELECT * FROM userTBL WHERE name Like '김%';

-- NULL 값 비교
SELECT * FROM usertbl;

-- usertbl 에서 mobile1 핸드폰 번호가 없는 사용자 정보검색
SELECT * FROM userTBL WHERE mobile1 = null;

-- NULL 비교 연산 할 때는 WHERE IS 사용
SELECT*FROM userTBL WHERE mobile1 IS NULL;

-- 전화번호가 존재하는 사용자 
SELECT * FROM userTBL WHERE mobile1 IS NOT NULL;

-- 거주지가 서울이 아닌 사람 검색
SELECT * FROM userTBL WHERE addr != '서울'; -- WHERE NOT addr = '서울'; / WHERE addr <> '서울';

-- 전화번호 시작(mobile1)이 016,018,019인 사람들 검색
SELECT * FROM userTBL WHERE mobile1 = 016 or mobile1 = 018 or mobile1 = 019;
-- ex) WHERE mobile1 IN('016','018','019');

-- height 키가 170이상인 사람 검색
SELECT * FROM userTBL WHERE height >= 170; 

-- 이름이 김경호인 사람의 키 검색
SELECT height FROM userTBL WHERE name = '김경호';

-- 김경호와 키가 같거나 큰 사람의 이름과 키를 검색
SELECT name, height FROM userTBL WHERE height > (SELECT height FROM usertbl WHERE name = '김경호'); 




