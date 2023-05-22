use `tripcrawl`; 

DROP TABLE IF EXISTS `plan_places`;
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` date NOT NULL default (CURRENT_DATE),
  `user_id` VARCHAR(20) NOT NULL,
  `hit` INT default (0),
  `theme` varchar(20),
  PRIMARY KEY (`plan_id`),
  FOREIGN KEY (user_id) REFERENCES members(user_id) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE plan_places (
	plan_places_id INT NOT NULL AUTO_INCREMENT,
    content_id INT NOT NULL,
    plan_id INT NOT NULL,
    place_order INT NOT NULL,
    PRIMARY KEY (`plan_places_id`),
    FOREIGN KEY (content_id) REFERENCES attraction_info(content_id) ON DELETE CASCADE,
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id) ON DELETE CASCADE
);

Insert into plan (title, content, start_date, end_date, user_id, theme)
values ('첫 계획', '여기저기 가는계획', '2023-05-22','2023-05-25', 'ssafy', '친구와 여행');

Insert into plan (title, content, start_date, end_date, user_id, theme)
values ('두번째 계획', '여기저기 가는계획2', '2023-03-22','2023-06-25', 'ssafy', '가족과 여행');

Insert into plan_places (content_id, plan_id, place_order)
values (125405, 1, 1);

Insert into plan_places (content_id, plan_id, place_order)
values (125406, 1, 3);

Insert into plan_places (content_id, plan_id, place_order)
values (125407, 1, 2);

select pp.plan_id, pp.content_id, a.first_image, a.title, a.addr1, a.latitude, a.longitude, ad.overview, pp.place_order
from plan_places pp
join attraction_info a on a.content_id = pp.content_id
join attraction_description ad on a.content_id = ad.content_id
where pp.plan_id = 11
order by pp.place_order;

select *
from plan;

select *
from plan_places;

update plan
set hit = hit+1
where plan_id=1;

select p.plan_id, p.title, p.content, p.start_date, p.end_date, p.created_at, p.hit, p.theme, m.user_id, m.nickname
from plan p
join members m on p.user_id = m.user_id
order by plan_id desc;

select p.plan_id, p.title, p.content, p.start_date, p.end_date, p.created_at, p.hit, p.theme, m.user_id, m.nickname
from plan p
join members m on p.user_id = m.user_id
where p.plan_id = 1;

