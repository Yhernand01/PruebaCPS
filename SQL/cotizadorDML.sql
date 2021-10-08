use cotizador
go
insert into env.region (nombre,tarifa_dolar)
	values ('Norte am�rica', 2),
		   ('Asia',3.3),
		   ('Ocean�a',3),
		   ('�frica',2),
		   ('Suram�rica',1.75),
		   ('Centroam�rica',1.20)
go
insert into env.pais (id_region,nombre)
	values(1,'USA'),
		  (1,'Canad�'),
		  (2,'China'),
		  (2,'Jap�n'),
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
		  (11,'YH001','Yelsyn Hern�ndez',4)