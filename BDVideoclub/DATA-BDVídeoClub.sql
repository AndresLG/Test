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

