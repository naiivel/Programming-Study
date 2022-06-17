-- 제약조건
CREATE TABLE test_usertbl(
	userID char(8),  -- PRIMARY KEY -- AUTO_INCREMENT 사용안됨, 정수값을 저장하는 속성에만 사용 가능
    name VARCHAR(10) NOT NULL, -- NULL 값이 들어오면 오류
    email VARCHAR(50) NULL UNIQUE, -- UNIQUE 중복 x
    birthYear INT CHECK(birthYear >= 1900 AND birthYear <= 2021),
    height INT CHECK(height > 0),
    mDate TIMESTAMP NULL DEFAULT now(),
    PRIMARY KEY(userID)
);
INSERT INTO test_usertbl(userID,name,email,birthYear,height) VALUES('CEJ','최은진',null,2000,'173');
SELECT * FROM test_usertbl;


CREATE TABLE test_prodtbl(
	code char(3) NOT NULL,
    id char(4) NOT NULL, -- primary key는 테이블에 하나로 유일해야 함
    pdate TIMESTAMP NOT NULL,
    PRIMARY KEY(code,id)
);

-- 둘 다 중복시 개체 무결성 위반으로 삽입 불가
INSERT INTO test_prodtbl VALUES('p_2','001',now()); 
SELECT*FROM test_prodtbl;


/********************************************************/
-- VIEW
-- 가상의 테이블 
-- 물리적으로 존재하지 않지만 SELECT문을 통해 생성된 구조와 정보를 가지고 있음
-- CREATE VIEW AS SELECT문을 통해 개체 생성 : VIEW 개체
-- 질의 안에 FROM 테이블 위치에 직접 SELECT문을 적용 : INLINE VIEW 

use bigdata;
DESC emp;
CREATE VIEW v_emp AS SELECT empno,ename FROM emp;
DESC v_emp;
SELECT * FROM v_emp;
DROP VIEW IF EXISTS v_emp;

-- SELECT문의 결과를 이름을 가지는 뷰라는 개체 생성
-- 실제 데이터를 비추는 창문에 비유
-- 보안적인 목적으로 사용
-- 사용자는 사용되고 있는 데이터가 실제 테이블인지 가상의 테이블(VIEW)인지 구별하기 힘듬
-- 실제 테이블의 구조를 파악하기 힘듬

CREATE OR REPLACE VIEW v_usertbl AS SELECT userID, name FROM usertbl; -- 있으면 replace 없으면 create 해준다는 뜻
DESC usertbl;
DESC v_usertbl;
INSERT INTO v_usertbl VALUES('ABC','이주명');
INSERT INTO v_usertbl VALUES('ABC','이주명',1980,'부산',null,null,178,now());

SELECT*FROM v_usertbl;
UPDATE v_usertbl SET name = '박주신' WHERE userID = 'BBK';
DELETE FROM v_usertbl WHERE userID = 'BBK';

-- 뷰에 존재하지 않는 열 사용불가
UPDATE v_usertbl SET birthYear = 1900 WHERE userID = 'LSG';
rollback;

-- 인라인 뷰
-- 서브쿼리가 FROM 절 안에서 사용되는 경우, 해당 서브쿼리를 '인라인 뷰'라고 함
-- FROM 절에서 사용된 서브쿼리의 결과가 하나의 테이블에 대한 VIEW 처럼 사용

-- 인라인 뷰를 이용해서 부서별 평균 급여가 2500 이상인 부서의 부서 번호, 평균 급여를 출력
SELECT * FROM (SELECT deptno, avg(sal) AS '평균급여' FROM emp GROUP BY deptno) AS temp WHERE 평균급여 >= 2500;

-- 부서별 평균 급여와 급여등급을 인라인 뷰를 이용해서 출력
SELECT e.deptno,avgSal,grade
FROM (SELECT deptno,avg(sal) AS avgSal FROM emp GROUP BY deptno) e, salgrade s 
WHERE avgSal BETWEEN s.losal ANd s.hisal;

-- Question
-- 부서별 평균급여와 급여등급을 검색하는데 부서이름, 부서번호, 평균급여, 급여등급 형식으로 출력
SELECT d.deptno, e.avgSal, s.grade, d.dname
FROM (SELECT deptno, avg(sal) AS avgSal FROM emp GROUP BY deptno) e, salgrade s, dept d
WHERE avgSal BETWEEN s.losal AND s.hisal AND e.deptno = d.deptno;


