/* Poner en uso la Base de Datos VideoClub */
USE BDVideoClub
GO

/* DATA de la tabla Actor */
INSERT INTO Actor         (nomAct, apeAct)     VALUES         ('Chris','Evans');
INSERT INTO Actor         (nomAct, apeAct)     VALUES         ('Chris','Hemsworth');
INSERT INTO Actor         (nomAct, apeAct)     VALUES         ('Andrew','Garfield');
INSERT INTO Actor         (nomAct, apeAct)     VALUES         ('Andrew','Scott')
GO

/* DATA de la tabla Director */
INSERT INTO Director         (nomDirect, apeDirect)     VALUES         ('Guillermo','del Toro');
INSERT INTO Director         (nomDirect, apeDirect)     VALUES         ('Joss','Whedon');
INSERT INTO Director         (nomDirect, apeDirect)     VALUES         ('Taika','Waititi');
INSERT INTO Director         (nomDirect, apeDirect)     VALUES         ('Marc','Webb')
GO

/* DATA de la tabla Género */
INSERT INTO Genero         (nomGen)     VALUES         ('Dramatico');
INSERT INTO Genero         (nomGen)     VALUES         ('Accion');
INSERT INTO Genero         (nomGen)     VALUES         ('Ciencia Ficcion');
INSERT INTO Genero         (nomGen)     VALUES         ('Fantastico')
GO

/* DATA de la tabla Película */
INSERT INTO Pelicula         (titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct)     VALUES         ('Avengers:Infinity War','A','1','1','1');
INSERT INTO Pelicula         (titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct)     VALUES         ('The Amazing SpiderMan','A','2','2','2');
INSERT INTO Pelicula         (titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct)     VALUES         ('Thor Ragnarok','A','3','3','3');
INSERT INTO Pelicula         (titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct)     VALUES         ('Sherlock','A','4','4','4')
GO

/* DATA de la tabla Socio */
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Jose','Perez','28 de Julio','986541235','1','1','1');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Alexander','Rodriguez','Las Banderas','987451236','2','2','2');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Miguel','Niguez','El Salvador','962014563','3','3','3');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Daniel','Santos','Las Margaritas','902136547','4','4','4')
GO

/* DATA de la tabla Prestamo */
INSERT INTO Prestamo         (fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono)     VALUES         ('0/10/2000',1,'(242) 142-4414','12-4142454','315-62-6165','bb-245-b255','(235) 235-5312 x53521');
INSERT INTO Prestamo         (fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono)     VALUES         ('10/10/2000',1,'(235) 325-3253','23-5352553','325-32-5325','sd-344-s343','(425) 366-4642 x64621');
INSERT INTO Prestamo         (fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono)     VALUES         ('10/10/2000',1,'(241) 242-4124','24-2142144','122-42-4241','ww-231-b243','(213) 214-2142 x41412');
INSERT INTO Prestamo         (fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono)     VALUES         ('10/10/2000',1,'(514) 545-4364','12-4214414','124-12-4241','ee-241-e243','(214) 124-4114 x14221');
INSERT INTO Prestamo         (fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono)     VALUES         ('11/11/1333',2,'(412) 442-4142','12-4124143','434-31-4341','vv-324-v112','(124) 124-2412 x24224')
GO