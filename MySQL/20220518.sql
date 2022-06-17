use sqldb;

-- sqldb table 목록 확인
show tables;

-- usertbl, buytbl 정보 검색
SELECT * FROM userTBL;
SELECT * FROM buyTBL;

-- 행정보 추가 
DESC userTBL;
INSERT INTO userTBL VALUES('LSS', '이순신', 1685, '전남', null, null, 170, '2002-06-06');

-- 경남에 사는 사람과 키가 동일한 사람 검색
SELECT height FROM userTBL WHERE addr = '경남'; -- 결과 : 170    ,    173
SELECT name, height,addr FROM userTBL WHERE height = 170 OR height = 173;
SELECT name,height,addr FROM userTBL WHERE height IN(SELECT height FROM userTBL WHERE addr = '경남');
DELETE FROM userTBL WHERE userid = 'LSS';

-- 경남에 사는 사람보다 키가 같거나 큰 사람들 검색 ANY = or
SELECT name,height,addr FROM userTBL WHERE height >= ANY(SELECT height FROM userTBL WHERE addr='경남');

-- 경남에 사는 사람 중 가장 키가 큰 사람과 키가 같거나 큰 사람의 정보 검색 ALL = and
SELECT name,height,addr FROM userTBL WHERE height>= ALL(SELECT height FROM userTBL WHERE addr='경남');

-- 검색된 행의 정보를 정렬하는 ORDER BY절, ASC:오름차순 DESC:내림차순 -- ASC 오름차순 : defalut값 생략하면 ASC
-- 거주 지역별로 오름차순 정렬
SELECT * FROM userTBL ORDER BY addr ASC;

-- 가장 최근에 가입한 순서대로 정렬
SELECT * FROM userTBL ORDER BY mDate DESC;

-- 거주지역 순으로 정렬하고 동일지역이면 나이순으로 정렬
SELECT * FROM userTBL ORDER BY addr, birthyear;

-- 검색결과에 중복된 행의 정보를 제거 - distinct
-- 키가 175이상인 사람이 사는 곳 검색
SELECT addr,height FROM userTbL WHERE height>=175 ORDER BY addr;

SELECT DISTINCT addr,height FROM userTBL WHERE height >= 175;

-- 검색된 결과 내에서 제공되는 개수를 제한하는 LIMIT
-- MySQL에서만 존재하고 다른 데이터베이스보다 속도가 빠르다
SELECT * FROM userTBL ORDER BY mDate ASC LIMIT 5; -- 처음부터 5개
SELECT * FROM userTBL ORDER BY mDAte ASC LIMIT 5,5; -- 5인덱스 다음부터 5개 (6,7,8,9,10)

-- LIMIT 개수 OFFSET 시작인덱스; 
SELECT * FROM userTBL ORDER BY mDate ASC LIMIT 6 offset 5;

-- GROUP BY HAVING 절과 집계함수
-- buytbl에서 구매한 총 물량의 개수
SELECT amount FROM buyTBL;

-- sum() 합계
SELECT sum(amount) AS '구매개수' FROM buyTBL;

-- buyTBL에서 사용자마다 구매한 개수를 검색
SELECT userID,sum(amount) AS '개수' FROM buytbl GROUP BY userID;

-- COUNT() table에 존재하는 행의 개수를 검색
-- count(열이름) 해당 속성에 유효한 값을 가진 행의 개수를 반환
SELECT * FROM userTBL;
SELECT count(*) FROM userTBL;
SELECT COUNT(mobile1) FROM userTBL;
SELECT count(*) FROM userTBL WHERE mobile1 is not NUll;
SELECT count(userID) FROM userTBL;
SELECT addr FROM userTBL ORDER BY addr DESC;
SELECT count(distinct addr) FROM userTBL;

-- min(), max() : 동일속성에 저장된 최소값과 최대값을 검색
-- userTBL에서 키가 가장 작은 사람
SELECT min(height) FROM userTBL; 
-- userTBL에서 키가 가장 큰 사람
SELECT max(height) FROM userTBL;

-- userTBL에서 키가 가장 작은 사람의 이름과 키 그리고 키가 가장 큰 사람의 이름과 키
SELECT name,height FROM userTBL WHERE height = (SELECT min(height) FROM userTBL) OR height = (SELECT max(height) FROM userTBL);
-- == SELECT name,height FROM userTBL WHERE height IN((SELECT min(height) FROM userTBL),(SELECT max(height) FROM userTBL));

-- buyTBL에 등록된 상품들 중에 가장 가격이 낮은 상품과 가장 가격이 높은 상품의 이름과 가격
SELECT prodName,price FROM buyTBL WHERE price IN((SELECT max(price) FROM buyTBL),(SELECT min(price) FROM buyTbl)) GROUP BY prodName;

-- 전체 판매 금액 
SELECT groupName,sum(price * amount) FROM buyTbL GROUP BY groupName;

-- 그룹별 판매 금액
SELECT sum(price * amount) FROM buyTbl;

-- avg(열이름) 평균
-- sum(열이름) / count(열이름)
SELECT avg(height) FROM userTBl;

-- 지역별 평균 키
SELECT addr,avg(height) AS '평균키' FRom userTBL GROUP BY addr ORDER BY 평균키 DESC;

-- 실수값을 소수점 첫째자리에서 반올림 ROUND()
SELECT addr, ROUND(avg(height)) AS '키' FROM userTBL GROUP BY addr;

