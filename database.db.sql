BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Test" (
	"id"	INTEGER,
	"Column1"	TEXT,
	"Column2"	REAL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "clientes" (
	"cedula"	TEXT NOT NULL,
	"nombres"	TEXT NOT NULL,
	"apellidos"	TEXT NOT NULL,
	"sexo"	TEXT NOT NULL,
	"fecha_nacimiento"	TEXT NOT NULL,
	"correo_electronico"	TEXT NOT NULL,
	"telefono"	TEXT NOT NULL,
	"nombre_contacto"	TEXT NOT NULL,
	"telefono_contacto"	TEXT NOT NULL,
	"direccion"	TEXT NOT NULL,
	PRIMARY KEY("cedula")
);
CREATE TABLE IF NOT EXISTS "clientes_actividades" (
	"id_actividad"	INTEGER,
	"ci_cliente"	TEXT,
	FOREIGN KEY("id_actividad") REFERENCES "actividades"("id") ON DELETE CASCADE,
	FOREIGN KEY("ci_cliente") REFERENCES "clientes"("cedula") ON DELETE CASCADE,
	PRIMARY KEY("id_actividad","ci_cliente")
);
CREATE TABLE IF NOT EXISTS "actividades" (
	"id"	TEXT,
	"nombre"	TEXT NOT NULL,
	"descripcion"	TEXT,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "horarios_actividades" (
	"hora_inicio"	TEXT,
	"hora_fin"	TEXT,
	"actividad"	TEXT NOT NULL,
	"ficha"	TEXT,
	"dia"	INTEGER NOT NULL DEFAULT 1,
	FOREIGN KEY("actividad") REFERENCES "actividades"("id"),
	FOREIGN KEY("ficha") REFERENCES "ficha_cliente"("ID")
);
CREATE TABLE IF NOT EXISTS "ficha_cliente" (
	"ID"	TEXT NOT NULL,
	"cliente"	TEXT NOT NULL UNIQUE,
	"peso"	REAL NOT NULL,
	"altura"	REAL NOT NULL,
	"fecha_inicio"	TEXT NOT NULL,
	"ultima_asistencia"	TEXT,
	"esta_activo"	INTEGER NOT NULL DEFAULT -1,
	PRIMARY KEY("ID")
);
CREATE TABLE IF NOT EXISTS "usuarios" (
	"usuario"	TEXT,
	"contrasenia"	TEXT NOT NULL,
	"rol"	TEXT NOT NULL,
	PRIMARY KEY("usuario")
);

CREATE TABLE IF NOT EXISTS "fechas_especiales" (
                                                   "id"	INTEGER,
                                                   "dia"	INTEGER,
                                                   "mes"	INTEGER,
                                                   "descripcion"	TEXT
);

INSERT INTO "clientes" VALUES ('1750105585','Kenneth Leonardo','Ulloa Tobar','M','03-07-2000','greenlantern0@hotmail.com','0987175255','Pablo','0987353846','Av. La Bota');
INSERT INTO "actividades" VALUES ('ac1','Fortalecimiento Muscular','Levantamiento de peso para tonificar la masa muscular.');
INSERT INTO "actividades" VALUES ('ac2','Crossfit','Serie de ejercicios para mejorar el sistema circulatorio, respiratorio y fuerza física.');
INSERT INTO "horarios_actividades" VALUES ('09:00','11:00','ac2','F1750105585',5);
INSERT INTO "horarios_actividades" VALUES ('08:00','10:00','ac1','F1750105585',1);
INSERT INTO "ficha_cliente" VALUES ('F1750105585','1750105585',60.0,165.2,'03-01-2023','05-01-2023',1);
INSERT INTO "fechas_especiales" VALUES ('f1',20,2,'Carnaval');
INSERT INTO "fechas_especiales" VALUES ('f2',21,2,'Carnaval');
INSERT INTO "fechas_especiales" VALUES ('f3',7,4,'Viernes Santo');
INSERT INTO "fechas_especiales" VALUES ('f4',1,5,'Dia del Trabajo');
INSERT INTO "fechas_especiales" VALUES ('f5',2,11,'Dia de Difuntos');
INSERT INTO "fechas_especiales" VALUES ('f6',25,12,'Navidad');
INSERT INTO "fechas_especiales" VALUES ('f7',31,12,'Fin de Año');
INSERT INTO "usuarios" VALUES ('mario','1234','USUARIO');
INSERT INTO "usuarios" VALUES ('jose','1234','ADMINISTRADOR');
INSERT INTO "usuarios" VALUES ('kenneth','1234','ADMINISTRADOR');
COMMIT;
