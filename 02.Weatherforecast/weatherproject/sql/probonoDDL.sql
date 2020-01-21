DROP TABLE WEATHER;

CREATE sequence weather_number;

CREATE TABLE WEATHER(
	weather_number number(7),
	region varchar2(20) ,
	day  varchar2(20),
	avgTemp number(4,1),
	maxTemp number(4,1),
	minTemp number(4,1),
	clouds number(3,1),
	precipitation number(4,1)
);

drop table clients;
drop sequence client_id;
create sequence client_id;

Create table clients(
client_id number(3),
name varchar2(10),
SSN varchar2(20),
region varchar2(10),
registerday varchar2(20),
grade varchar2(10)
);


drop table price;

create table price(
grade varchar2(10),
price Number(10)
);