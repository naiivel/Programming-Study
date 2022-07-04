DROP TABLE IF EXISTS big_member;
CREATE TABLE IF NOT EXISTS big_member(
	u_num INT primary key auto_increment, 	-- 회원번호
	u_id VARCHAR(30) unique,			  	-- 회원아이디
	u_pass VARCHAR(30) NOT NULL,			-- 비밀번호
	u_age int,								-- 나이
	u_gender VARCHAR(10), 				    -- 성별
	u_join char(1) default 'Y',				-- 회원탈퇴 여부 Y == 가입상태
	u_regdate TIMESTAMP default now() 		-- 회원가입일	 
);

-- 회원 가입 시
INSERT INTO big_member(u_id,u_pass,u_age,u_gender)
VALUES('admin', 'admin' , 20, 'male');

-- 회원탈퇴 시
-- UPDATE big_member SET u_join = 'N' WHERE u_num = 회원번호;
commit;

-- 관리자가 아니고 탈퇴한 회원이 아닌 정보 출력
SELECT * FROM big_member 
WHERE u_id != 'admin' AND u_join = 'Y' 
ORDER BY u_num DESC

SELECT count(*) AS cnt FROM big_member WHERE u_id != 'admin' AND u_join = 'Y'

SELECT * FROM big_member;

SELECT sysdate();
-- now 한개의 쿼리안에 동일 시간을 출력
-- sysdate : 동일 쿼리라도 호출되는 시점에 시간 출력
SELECT now(), sysdate();


--공지사항 notice_board 
CREATE TABLE notice_board(
	n_num INT PRIMARY KEY auto_increment, -- 공지번호
	n_category VARCHAR(20), 			  -- 공지 분류
	n_author VARCHAR(50),   			  -- 작성자
	n_title VARCHAR(50), 				  -- 제목
	n_content TEXT,         		      -- 내용
	n_date TIMESTAMP default now()        -- 작성시간
);

SELECT * FROM notice_board;

INSERT INTO notice_board(n_category, n_title, n_author, n_content)
SELECT n_category, n_title, n_author, n_content FROM notice_board;











