-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-08-20 22:50:50.926
CREATE DATABASE BDVideoClub
GO
USE BDVideoClub
GO
-- tables
-- Table: Actor
CREATE TABLE Actor (
    idAct int  NOT NULL IDENTITY(1, 1),
    nomAct varchar(30)  NULL,
    apeAct varchar(30)  NULL,
    CONSTRAINT Actor_pk PRIMARY KEY  (idAct)
);

-- Table: DetallePrestamo
CREATE TABLE DetallePrestamo (
    idDetPrest int  NOT NULL IDENTITY(1, 1),
    Prestamo_iddPrest int  NOT NULL,
    Pelicula_idPel int  NOT NULL,
    CONSTRAINT DetallePrestamo_pk PRIMARY KEY  (idDetPrest)
);

-- Table: Director
CREATE TABLE Director (
    idDirect int  NOT NULL IDENTITY(1, 1),
    nomDirect varchar(30)  NULL,
    apeDirect varchar(30)  NULL,
    CONSTRAINT Director_pk PRIMARY KEY  (idDirect)
);

-- Table: Genero
CREATE TABLE Genero (
    idGen int  NOT NULL IDENTITY(1, 1),
    nomGen varchar(15)  NULL,
    CONSTRAINT Genero_pk PRIMARY KEY  (idGen)
);

-- Table: Pelicula
CREATE TABLE Pelicula (
    idPel int  NOT NULL IDENTITY(1, 1),
    titulo varchar(30)  NULL,
    estado char(1)  NULL,
    Genero_idGen int  NOT NULL,
    Director_idDirect int  NOT NULL,
    Actor_idAct int  NOT NULL,
    CONSTRAINT Pelicula_pk PRIMARY KEY  (idPel)
);

-- Table: Prestamo
CREATE TABLE Prestamo (
    iddPrest int  NOT NULL IDENTITY(1, 1),
    fechaPrest date  NULL,
    Socio_idSoc int  NOT NULL,
    telefono2 varchar(30) NULL,
    Identificacion varchar(30) NULL,
    SSN varchar(30) NULL,
    ProductKey varchar(30) NULL,
    Telefono varchar(30) NULL,
    CONSTRAINT Prestamo_pk PRIMARY KEY  (iddPrest)
);

-- Table: Socio
CREATE TABLE Socio (
    idSoc int  NOT NULL IDENTITY(1, 1),
    nomSoc varchar(30)  NULL,
    apeSoc varchar(30)  NULL,
    direccion varchar(30)  NULL,
    telefono char(9)  NULL,
    Director_idDirect int  NOT NULL,
    Actor_idAct int  NOT NULL,
    Genero_idGen int  NOT NULL,
    CONSTRAINT Socio_pk PRIMARY KEY  (idSoc)
);

-- foreign keys
-- Reference: DetallePrestamo_Pelicula (table: DetallePrestamo)
ALTER TABLE DetallePrestamo ADD CONSTRAINT DetallePrestamo_Pelicula
    FOREIGN KEY (Pelicula_idPel)
    REFERENCES Pelicula (idPel);

-- Reference: DetallePrestamo_Prestamo (table: DetallePrestamo)
ALTER TABLE DetallePrestamo ADD CONSTRAINT DetallePrestamo_Prestamo
    FOREIGN KEY (Prestamo_iddPrest)
    REFERENCES Prestamo (iddPrest);

-- Reference: Pelicula_Actor (table: Pelicula)
ALTER TABLE Pelicula ADD CONSTRAINT Pelicula_Actor
    FOREIGN KEY (Actor_idAct)
    REFERENCES Actor (idAct);

-- Reference: Pelicula_Director (table: Pelicula)
ALTER TABLE Pelicula ADD CONSTRAINT Pelicula_Director
    FOREIGN KEY (Director_idDirect)
    REFERENCES Director (idDirect);

-- Reference: Pelicula_Genero (table: Pelicula)
ALTER TABLE Pelicula ADD CONSTRAINT Pelicula_Genero
    FOREIGN KEY (Genero_idGen)
    REFERENCES Genero (idGen);

-- Reference: Prestamo_Socio (table: Prestamo)
ALTER TABLE Prestamo ADD CONSTRAINT Prestamo_Socio
    FOREIGN KEY (Socio_idSoc)
    REFERENCES Socio (idSoc);

-- Reference: Socio_Actor (table: Socio)
ALTER TABLE Socio ADD CONSTRAINT Socio_Actor
    FOREIGN KEY (Actor_idAct)
    REFERENCES Actor (idAct);

-- Reference: Socio_Director (table: Socio)
ALTER TABLE Socio ADD CONSTRAINT Socio_Director
    FOREIGN KEY (Director_idDirect)
    REFERENCES Director (idDirect);

-- Reference: Socio_Genero (table: Socio)
ALTER TABLE Socio ADD CONSTRAINT Socio_Genero
    FOREIGN KEY (Genero_idGen)
    REFERENCES Genero (idGen);

-- End of file.

