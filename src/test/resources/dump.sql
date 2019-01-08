create table if not exists admin
(
	id int auto_increment primary key,
	username varchar(20) not null,
	password varchar(45) not null
) charset=utf8;

create table if not exists stats
(
	id int auto_increment primary key,
	numSigned int null,
	totalReports int null,
	year int null
) charset=utf8;

create table if not exists tag
(
	id int auto_increment primary key,
	name varchar(30) not null
) charset=utf8;

create table if not exists statstag
(
	uses int default 0 not null,
	statsId int auto_increment,
	tagId int not null,
	primary key (statsId, tagId),
	constraint statstag_stats_id
		foreign key (statsId) references stats (id),
	constraint statstag_tag_id
		foreign key (tagId) references tag (id)
) charset=utf8;

create table if not exists user
(
	username varchar(45) not null,
	firstName varchar(45) not null,
	lastName varchar(45) not null,
	email varchar(45) not null
		primary key,
	password varchar(64) not null,
	banLastDate date null,
	typeGrad tinyint(1) null,
	year int null
) charset=utf8;

create table if not exists question
(
	id int auto_increment
		primary key,
	content varchar(200) not null,
	lastUpdate date not null,
	creationDate date not null,
	numReports int default 0 not null,
	userFk varchar(45) not null,
	title varchar(30) not null,
	constraint question_user_email_fk
		foreign key (userFk) references user (email)
			on update cascade on delete cascade
) charset=utf8;

create table if not exists answer
(
	id int auto_increment
		primary key,
	correct tinyint(1) default 0 null,
	content varchar(4096) not null,
	creationDate date not null,
	userFk varchar(45) not null,
	questionFk int not null,
	constraint answer_question_id_fk
		foreign key (questionFk) references question (id)
			on update cascade on delete cascade,
	constraint answer_user_email_fk
		foreign key (userFk) references user (email)
) charset=utf8;

create table if not exists favorites
(
	userId varchar(45) not null,
	questionId int not null,
	constraint favorites_question_id_fk
		foreign key (questionId) references question (id)
			on update cascade on delete cascade,
	constraint favorites_user_email_fk
		foreign key (userId) references user (email)
) charset=utf8;

create table if not exists questiontag
(
	questionId int not null,
	tagId int not null,
	primary key (questionId, tagId),
	constraint questiontag_question_id_fk
		foreign key (questionId) references question (id)
			on update cascade on delete cascade,
	constraint questiontag_tag_id_fk
		foreign key (tagId) references tag (id)
			on update cascade on delete cascade
) charset=utf8;

create table if not exists report
(
	id int auto_increment
		primary key,
	category varchar(45) not null,
	reason varchar(45) not null,
	year int not null,
	questionFk int not null,
	userFk varchar(45) not null,
	constraint report_question_id_fk
		foreign key (questionFk) references question (id),
	constraint report_user_email_fk
		foreign key (userFk) references user (email)
) charset=utf8;

INSERT INTO admin (username, password) VALUES ('Supergoku', 'P@ssw0rd');