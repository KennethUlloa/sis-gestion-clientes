use sis_gestion_cli;
CREATE TABLE IF NOT EXISTS Test (
                                    id	INT,
                                    Column1	VARCHAR(30),
                                    Column2	VARCHAR(30),
                                    PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS clientes (
                                        cedula	varchar(10) NOT NULL,
                                        nombres	varchar(255) NOT NULL,
                                        apellidos	varchar(255) NOT NULL,
                                        sexo	char(1) NOT NULL,
                                        fecha_nacimiento	varchar(255) NOT NULL,
                                        correo_electronico	varchar(255) NOT NULL,
                                        telefono	varchar(255) NOT NULL,
                                        nombre_contacto	varchar(255) NOT NULL,
                                        telefono_contacto	varchar(255) NOT NULL,
                                        direccion	varchar(255) NOT NULL,
                                        PRIMARY KEY(cedula)
);

CREATE TABLE IF NOT EXISTS actividades (
                                           id	varchar(10),
                                           nombre	varchar(255) NOT NULL,
                                           descripcion	varchar(255),
                                           PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS ficha_cliente (
                                             ID	varchar(20) NOT NULL,
                                             cliente	varchar(20) NOT NULL UNIQUE,
                                             peso	float(6,2) NOT NULL,
                                             altura	float(6,2) NOT NULL,
                                             fecha_inicio	varchar(10) NOT NULL,
                                             ultima_asistencia	varchar(10),
                                             esta_activo	tinyint NOT NULL DEFAULT -1,
                                             PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS horarios_actividades (
                                                    hora_inicio	varchar(10),
                                                    hora_fin	varchar(10),
                                                    actividad	varchar(10) NOT NULL,
                                                    ficha	varchar(20),
                                                    dia	INTEGER NOT NULL DEFAULT 1,
                                                    FOREIGN KEY(actividad) REFERENCES actividades(id),
                                                    FOREIGN KEY(ficha) REFERENCES ficha_cliente(ID)
);

CREATE TABLE IF NOT EXISTS usuarios (
                                        usuario	varchar(250),
                                        contrasenia	varchar(250) NOT NULL,
                                        rol	varchar(20) NOT NULL,
                                        PRIMARY KEY(usuario)
);

INSERT INTO clientes VALUES ('1750105585','Kenneth Leonardo','Ulloa Tobar','M','03-07-2000','greenlantern0@hotmail.com','0987175255','Sebas','0987353846','Av. La Bota');
INSERT INTO actividades VALUES ('ac1','Fortalecimiento Muscular','Levantamiento de peso para tonificar la masa muscular.');
INSERT INTO actividades VALUES ('ac2','Crossfit','Serie de ejercicios para mejorar el sistema circulatorio, respiratorio y fuerza física.');
INSERT INTO ficha_cliente VALUES ('F1750105585','1750105585',60.0,165.2,'03-01-2023','05-01-2023',1);
INSERT INTO horarios_actividades VALUES ('09:00','11:00','ac2','F1750105585',5);
INSERT INTO horarios_actividades VALUES ('08:00','10:00','ac1','F1750105585',1);
INSERT INTO usuarios VALUES ('mario','1234','USUARIO');
INSERT INTO usuarios VALUES ('jose','1234','ADMINISTRADOR');
INSERT INTO usuarios VALUES ('kenneth','1234','ADMINISTRADOR');
COMMIT;
