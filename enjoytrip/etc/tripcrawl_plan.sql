use `tripcrawl`; 

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000),
  `start_date` date,
  `end_date` date,
  `user_id` VARCHAR(20),
  `hit` INT,
  `theme` varchar(20),
  PRIMARY KEY (`plan_id`),
  FOREIGN KEY (user_id) REFERENCES members(user_id) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

