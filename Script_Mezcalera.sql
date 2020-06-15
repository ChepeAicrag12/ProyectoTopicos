﻿create schema Mezcal authorization postgres;
set search_path to Mezcal;

create table Maguey(
 id_maguey serial primary key,
 nombre varchar(30),
 cantidadPinia serial
);

create table Cortador(
 id_cortador serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Horno(
 id_horno serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Molino(
 id_molino serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Fermentador(
 id_fermentador serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Destilador(
 id_destilador serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Enbotelladora(
 id_enbotelladora serial primary key,
 nombre varchar(30),
 estado varchar(30)
);

create table Transportista(
 id_transportista serial primary key,
 nombre varchar(30),
 modelo_trailer varchar(30)
);

create table Cliente(
 id_cliente serial primary key,
 nombre varchar(30),
 razon_social varchar(30)
);

create table gradoAlcohol(
 id_grado serial primary key,
 valor float
);

create table tipoMezcal(
id_tipo serial primary key,
nombre varchar(20)
);

create table Tanda(
 id_tanda serial primary key,
 tipoMaguey serial references Maguey(id_maguey),
 gradoAlcohol serial references gradoAlcohol(id_grado),
 tipoMezcal serial references tipoMezcal(id_tipo),
 cantidadPinias serial,
 status varchar(20),
 id_cortador serial references Cortador(id_cortador),
 id_horno serial references Horno(id_horno),
 id_molino serial references Molino(id_molino),
 id_fermentador serial references Fermentador(id_fermentador),
 id_destilador serial references Destilador(id_destilador),
 id_enbotelladora serial references Enbotelladora(id_enbotelladora),
 id_cliente serial references Cliente(id_cliente),
 fecha_inicio timestamp with time zone,
 fecha_final timestamp with time zone,
 id_transportista serial references Transportista(id_transportista)
 );

 insert into mezcal.maguey (nombre, cantidadPinia) values 
	('Azul',1000),('Cenizo',1000),('Coyote',1000),('Cuishe',1000),
        ('Espadín',1000),('Mexicano',1000),('Papalote',1000),('Tobalá',1000),
        ('Arroqueño',1000),('Jabalí',1000),('Madre Cuishe',1000),('Tepextate',1000); 

insert into mezcal.cliente (nombre,razon_social)values
	('Pedro','Grupo Modesto'),('Juan','Mezcal Chahue'),('Edgar','Grupo San Juan'),
	('Alex','Costa Sur'),('Kevin','Grupo Divisa');

insert into mezcal.cortador (nombre, estado) values
	('Cortador 1','Libre'),('Cortador 2','Libre'),('Cortador 3','Libre');

insert into mezcal.horno (nombre, estado) values
	('Horno 1','Libre'),('Horno 2','Libre'),('Horno 3','Libre');

insert into mezcal.molino (nombre, estado) values
	('Molino 1','Libre'),('Molino 2','Libre'),('Molino 3','Libre');

insert into mezcal.fermentador (nombre, estado) values
	('Fermentador 1','Libre'),('Fermentador 2','Libre'),('Fermentador 3','Libre');
	
insert into mezcal.destilador (nombre, estado) values
	('Destilador 1','Libre'),('Destilador 2','Libre'),('Destilador 3','Libre');	

insert into mezcal.enbotelladora (nombre, estado) values
	('Enbotelladora 1','Libre'),('Enbotelladora 2','Libre'),('Enbotelladora 3','Libre');

insert into mezcal.transportista (nombre, modelo_trailer) values
	('Sergio','Kenworth W990'),('Melvin','Dina 800'),('Eli','Hyundai');
	
insert into mezcal.gradoalcohol (grado) values (55.0),(48.0),(37.0);			

insert into mezcal.tipomezcal (nombre) values ('Añejo'),('Reposado'),('Maduro'),('Blanco');			
				