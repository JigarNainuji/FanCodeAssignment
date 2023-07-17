insert ignore into mydb.sports (id, name) values (1, 'Cricket');
insert ignore into mydb.sports (id, name) values (2, 'Football');

insert ignore into mydb.tours (id, name, sportId, startTime, endTime) values (1, 'Indian Premier League, 2023', 1, '2023-04-09 00:00:00', '2023-05-30 00:00:00');
insert ignore into mydb.tours (id, name, sportId, startTime, endTime) values (2, 'India Super League, 2023', 2, '2023-04-21 00:00:00', '2023-06-20 00:00:00');
insert ignore into mydb.tours (id, name, sportId, startTime, endTime) values (3, 'India Tour of West Indies, 2023', 1, '2023-06-10 00:00:00', '2023-06-29 00:00:00');
insert ignore into mydb.tours (id, name, sportId, startTime, endTime) values (4, 'English Premier League, 2022', 2, '2022-04-09 00:00:00', '2022-05-30 00:00:00');

insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (1,'GT vs RCB', 1, 'T20', '2023-04-09 18:00:00', '2023-04-09 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (2,'CSK vs MI', 1, 'T20', '2023-04-10 18:00:00', '2021-04-10 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (3,'LSG vs KXIP', 1, 'T20', '2023-04-11 18:00:00', '2023-04-11 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (4,'RR vs SRH', 1, 'T20', '2023-04-12 18:00:00', '2023-04-12 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (5,'BLR vs BEN', 2, 'soccer', '2023-04-29 18:00:00', '2023-04-29 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (6,'ATK vs MCFC', 2, 'soccer', '2023-04-21 18:00:00', '2023-04-21 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (7,'KER vs JFC', 2, 'soccer', '2023-04-22 18:00:00', '2023-04-22 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (8,'IND vs WI', 3, 'ODI', '2023-06-10 10:00:00', '2023-06-10 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (9,'IND vs WI', 3, 'ODI', '2023-06-12 10:00:00', '2023-06-12 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (10,'IND vs WI', 3, 'ODI', '2023-06-14 10:00:00', '2023-06-14 23:00:00');
insert ignore into mydb.matches (id,name, tourId, format, startTime, endTime) values (11,'KER vs JFC', 4, 'soccer', '2022-04-09 18:00:00', '2022-04-09 23:00:00');

insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (1,'ABC','abc',1,1,1);
insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (2,'BCD','bcd',null,1,1);
insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (3,'hdkdkd','jkhsdf',5,2,2);
insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (4,'jhsdfg','dsfg',null,2,2);
insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (5,'fbgls','sdgjh',4,1,1);
insert ignore into mydb.news (id,title,description,matchId,tourId,sportId) values (6,'ABC','abc',2,4,1);