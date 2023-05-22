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

Insert into plan

select * 
from plan;