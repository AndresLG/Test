USE BDBibliotecaV
GO

/* Vista de Libro */
create view vw_Libro as
select IDLIB,TITLIB,LEFT(FECPUBLIB,4) as FECPUBLIB,Concat(Autor.NOMAUT,' ',Autor.APEAUT) as Autor,Genero.NOMGEN as Genero,
       EDITLIB,PAGLIB,DESCLIB,TAMLIB,Tipo_Libro.NOMTIPOLIB as Tipo_Libro,Anaquel.NOMANQ as Anaquel,ESTLIB
from Libro
inner join Autor
on Autor.IDAUT  = Libro.IDAUT
inner join Genero
on Genero.IDGEN = Libro.IDGEN
inner join Tipo_Libro
on Tipo_Libro.IDTIPOLIB = Libro.IDTIPOLIB
inner join Anaquel
on Anaquel.IDANQ = Libro.IDANQ
;