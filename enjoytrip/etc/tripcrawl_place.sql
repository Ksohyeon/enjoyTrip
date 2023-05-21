use tripcrawl;
DROP TABLE IF EXISTS `place`;

CREATE TABLE place (
	no int PRIMARY KEY,	
	user_id VARCHAR(20) NOT NULL,
	lat VARCHAR(32) NOT NULL,
	lon VARCHAR(32) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    hit INT NOT NULL,
    date DATE NOT NULL ,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    image VARCHAR(256)
);

insert into `place` values (1, 'asdf', '위','아래','제목','내용', 1, now(), now(), '그림');

select * from place;