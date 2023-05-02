
use tripcrawl;
drop table if exists members;

CREATE TABLE members (
	user_id VARCHAR(20) PRIMARY KEY,	
	user_name VARCHAR(20) NOT NULL,
	user_password VARCHAR(256) NOT NULL,
    email_id VARCHAR(20) NOT NULL,
    email_domain VARCHAR(20) NOT NULL,
    join_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    admin boolean NOT NULL default false
);

Insert into members (user_id, user_name, user_password, email_id, email_domain)
values ('ssafy', '김싸피', 'ssafy', 'ssafy', 'ssafy');

Insert into members (user_id, user_name, user_password, email_id, email_domain, admin)
values ('admin', '김관리', 'admin', 'admin', 'admin', true);