/**********************************************************/
-- INDEX 색인 목록
-- data를 찾기 위한 데이터
-- 책의 목차에 비유
-- 특정 테이블의 특정 컬럼(열)을 지정하여 인덱스를 생성
-- 지정한 인덱스를 이용하여 데이터를 검색
-- 목적은 빠른 검색 
-- PRIMARY KEY를 지정한 컬럼에 대해서는 자동으로 INDEX가 생성
-- 나머지 컬럼(열)이 검색 조건이 된다면 직접 인덱스를 생성해서 사용

-- INDEX를 생성하는 방법
-- CREATE INDEX 인덱스 이름 ON table 이름(컬럼이름)
-- ALTER TABLE 테이블 이름 ADD INDEX 인덱스 이름(컬럼이름);
ALTER TABLE emp ADD INDEX idx_emp_sal(sal);
SHOW INDEXES FROM emp;
CREATE INDEX inx_emp_sal ON emp(sal);

-- index 삭제
-- DROP INDEX 인덱스 이름 ON database이름.table이름;
-- ALTER TABLE 테이블이름 DROP INDEX 인덱스 이름;
DROP INDEX inx_emp_sal ON bigdata.emp;
ALTER TABLE emp DROP INDEX idx_emp_sal;

use employees;
show tables;
SELECT count(*) FROM employees;
DESC employees;

SELECT * FROM employees WHERE gender = 'M';
CREATE INDEX idx_emp_gender ON employees(gender);
SHOW INDEXES FROM employees;

-- 인덱스를 모든 컬럼에 생성하는 것은 좋지 않음
-- 저장공간을 차지하고 인덱스가 생성된 컬럼에 삽입이나 삭제가 일어나면 다시 변경해야하기 때문 인덱스 페이지를 새로 생성해야 할 수 있어 성능에 악영향
-- 검색에 자주 사용되는 컬럼에만 생성 / 데이터 변경이 자주 일어나지 않는 테이블에 생성하는게 좋음 
-- 검색쿼리에 영향을 주는게 INDEX 



/*******************************************/
-- 스토어 프로시저(Stored Procedure) 
-- 여러개의 쿼리 혹은 동작을 프로시저라는 개체로 묶어서 저장
-- 프로시저 이름을 통해서 작동 시키므로 내부의 쿼리를 숨길 수 있음
-- 작성된 프로시저는 CALL 이라는 예약어를 활용해서 사용(호출)

-- DLIMITER : 구문 문자
use bigdata;
commit;
SELECT * FROM emp;
SELECT * FROM dept;
/*
	DELIMITER // 
    CREATE PROCEDURE 프로시저 이름(매개변수...)
		BEGIN
			내용
		END //
	DELIMITER;
    CALL 프로시저이름(인자값...);
*/

DELIMITER //
CREATE PROCEDURE reademp()
	BEGIN
		SELECT * FROM emp;
    END //
DELIMITER ;

CALL reademp();

-- 매개변수를 넘겨받는 프로시저
DELIMITER //
CREATE PROCEDURE info_emp(IN _empno INT)
	BEGIN
		SELECT*FROM emp WHERE empno = _empno;
    END //
DELIMITER ;

CALL info_emp(7499);

-- 입력값 이상의 급여를 받는 사원의 사원번호, 이름, 입사일, 급여를 검색하는 프로시저
DELIMITER $$
USE `bigdata`$$
CREATE PROCEDURE `info_sal_over` (IN _sal INT)
	BEGIN
		SELECT empno, ename, hiredate, sal 
		FROM emp
		WHERE sal >= _sal;
END$$
DELIMITER ;
CALL info_sal_over(1500);

-- 여러개의 매개변수를 전달받는 프로시저
-- 두개의 급여 금액을 입력받아 두 급여사이의 급여를 받는 사원에 대한 정보를 검색
DELIMITER // 
	CREATE PROCEDURE info_sal_between(IN a_sal INT,IN b_sal INT)
		BEGIN
			SELECT * FROM emp
            WHERE sal BETWEEN a_sal AND b_sal;
        END //     
