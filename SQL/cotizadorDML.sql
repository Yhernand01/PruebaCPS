use cotizador
go
insert into env.region (nombre,tarifa_dolar)
	values ('Norte américa', 2),
		   ('Asia',3.3),
		   ('Oceanía',3),
		   ('África',2),
		   ('Suramérica',1.75),
		   ('Centroamérica',1.20)
go
insert into env.pais (id_region,nombre)
	values(1,'USA'),
		  (1,'Canadá'),
		  (2,'China'),
		  (2,'Japón'),
		  (3,'Australia'),
		  (3,'Nueva Zelanda'),
		  (4,'Kenia'),
		  (4,'Tanzania'),
		  (5,'Colombia'),
		  (5,'Chile'),
		  (6,'Guatemala'),
		  (6,'El Salvador'),
		  (6,'Honduras')
go
insert into env.cliente(id_pais_origen,codigo,nombre,valor_descuento)
	values(11,'JH2021','Juan Herrera',2),
		  (11,'PO2111','Pedro Ortega',3),
		  (11,'YH001','Yelsyn Hernández',4)