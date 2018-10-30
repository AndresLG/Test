USE BDVideoClub
GO

/* Vista de Libro */
create view vw_Pelicula as
select idPel,titulo,estado,Genero.nomGen as Genero,Concat(Director.nomDirect,' ',Director.apeDirect) as Director,
       Concat(Actor.nomAct,' ',Actor.apeAct) as Actor
from Pelicula
inner join Genero
on Genero.idGen = Pelicula.Genero_idGen
inner join Director
on Director.idDirect  = Pelicula.Director_idDirect
inner join Actor
on Actor.idAct = Pelicula.Actor_idAct
GO

/* Vista de Prestamo */
create view vw_Prestamo as
select iddPrest,fechaPrest,Concat(Socio.nomSoc,' ',Socio.apeSoc) as Socio,telefono2,
       Identificacion,SSN,ProductKey,Prestamo.Telefono
from Prestamo
inner join Socio
on Socio.idSoc = Prestamo.Socio_idSoc
GO

/* Vista de Socio */
create view vw_Socio as
select idSoc,nomSoc,apeSoc,direccion,telefono,Concat(Director.nomDirect,' ',Director.apeDirect) as Director,
       Concat(Actor.nomAct,' ',Actor.apeAct) as Actor,Concat(Socio.nomSoc,' ',Socio.apeSoc) as Genero
from Socio
inner join Director
on Director.idDirect  = Socio.Director_idDirect
inner join Actor
on Actor.idAct = Socio.Actor_idAct
inner join Genero
on Genero.idGen = Socio.Genero_idGen
;