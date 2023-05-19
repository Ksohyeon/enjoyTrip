use tripcrawl;
drop table if exists qna_comment;
drop table if exists qna;

CREATE TABLE qna (
	no int auto_increment PRIMARY KEY,
	title VARCHAR(20) NOT NULL,	
	category VARCHAR(20) NOT NULL,
	content VARCHAR(1000) NOT NULL,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    author VARCHAR(20) NOT NULL,
	FOREIGN KEY (author) REFERENCES members(user_id) ON DELETE CASCADE
);

Insert into qna (title, category, content, author)
values ('글제목', '글종류', '글내용', 'ssafy');

Insert into qna (title, category, content, author)
values ('글제목2', '글종류2', '글내용2', 'admin');




CREATE TABLE qna_comment (
	comment_no int auto_increment PRIMARY KEY,
    comment_content VARCHAR(1000) NOT NULL,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    user_id VARCHAR(20) NOT NULL,
    qna_no int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES members(user_id) ON DELETE CASCADE,
    FOREIGN KEY (qna_no) REFERENCES qna(no) ON DELETE CASCADE
);

Insert into qna_comment (comment_content, user_id, qna_no)
values ('댓글입니다', 'ssafy', '1');


SELECT c.qna_no, c.comment_no, c.comment_content, c.created_at, m.user_id, m.nickname
FROM qna q
JOIN qna_comment c ON q.no = c.qna_no
JOIN members m ON c.user_id = m.user_id
WHERE q.no = 1;