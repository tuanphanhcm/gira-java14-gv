CREATE TABLE IF NOT EXISTS gira_role(
	id uuid,
	version int not null,
	name varchar(255) not null UNIQUE,
	description varchar(255) not null,
	code varchar(10) not null UNIQUE,
	created_by varchar(36),
	created_at timestamp,
	updated_by varchar(36),
	updated_at timestamp,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS gira_group_role(
	id uuid,
	version int not null,
	name varchar(255) not null UNIQUE,
	description varchar(255) not null,
	code varchar(10) not null UNIQUE,
	created_by varchar(36),
	created_at timestamp,
	updated_by varchar(36),
	updated_at timestamp,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS gira_role_group_role(
	role_id uuid,
	group_role_id uuid,
	primary key(role_id, group_role_id)
);

CREATE sequence hibernate_sequence start 1 increment 1;

ALTER TABLE gira_role_group_role
ADD CONSTRAINT fk_role 
	FOREIGN KEY (role_id) REFERENCES gira_role(id);
ALTER TABLE gira_role_group_role
ADD CONSTRAINT fk_group_role
	FOREIGN KEY (group_role_id) REFERENCES gira_group_role(id);