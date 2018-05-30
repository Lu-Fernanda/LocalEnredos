

create table usuario(
nombre VARCHAR (50),
apellido VARCHAR (50),
tipoDocumento VARCHAR (50),
cc INT ,
edad INTEGER,
celular VARCHAR (20),
telefono VARCHAR (10),
correo VARCHAR (30),
estrato INTEGER ,
direccion VARCHAR (50),
barrio VARCHAR (25),
tipoCasa VARCHAR (25),
localidad VARCHAR (25),
reciboPublico VARCHAR (25),
nHijos INTEGER,
salud VARCHAR (25),
trabajo boolean, 
nPersonas INTEGER,
tipoTrabajo VARCHAR (25),
ingresos VARCHAR (25),
contactoAdicional VARCHAR (25),
numTel INTEGER ,
notificacion boolean, 
estado INTEGER,
 primary key(cc)
);

INSERT INTO usuario VALUES ('luisa fernanda','ariza','cÃ©dula de ciudadania',1031,22,3213,0,'lu@gmail.com',1,'direccion','barrio','propia','localidad','recibo',0,'sisben',true,2,'tiempo completo','0-1SMLV','LAURA r',301504,TRUE,1);
INSERT INTO usuario VALUES ('Maria Paula','Gomez','cÃ©dula de ciudadania',1019,35,315,0,'gomhez.paula@gmail.com',1,'direccion','barrio','arrendada','localidad','recibo',0,'sisben',true,2,'tiempo completo','0-1SMLV','LAURA r',301504,TRUE,1);


create table abogado(
entidad VARCHAR (50),
nombreEntidad VARCHAR(25),
tarjetaProfesional VARCHAR(30),
areaEspecializacion VARCHAR (50),
cc INT,
nombre VARCHAR (50),
correo VARCHAR (30),
primary key(cc)
);
INSERT INTO abogado VALUES ('Consultorio Juridico','Sergio Arbioleda',0,'NA',1031164919,'laura ramirez','lauris@gmail.com');
INSERT INTO abogado VALUES ('Defensoria del pueblo','Casa justicia zona 19',1234546789,'civil',10311289,'German cardona','german@gmail.com');

create table datosCaso(
id SERIAL,
tipoCaso VARCHAR (50), 
abogadoAnterior boolean, 
informacionCaso VARCHAR (30),
archivoAdicional VARCHAR(30),
estado boolean,  
idUsuario INT,
idAbogado INT,
primary key(id),
FOREIGN KEY (idUsuario) REFERENCES Usuario(cc),
FOREIGN KEY (idAbogado) REFERENCES Abogado(cc)
);
INSERT INTO datosCaso VALUES (1,'familiar',false,'info','archivoAdicional',false,1031,1031164919);
INSERT INTO datosCaso VALUES (2,'civil',false,'informacion','archivoAdicional',false,1019,10311289);

create table informe(
id serial,
fecha TIMESTAMP,
nHoras int,
informes VARCHAR(100),
factura INT, 
comentarioUsuario VARCHAR(50),
archivoAdjunto VARCHAR(50),
idProceso1 INT,
FOREIGN KEY (idProceso1) REFERENCES datosCaso(id),
primary key(id)
);
INSERT INTO informe VALUES (11,null,5,'datos del informe',35000,'comentarios','archivo andijunto',1);

create table diligencia(
id SERIAL,
diligencias VARCHAR (30), 
descripcion VARCHAR(90), 
fechaLimite DATE, 
idProceso2 INTEGER,
primary key(id),
FOREIGN KEY (idProceso2) REFERENCES datosCaso(id)
);
INSERT INTO DILIGENCIA VALUES (1,'diligencia1','asasasa', '2007-12-31 23:59:59',1);



