use [master]
go
declare @db nvarchar(128) = N'cotizador'

if not exists (select name 
				from master.dbo.sysdatabases 
				where ('[' + name + ']' = @db
				or name = @db))
	create database cotizador
go
use cotizador;
go

if not exists(select * from sys.schemas where name = 'env')
	exec('create schema env')
go
if OBJECT_ID('env.cliente','U') is not null drop table env.cliente
if OBJECT_ID('env.pais','U') is not null drop table env.pais
if OBJECT_ID('env.region','U') is not null drop table env.region

go
create table env.region(
	id_region int identity(1,1),
	nombre varchar(40) not null,
	tarifa_dolar decimal(5,2) not null,
	constraint pk_region
		primary key(id_region)
)
go
create table env.pais(
	id_pais int identity(1,1),
	id_region int not null,
	nombre varchar(40) not null,
	constraint pk_pais
		primary key(id_pais),
	constraint fk_region_pais
		foreign key (id_region) references env.region(id_region)
)
go
create table env.cliente(
	id_cliente int identity(1,1),
	id_pais_origen int not null,
	codigo varchar(6) not null,
	nombre varchar(40) not null,
	valor_descuento decimal(5,2) not null,
	constraint pk_cliente
		primary key (id_cliente),
	constraint fk_pais_cliente
		foreign key (id_pais_origen) references env.pais(id_pais)
)