DELIMITER ; 

CALL info_sal_between(2000,3000);

-- usertbl : 회원이름을 입력받아서 회원의 나이에 따라 1980년 이전 출생 = 늙었네.
--           1980년 이후 출생 = 아직 젊으시네요.
DELIMITER //
	CREATE PROCEDURE checkYear(IN uname VARCHAR(10))
		BEGIN
			-- 정수값을 저장하는 변수 yearBirth 선언
			DECLARE yearBirth INT;
            SELECT birthYear INTO yearBirth FROM userTbl WHERE name = uname;
            IF(yearBirth >= 1980) THEN SELECT '아직 젊으시네요.' AS ANSWER;
            ELSE SELECT '나이가 지긋하시네요.' AS ANSWER;
            END IF;
        END //
DELIMITER ; 

CALL checkYear('이승기');

-- PROCEDURE roof
-- 구구단의 단수를 입력받아서 해당 단수를 출력하고 table에 저장 
CREATE TABLE temp_tbl(txt Text);
DELIMITER //
	CREATE PROCEDURE whileTest(IN num INT)
		BEGIN 
			DECLARE str VARCHAR(100); -- 각 단을 문자열로 저장
            DECLARE i INT; -- 구구단 뒷자리
            SET str = ' '; 
            SET i = 1;
            -- 사용자에게 입력받은 구구단수 : num
			WHILE(i<10) 
				DO SET str = concat(str,' ',num,'X',i,'=',num*i);
                   INSERT INTO temp_tbl VALUES(str);
				   SET i = i + 1; -- 뒷자리수 증가
                   SELECT str AS RESULT; -- 문자열 출력
			END WHILE;
        END //
DELIMITER ; 

CALL whileTest(9);
SELECT * FROM temp_tbl;

CREATE TABLE member_tbl(num INT PRIMARY KEY auto_increment, -- 회원번호
                        id VARCHAR(50) UNIQUE,              -- 사용자 id
                        pw VARCHAR(50) NOT NULL,            -- 사용자 비밀번호
                        name VARCHAR(10),                   -- 이름
                        regDate TIMESTAMP default now()     -- 회원등록일
                        );
INSERT INTO member_tbl(id,pw,name) VALUES('id001','pw001','최기근');                        
SELECT * FROM member_tbl;
INSERT INTO member_tbl(id,pw,name) VALUES('id003','pw002','박주신');
SELECT LAST_INSERT_ID(); -- 마지막으로 입력된 PRIMARY KEY 값 반환
UPDATE member_tbl SET id = 'id003' WHERE num = LAST_INSERT_ID();

-- 매개변수로 id,password 넘겨받아서 아이디와 패스워드가 일치하는 사용자가 존재하면 true, 존재하지 않으면 false 출력
DELIMITER //
	CREATE PROCEDURE loginCheck(IN _id VARCHAR(50),
								IN _pw VARCHAR(50),
								OUT answer BOOLEAN
        )
        BEGIN
			-- 검색결과를 문자열로 저장할 변수
            DECLARE result VARCHAR(10);
            SET result = (SELECT id FROM member_tbl WHERE id = _id AND pw = _pw);
            IF(result IS NOT NULL) THEN SELECT TRUE INTO answer;
            ELSE SELECT FALSE INTO answer;
            END IF;
        END //
DELIMITER ;

CALL loginCheck('id001','pw001',@answer); -- @: 사용자 정의 변수
SELECT @answer; -- false : 0, true : 1


/************************************************************/
-- 트리거 
-- 특정 테이블에 INSERT, UPDATE, DELETE 같은 DML이 수행되었을 때 데이터베이스에 등록된 Query문을 자동으로 동작하도록 작성된 프로그램
-- 사용자의 직접호출이 아니라 데이터베이스에 의해 자동으로 호출 
-- DML의 transaction과 주기를 같이 한다.
/*
DELIMITER //
	CREATE TRIGGER trigger_name {BEFORE(삭제되기전) or AFTER(삭제되기후)} {INSERT or UPDATE or DELETE} 
    ON table_name 
    FOR EACH ROW (행들을 순회한다는 뜻)
    BEGIN
		-- 트리거에 실행될 내용
	END //
DELIMIER ;
*/

