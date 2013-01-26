drop table if exists KategorinSanat;
drop table if exists Sanat;
drop table if exists Kategoriat;



create table Sanat (
	infinitiv varchar(30) not null,
	suomeksi varchar(30),
        ruotsiksi varchar(30),
	primary key (infinitiv)
);

create table Kategoriat (
	id int auto_increment not null,
	nimi varchar(30),
	primary key (id)
);
create table KategorinSanat (
	id int auto_increment not null,
	sana varchar(30) not null,
	primary key(id, sana),
	foreign key (id) references Kategoriat(id),
	foreign key (sana) references Sanat(infinitiv)
);



INSERT INTO `Sanat` (`infinitiv`, `suomeksi`, `ruotsiksi`) VALUES
('arvostelu', 'arvostelu', 'bedömmning, kritik'),
('että ei', 'ettei', 'att, inte'),
('hetkauttaa', 'hetkauttaa', 'rubba, flytta'),
('luotsi', 'portugalilaisluotsi', 'lots, lotsen'),
('luvata', 'luvataan', 'lova'),
('murha', 'murhista', 'mord'),
('puolustaa', 'puolustaa', 'försvara, rättfärdiga'),
('ruokavalio', 'ruokavalioonsa', 'utomlands'),
('ulkomaa', 'ulkomaille', 'utomlands'),
('viihde', 'viihde', 'förströelse, underhållning');


insert into Kategoriat values(1,'Uutiset');
insert into Kategoriat values(2,'Viihde');
insert into Kategoriat values(3,'Urheilu');
insert into Kategoriat values(4,'Sää');
insert into Kategoriat values(5,'Lifestyle');


INSERT INTO `KategorinSanat` (`id`, `sana`) VALUES
(3, 'arvostelu'),
(3, 'että ei'),
(3, 'hetkauttaa'),
(3, 'luotsi'),
(4, 'luvata'),
(1, 'murha'),
(3, 'puolustaa'),
(5, 'ruokavalio'),
(4, 'ulkomaa'),
(2, 'viihde');

