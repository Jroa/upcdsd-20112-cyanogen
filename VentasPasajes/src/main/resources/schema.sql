drop table usuario if exists;
create table usuario (
  codUsuario varchar(30),
  nomUsuario varchar(30),
  apepatUsuario varchar(30),
  apematUsuario varchar(30),
  numDocumento varchar(10),
  email varchar(30),
  password varchar(30),
  constraint usuario_pk primary key(codUsuario)
);

drop table agencia if exists;
create table agencia
(
	idAgencia integer primary key identity,
	nombre varchar(50),
	direccion varchar(50)
);

drop table bus if exists;
create table bus(
	idBus integer primary key identity,
	placa varchar(20),
	numAsiento integer,
	estado integer
);

drop table viaje if exists;
create table viaje(
	idViaje integer primary key identity,
	idAgenciaOrigen integer,
	idAgenciaDestino integer,
	idBus integer,
	fecha date,
	hora timestamp,
	costo double,
);


drop table asiento if exists;
create table asiento(
	idAsiento integer primary key identity,
	idViaje integer,
	codUsuario varchar(30),
	numAsiento integer,
	estado integer
);

drop table boleto if exists;
create table boleto(
	idBoleto integer primary key,
	fecha date,
	monto double,
	idAsiento integer
);




