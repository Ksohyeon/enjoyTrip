use `tripcrawl`; 
DROP TABLE IF EXISTS chat;



create table `chat` (
	`chat_id` int not null auto_increment primary key,
	`user_id` varchar(20) not null,
    `message` varchar(200) not null,
    `send_at` datetime not null default (current_date()),
    `sido_code` int not null,
    FOREIGN KEY (`user_id`) REFERENCES members(user_id) ON DELETE CASCADE,
    FOREIGN KEY (`sido_code`) REFERENCES sido(sido_code) ON DELETE CASCADE
);

