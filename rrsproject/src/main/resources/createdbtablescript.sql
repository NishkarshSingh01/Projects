if not exists(select * from sys.databases where name='rrs')
begin
	create database rrs;
end 
go
 use rrs;
go
if not exists(select * from sysobjects where name='login' and xtype='U')
begin
	create table login (
	email varchar(255) primary key,
	password varchar(255) not null,
	cpassword varchar(255) not null
	)
end 