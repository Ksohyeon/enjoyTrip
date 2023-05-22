use tripcrawl;
DROP TABLE IF EXISTS `place`;

CREATE TABLE place (
	no int auto_increment PRIMARY KEY,
	lat VARCHAR(32) NOT NULL,
	lon VARCHAR(32) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    hit INT NOT NULL,
    date DATE NOT NULL ,
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    image VARCHAR(256),
    author VARCHAR(20) NOT NULL,
    FOREIGN KEY (author) REFERENCES members(user_id)
);

insert into place (lat, lon, title, content, hit, date, image, author) 
values ('37.44168677000000000','127.05436760000000000','청계산','내용', 0, now(), 'http://tong.visitkorea.or.kr/cms/resource/41/2023841_image2_1.jpg', 'ssafy');

insert into place (lat, lon, title, content, hit, date, image, author) 
values ('37.44840364000000000','126.95409880000000000','관악산','내용2', 0, now(), 'http://tong.visitkorea.or.kr/cms/resource/30/1857230_image2_1.jpg', 'admin');

select * from place;