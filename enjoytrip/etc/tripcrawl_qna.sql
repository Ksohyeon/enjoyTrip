use tripcrawl;
drop table if exists qna;

CREATE TABLE qna (
	no int auto_increment PRIMARY KEY,
	title VARCHAR(20) NOT NULL,	
	category VARCHAR(20) NOT NULL,
	content VARCHAR(1000) NOT NULL,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    author VARCHAR(20) NOT NULL,
	FOREIGN KEY (author) REFERENCES members(user_id)
);

Insert into qna (title, category, content, author)
values ('글제목', '글종류', '글내용', 'ssafy');

Insert into qna (title, category, content, author)
values ('글제목2', '글종류2', '글내용2', 'admin');
select *
from qna;