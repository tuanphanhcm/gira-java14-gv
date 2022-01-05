create table gira_user (
	id 							bigint,
	version 				int not null,
	created_by 			varchar(36),
	created_at 			timestamp,
	updated_by 			varchar(36),
	updated_at 			timestamp,
	username 				varchar(36) not null unique,
	password 				varchar(255) not null,
	email 					varchar(100) not null unique,
	fullname 				varchar(255) not null,
	display_name 		varchar(100),
	avatar 					varchar(255),
	account_status 	varchar(100),
	facebook_url 		varchar(255),
	title 					varchar(100),
	department 			varchar(100),
	hobbies 				varchar(255),
	primary key(id)
);

create table gira_group_role_user (
	user_id 			bigint,
	group_role_id bigint,
	primary key(user_id, group_role_id)
);

alter table gira_group_role_user
	add constraint fk_group_role_user 
	foreign key (user_id) references gira_user (id);
alter table gira_group_role_user
	add constraint fk_user_group_user
	foreign key (group_role_id) references gira_group_role (id);