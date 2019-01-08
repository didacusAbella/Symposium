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
INSERT INTO `user` VALUES 
('Andrea','Andrea','Raiola','a.prova@studenti.unisa.it','b107c980be2fe296119dd0da938d1c0af3d4ea83d037b5d6dd14679c7abc5645','2019-02-06',0,2018),
('Porcaccia','Andrea','Raiola','a.raiola15@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,0,2019),
('Andrew','Andrea','AAAAAAAAAA','andry123','7f9ed89c7297f99669b6e79d9d8d404d19f160ca40b40f42896506fa7942786b',NULL,0,NULL),
('Bob907','Bobbby','Bobbby','b.bobbby@studenti.unisa.it','bobbby',NULL,0,2019),
('CBello97','Ciccio','Bello','c.bello@studenti.unisa.it','30bf1d5f129a390adc5fa597871465bcb9cc47e7ff89c3e372c13ee4b0d87a0c',NULL,0,2019),
('cicciolinahorse','cicciolina','nonnehoidea','c.cicciolina@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,0,NULL),
('didacus','Diego','Avella','d.avella5@studenti.unisa.it','8be4cd8452240adf17a954186c490b6cd2738df7c738b8c3ba770f959a8c0e03',NULL,0,NULL),
('2Deimos','Andrea','Piccali','d.halalala@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,0,2019),
('oromis95','Manola','Tropeano','d.tropeano@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,1,NULL),
('GBella','Marianna','Memoli','m.memoli@studenti.unisa.it','50f98487972c64c392a95ad78a61e3628c7ccd7d16ae179ce12ad8aaac791930',NULL,0,NULL),
('rayman','gianni','de maio','g.demaio24@studenti.unisa.it','61e0e1d9a95cb16a97c8689a9b97c4e310380b5e470605a62ef971a4add23a95',NULL,0,NULL),
('gmadness','Giuseppe','Madonna','G.MADONNA3@studenti.unisa.it','451f4fd58350ea1d56b994333dad6c784d349634705f646e7ce11f6feff697af',NULL,0,NULL),
('Supermario','Balotelli','Mario','m.balotelli@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,0,NULL),
('eldeimos','Andlea','Laiola','p.olcodio@studenti.unisa.it','b03ddf3ca2e714a6548e7495e2a03f5e824eaac9837cd7f159c67b90fb4b7342',NULL,0,2019),
('Memo98171','Sandra','Marchigiano','p.szopian@studenti.unisa.it','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',NULL,0,NULL),
('SDelPiano97','Salvatore','Del Piano','s.delpiano@studenti.unisa.it','2c514fd06a156c3df50cacbbe6eecada59a74b6160795ec927b7f4186b707eef','2019-02-06',0,2018);

INSERT INTO `tag` VALUES 
(21,'esame'),(22,'Is'),
(23,'ferrucci'),
(24,'de prisco'),
(25,'Android'),
(173,'PD'),
(174,'angelo'),
(175,'ACER'),
(176,'diego'),
(177,'pipi'),
(178,'pipipi'),
(179,'domenico'),
(180,'pm'),
(181,'cattivoni'),
(182,'neve'),
(183,'unisa'),
(184,'chiusa'),
(185,'informatica'),
(186,'padre'),
(187,'incinta'),
(188,'jsp'),
(189,'servlet'),
(190,'cibo'),
(191,'vita'),
(192,'amore'),
(193,'mare'),
(194,'sole'),
(195,'rene'),
(196,'pasta'),
(197,'cosa'),
(198,'bene'),
(199,'canto'),
(200,'2019'),
(201,'TSW'),
(202,'ciao');

INSERT INTO `question` VALUES 
(19,'Come superare esame della Ferrucci IS?','1000-10-10','1000-10-10',0,'G.MADONNA3@studenti.unisa.it','Superare Esame IS Ferrucci'),
(21,'Reputate facile esame di Ingegneria del Software?','2019-01-04','2019-01-04',0,'s.delpiano@studenti.unisa.it','IS'),
(28,'Voglio fare la rinuncia agli studi. A chi devo chiedere?','2019-01-05','2019-01-05',1,'s.delpiano@studenti.unisa.it','Rinuncia Studi'),
(29,'Dove si trovano i bagni migliori dell uni?','2019-01-05','2019-01-05',0,'s.delpiano@studenti.unisa.it','pipi'),
(30,'Ho sentito dire che Diego e Domenico sono due cattivoni. Confermate???','2019-01-05','2019-01-05',0,'d.tropeano@studenti.unisa.it','Info PM'),
(50,'Qualcuno scambia CFU di IS per CFU di PD?','2019-01-06','2019-01-06',0,'c.bello@studenti.unisa.it','CFU'),
(51,'Vorrei entrar a far parte del coro.','2019-01-06','2019-01-06',0,'d.tropeano@studenti.unisa.it','Coro'),
(52,'Vendo melanzane.','2019-01-06','2019-01-06',0,'d.tropeano@studenti.unisa.it','Verdura'),
(53,'Secondo voi sono il team member più bello?','2019-01-06','2019-01-06',0,'d.tropeano@studenti.unisa.it','Fashion'),
(54,'Ho sonno. Consigli su dove dormire?','2019-01-06','2019-01-06',0,'g.demaio24@studenti.unisa.it','Riposo'),
(55,'Come mi chiamo?','2019-01-06','2019-01-06',0,'g.demaio24@studenti.unisa.it','Domanda importante'),
(56,'Come faccio a capire se ho matricola pari o dispari?','2019-01-06','2019-01-06',0,'g.demaio24@studenti.unisa.it','Quesito difficile');


INSERT INTO `answer` VALUES 
(6,0,'Non si supera ','2019-01-06','c.cicciolina@studenti.unisa.it',19),
(7,0,'Io non so niente','2019-01-06','d.tropeano@studenti.unisa.it',56),
(8,0,'Si io non li sopporto','2019-01-07','d.tropeano@studenti.unisa.it',30);

INSERT INTO `questiontag` VALUES 
(21,21),
(54,21),
(55,21),
(56,21),
(19,22),(28,22),(19,23),(28,25),(30,176),(29,177),(28,178),(29,178),(30,179),(30,180),(30,181),
(50,196),(51,197),(52,198),(53,199),(54,200),(55,200),(56,200),(54,201),(55,201),(56,201);

INSERT INTO `favorites` VALUES 
('G.MADONNA3@studenti.unisa.it',19),
('c.bello@studenti.unisa.it',29),
('c.bello@studenti.unisa.it',50),
('c.bello@studenti.unisa.it',50),
('c.bello@studenti.unisa.it',56);

INSERT INTO `report` VALUES 
(6,'spam','Non ho capito',2018,19,'s.delpiano@studenti.unisa.it'),
(7,'spam','Non mi piace',2019,21,'G.MADONNA3@studenti.unisa.it'),
(8,'spam','Lo odio',2019,28,'G.MADONNA3@studenti.unisa.it'),
(9,'spam','Ma che vuole',2019,28,'s.delpiano@studenti.unisa.it');

INSERT INTO `stats` VALUES (1,5,4,2019),(2,2,0,2018);

INSERT INTO `statstag` VALUES 
(6,1,21),(4,1,23),(4,1,175),(1,1,176),(2,1,177),(2,1,178),(1,1,179),(1,1,180),(1,1,181),(2,1,182),
(2,1,183),(2,1,184),(1,1,185),(1,1,186),(1,1,187),(3,1,188),(3,1,189),(4,1,190),(3,1,191),(3,1,192),
(2,1,193),(1,1,194),(1,1,195),(2,1,196),(1,1,197),(1,1,198),(1,1,199),(3,1,200),
(3,1,201),(1,1,202),(1,2,176);