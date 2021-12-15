CREATE TABLE IF NOT EXISTS gira_role(
	id bigint,
	version int not null,
	name varchar(255) not null UNIQUE,
	description varchar(255) not null,
	code varchar(10) not null UNIQUE,
	created_by varchar(36) not null,
	created_at timestamp not null,
	updated_by varchar(36) not null,
	updated_at timestamp not null,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS gira_group_role(
	id bigint,
	version int not null,
	name varchar(255) not null UNIQUE,
	description varchar(255) not null,
	code varchar(10) not null UNIQUE,
	created_by varchar(36) not null,
	created_at timestamp not null,
	updated_by varchar(36) not null,
	updated_at timestamp not null,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS gira_role_group_role(
	role_id bigint,
	group_role_id bigint,
	primary key(role_id, group_role_id)
);

ALTER TABLE gira_role_group_role
ADD CONSTRAINT fk_role 
	FOREIGN KEY (role_id) REFERENCES gira_role(id);
ALTER TABLE gira_role_group_role
ADD CONSTRAINT fk_group_role
	FOREIGN KEY (group_role_id) REFERENCES gira_group_role(id);