-- CEIL() 올림
SELECT CEIL(192.166) FROM DUAL;

-- FLOOR() 내림
SELECT FLOOR(192.166);

-- WITH ROLLUP : 그룹별로 합계를 구할때 사용 
-- GROUP BY :  항복별 합계에 항목별합계가 아니라 항목별 합계와 전체합계를 검색해주는 키워드
SELECT addr, ROUND(avg(height)) AS '평균키' FROM userTBL GROUP BY addr WITH ROLLUP;
SELECT ROUND(avg(height)) AS '평균키' FROM userTBL;

-- 그룹별 총 판매 금액, 상품별 총 판매금액, 전체 팜매금액 검색
-- 그룹이름, 상품이름, 판매금액
SELECT prodName, sum(price*amount)FROM buyTBL GROUP BY prodName; -- 하나씩하나씩해야하는 것 대신 ROLLUP 사용
SELECT groupName,prodName,sum(price*amount) FROM buyTBL group by groupName,prodName WITH ROLLUP ORDER BY groupName DESC, prodName DESC;



/**********************************************/
-- 임시 테이블을 생성하여 기존 테이블의 정보를 가져와서 저장
DESC userTBL;
-- userID, name, mDate
CREATE TABLE temp_user_tbl(userID char(8) PRIMARY KEY, name VARCHAR(10) NOT NULL, mDate date);
-- INSERT INTO table명(컬럼 명) VALUES(열값,열값);
INSERT INTO temp_user_tbl SELECT userID, name, mDate FROM userTBL;
DESC temp_user_tbl;
SELECT*FROM temp_user_tbl;

-- buyTbl 구조를 복사하여 테이블을 생성하고 SELECT 문에서 검색된 구조와 데이터를 저장 
CREATE TABLE buytbl2(SELECT*FROM buytbl);
DESC buytbl2;
SELECT*FROM buyTBL2;

CREATE TABLE buyTbl3(SELECT userID FROM buyTBL);
DESC buytbl3;
SELECT*FROM buytbl3;

-- 데이터는 백업하지않고 구조만 일치하는 새로운 테이블 생성
CREATE TABLE buytbl4(SELECT * FROM buytbl WHERE 1 = 0);
DESC buytbl4;
SELECT*FROM buytbl4;

-- GROUP BY HAVING :  주문횟수가 3번 이상인 회원의 id,주문횟수 정보검색
SELECT*FROM buytbl;
SELECT userid, count(*) AS '구매횟수' FROM buytbl GROUP BY userid HAVING count(*) >= 3;

-- JYP가 구매한 구매금액 검색
SELECT sum(amount*price) FROM buytbl WHERE userid = 'jyp';

-- 구매금액이 JYP보다 크거나 같은 회원 정보 id,구매금액 검색
SELECT userid, sum(price*amount) AS '돈' FROM buytbl GROUP BY userid HAVING 돈>= (SELECT sum(amount*price) FROM buytbl WHERE userid = 'jyp'); 




/***********************************************************/
-- DML 데이터 조작어
-- SELECT(검색), INSERT INTO(삽입), UPDATE(수정), DELETE FROM(삭제)
-- INSERT INTO table명 Values(컬럼명,...);
DESC buytbl4;
SELECT count(*) FROM buytbl4;
INSERT INTO buytbl4 VALUES(1, 'PJS', 'RT3080', '전자', 1000, 1);
SELECT * FROM buytbl4;

-- 수정 UPDATE
-- UPDATE table명 SET 수정할 열이름 = 수정할 값, 수정할 열이름 = 수정할 값
-- WHERE 조건을 비교할 속성이름 = 비교할 값;

-- buytbl4 table에 num 2번인 행의 정보를 groupName = 전자로 수정
UPDATE buytbl4 SET groupName = '전기' WHERE num = 1;
SELECT * FROM buytbl4; 
SELECT * FROM buytbl2;

-- buytbl2의 모니터 가격을 250으로 변경
UPDATE buytbl2 SET price = '250' WHERE prodName = '모니터';

-- buytbl2의 상품 중 청바지의 가격을 60으로 변경하고 판매개수(amount)를 5로 변경
UPDATE buytbl2 SET price = 60, amount = 5 WHERE prodName = '청바지';

-- num이 8번인 행의 prodName을 면바지로 변경, price를 40으로 변경, amount를 6으로 변경, groupName을 의류로 변경
UPDATE buytbl2 SET prodName='면바지',price=40,amount=6,groupName='의류'WHERE num=8;

-- 조건절이 없는 UPDATE
-- 모든 상품의 가격이 5,000인상
UPDATE buytbl2 SET price = price+5;

-- 전자제품의 가격이 10,000 인상
UPDATE buytbl2 SET price = price + 10 WHERE groupName = '전자';

-- table에 삽입되어 있는 행의 정보를 삭제 : DELETE FROM 
DELETE FROM buytbl2;
SELECT * FROM buytbl2;

-- buytbl2에서 userid가 bbk인 정보삭제
DELETE FROM buytbl2 WHERE userid = 'bbk';

-- table에 모든정보를 비움
TRUNCATE buytbl2;
DESC buytbl2;
INSERT INTO buytbl2(userID, amount) VALUES('PJS',5);
SELECT*FROM buyTbl2;
INSERT INTO buytbl2(userID, amount) VALUES('CEJ',2);
SELECT*FROM buyTbl2;
DELETE FROM buytbl2; -- 삭제
TRUNCATE buytbl2; -- 초기화

commit;
rollback;