create database cross_platform_lab5;
go

use cross_platform_lab5;
go

create table Students (
	MSSV nvarchar(10) primary key,
	hoTen nvarchar(100),
	ngaySinh nvarchar(20),
	lop nvarchar(20)
)