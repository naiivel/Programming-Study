DROP TABLE IF EXISTS tblBoard;

CREATE TABLE IF NOT EXISTS tblBoard(
	boardNum int PRIMARY KEY auto_increment,
	boardTitle VARCHAR(50),
	boardAuth VARCHAR(50),
	boardContent VARCHAR(300),
	boardReadCount INT(8) DEFAULT 0,
	boardDate TIMESTAMP DEFAULT now()
);

DESC tblBoard;

SELECT * FROM tblBoard;

INSERT INTO tblBoard(boardTitle, boardAuth, boardContent) VALUES('게시물 제목 1','박정대','내용1');

INSERT INTO tblBoard VALUES(null, '제목2 무', '박정대', '내용없음', 0, now());

INSERT INTO tblBoard(boardTitle,boardAuth,boardContent) SELECT boardTitle,boardAuth,boardContent FROM tblBoard;

SELECT count(*) FROM tblBoard;

SELECT * FROM tblBoard ORDER BY boardNum DESC limit 0, 15; --시작인덱스, 개수