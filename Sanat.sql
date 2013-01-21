drop table if exists Sanat;
drop table if exists Kategoriat;


create table Sanat (
	suomeksi varchar(30),
	ruotsiksi varchar(30),
        infinitiv varchar(30),
	primary key (suomeksi)
);

create table Kategoriat (
	id int auto_increment,
	sana varchar(30),
	primary key (id)
);



insert into Sanat values('arvostelu', 'bedömmning, kritik','arvostelu');
insert into Sanat values('puolustaa', 'försvara, rättfärdiga','puolustaa');
insert into Sanat values('hetkauttaa', 'rubba, flytta','hetkauttaa');
insert into Sanat values('portugalilaisluotsi', 'lots, lotsen','luotsi');
insert into Sanat values('ettei', 'att, inte','että ei');


insert into Kategoriat values(0,'Uutiset');
insert into Kategoriat values(0,'Viihde');
insert into Kategoriat values(0,'Urheilu');
insert into Kategoriat values(0,'Sää');
insert into Kategoriat values(0,'Lifestyle');

