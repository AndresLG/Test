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

/* DATA de la Socio */
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Jose','Perez','28 de Julio','986541235','1','1','1');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Alexander','Rodriguez','Las Banderas','987451236','2','2','2');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Miguel','Niguez','El Salvador','962014563','3','3','3');
INSERT INTO Socio         (nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen)     VALUES         ('Daniel','Santos','Las Margaritas','902136547','4','4','4')
GO