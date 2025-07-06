-- DDL to create schema used in Simulated-CLI-Portfolio

drop schema CLI_PORTFOLIO;
create schema CLI_PORTFOLIO;

use CLI_PORTFOLIO;

create table category(
	id INT auto_increment primary key,
	skill VARCHAR(100) not null unique
);
CREATE INDEX idx_category_skill ON category(skill);

create table project(
	id INT auto_increment primary key,
	name_pt VARCHAR(100) not null,
	name_en VARCHAR(100) not null,
	description_pt TEXT,
	description_en TEXT,
	url VARCHAR(500)
);
CREATE INDEX idx_project_name_pt ON project(name_pt);
CREATE INDEX idx_project_name_en ON project(name_en);

create table project_category(
	project_id INT not null,
	category_id INT not null,
	primary key(project_id, category_id),
	foreign key(project_id) references project(id) on update cascade on delete cascade,
	foreign key(category_id) references category(id) on update cascade on delete cascade
);

create table certificate(
	id INT auto_increment primary key,
	name_pt VARCHAR(100) not null,
	name_en VARCHAR(100) not null,
	organization VARCHAR(100) not null,
	issue_date DATE,
	expiration_date DATE,
	description_pt TEXT,
	description_en TEXT,
	code VARCHAR(500) unique,
	url VARCHAR(500) unique,
	CHECK (expiration_date IS NULL OR issue_date <= expiration_date)
);
CREATE INDEX idx_certificate_name_pt ON certificate(name_pt);
CREATE INDEX idx_certificate_name_en ON certificate(name_en);
CREATE INDEX idx_certificate_code ON certificate(code);


create table certificate_category(
	certificate_id INT not null,
	category_id INT not null,
	primary key(certificate_id, category_id),
	foreign key(certificate_id) references certificate(id) on update cascade on delete cascade,
	foreign key(category_id) references category(id) on update cascade on delete cascade
);

create table academic(
	id INT auto_increment primary key,
	course_pt VARCHAR(100) not null,
	course_en VARCHAR(100) not null,
	organization VARCHAR(100) not null,
	start_date DATE not null,
	end_date DATE,
	status ENUM('ONGOING', 'COMPLETED', 'PAUSED') NOT null,
	CHECK (end_date IS NULL OR start_date <= end_date)
);
CREATE INDEX idx_academic_course_pt ON academic(course_pt);
CREATE INDEX idx_academic_course_en ON academic(course_en);
CREATE INDEX idx_academic_organization ON academic(organization);
CREATE INDEX idx_academic_status ON academic(status);

create table work_experience(
	id INT auto_increment primary key,
	company VARCHAR(100) not null,
	company_url VARCHAR(500),
	start_date DATE not null,
	end_date DATE,
	role_pt VARCHAR(100) not null,
	role_en VARCHAR(100) not null,
	location VARCHAR(500),
	is_current BOOLEAN default false,
	description_pt TEXT,
	description_en TEXT,
	CHECK (end_date IS NULL OR start_date <= end_date)
);
CREATE INDEX idx_work_company ON work_experience(company);
CREATE INDEX idx_work_role_en ON work_experience(role_en);

create table work_experience_category(
	work_experience_id INT not null,
	category_id INT not null,
	primary key(work_experience_id, category_id),
	foreign key(work_experience_id) references work_experience(id) on update cascade on delete cascade,
	foreign key(category_id) references category(id) on update cascade on delete cascade
);

create table language(
  	id INT auto_increment primary key,
  	name_pt VARCHAR(100) not null unique,
  	name_en VARCHAR(100) not null unique,
  	level_reading 	ENUM('BASIC', 'INTERMEDIATE', 'ADVANCED') NOT NULL,
	level_writing 	ENUM('BASIC', 'INTERMEDIATE', 'ADVANCED') NOT NULL,
	level_speaking 	ENUM('BASIC', 'INTERMEDIATE', 'ADVANCED') NOT NULL
);
CREATE INDEX idx_language_name_pt ON language(name_pt);
CREATE INDEX idx_language_name_en ON language(name_en);
CREATE INDEX idx_language_level_reading ON language(level_reading);
CREATE INDEX idx_language_level_writing ON language(level_writing);
CREATE INDEX idx_language_level_speaking ON language(level_speaking);


create table knowledge(
  	id INT auto_increment primary key,
  	name_pt VARCHAR(100) not null unique,
  	name_en VARCHAR(100) not null unique,
  	level ENUM('BASIC', 'INTERMEDIATE', 'ADVANCED') NOT null,
  	url VARCHAR(500)
);
CREATE INDEX idx_knowledge_name_pt ON knowledge(name_pt);
CREATE INDEX idx_knowledge_name_en ON knowledge(name_en);
CREATE INDEX idx_knowledge_level ON knowledge(level);


create table knowledge_category(
  	knowledge_id INT not null,
	category_id INT not null,
	primary key(knowledge_id, category_id),
	foreign key(knowledge_id) references knowledge(id) on update cascade on delete cascade,
	foreign key(category_id) references category(id) on update cascade on delete cascade
);

create table profile(
	id INT auto_increment primary key,
	name VARCHAR(100) not null,
	title_pt VARCHAR(100) not null,
	title_en VARCHAR(100) not null,
	bio_pt TEXT,
	bio_en TEXT,
	email VARCHAR(255) not null,
	phone VARCHAR(30) not null,
	location VARCHAR(100) not null,
	linkedin VARCHAR(500) not null,
	github VARCHAR(500) not null,
	cv_pt_url VARCHAR(500) not null,
	cv_en_url VARCHAR(500) not null
);

create table link(
	id INT auto_increment primary key,
	name VARCHAR(100) not null,
	url VARCHAR(500) not null
);
CREATE INDEX idx_link_name ON link(name);

commit;
