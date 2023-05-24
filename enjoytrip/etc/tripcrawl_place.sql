use tripcrawl;
DROP TABLE IF EXISTS `place`;

CREATE TABLE place (
	no int auto_increment PRIMARY KEY,
	lat VARCHAR(32) NOT NULL,
	lon VARCHAR(32) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    hit INT NOT NULL default 0,
    date DATE NOT NULL ,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    image VARCHAR(256),
    author VARCHAR(20) NOT NULL,
    FOREIGN KEY (author) REFERENCES members(user_id)
);

select * from place;