DELIMITER //
	CREATE TRIGGER test_trg -- 트리거 이름 지정
    AFTER INSERT            -- 삽입 이후에 실
    ON member_tbl           -- 트리거를 부착할 테이블
    FOR EACH ROW            -- 각 행마다 적용
    BEGIN
		SET @result = 'member insert';
	END //
DELIMITER ;

SET @result = ' ';
SELECT @result;
INSERT INTO member_tbl(id,pw,name) VALUES('id004','pw004','조현빈');
UPDATE member_tbl SET name = '김선기' WHERE id = 'id003'; -- trigger 작동안함 (UPDATE라서)

DESC back_member_tbl;
CREATE TABLE back_member_tbl(SELECT * FROM member_tbl WHERE 1 = 0);

DELIMITER //
	CREATE TRIGGER backup_trg2
    AFTER DELETE
    ON member_tbl
    FOR EACH ROW
    BEGIN
		-- 삭제된 행의 정보 : 열(emp속성)
        -- 삭제된 행정보 == OLD
        INSERT INTO back_member_tbl(num,id,pw,name,regdate) VALUES(OLD.num,OLD.id,OLD.pw,OLD.name,OLD.regdate);
    END //
DELIMITER ;

SELECT * FROM back_member_tbl;
SELECT * FROM member_tbl;
DELETE FROM member_tbl WHERE num = 2;


DELIMITER //
	CREATE TRIGGER before_usertbl
    BEFORE INSERT
    ON userTbl 
    FOR EACH ROW
    BEGIN
		-- OLD UPDATE DELETE : 기존 정보
        -- NEW UPDATE INSERT : 새로운 정보
        IF NEW.birthYear < 1900 THEN
			SET NEW.birthYear = 0;
        ELSEIF NEW.birthYear > YEAR(now()) THEN
			SET NEW.birthYear = YEAR(now()); 
        END IF;
    END //
DELIMITER ;

SELECT YEAR(now());
SELECT MONTH(now());

INSERT INTO userTbl VALUES('PJS','박주신',1880,'개성','049','00000',158,'2020-12-25');
SELECT*FROM userTbl WHERE userID = 'PJS';
INSERT INTO userTbl VALUES('KSG','김선기',2988,'평양','02','00000',164,'2012-04-05');
SELECT*FROM userTbl WHERE userID = 'KSG';

SELECT * FROM emp;
SELECT * FROM dept;
SELECT A.ename, B.ename FROM emp A JOIN emp B ON A.mgr = B.empno ORDER BY A.ename DESC;




commit;
rollback;

-- INDEX를 생성하는 방법
-- CREATE INDEX 인덱스 이름 ON table 이름(컬럼이름)
-- ALTER TABLE 테이블 이름 ADD INDEX 인덱스 이름(컬럼이름);
ALTER TABLE emp ADD INDEX idx_emp_sal(sal);
SHOW INDEXES FROM emp;
CREATE INDEX inx_emp_sal ON emp(sal);

-- index 삭제
-- DROP INDEX 인덱스 이름 ON database이름.table이름;
-- ALTER TABLE 테이블이름 DROP INDEX 인덱스 이름;
DROP INDEX inx_emp_sal ON bigdata.emp;
ALTER TABLE emp DROP INDEX idx_emp_sal;

use employees;
show tables;
SELECT count(*) FROM employees;
DESC employees;

SELECT * FROM employees WHERE gender = 'M';
CREATE INDEX idx_emp_gender ON employees(gender);
SHOW INDEXES FROM employees;

-- 인덱스를 모든 컬럼에 생성하는 것은 좋지 않음
-- 저장공간을 차지하고 인덱스가 생성된 컬럼에 삽입이나 삭제가 일어나면 다시 변경해야하기 때문 인덱스 페이지를 새로 생성해야 할 수 있어 성능에 악영향
-- 검색에 자주 사용되는 컬럼에만 생성 / 데이터 변경이 자주 일어나지 않는 테이블에 생성하는게 좋음 
-- 검색쿼리에 영향을 주는게 INDEX 

SHOW INDEXES FROM emp;
CREATE INDEX inx_emp_ename ON emp(ename);
DESC emp;

ALTER TABLE emp DROP INDEX inx_emp_ename;











