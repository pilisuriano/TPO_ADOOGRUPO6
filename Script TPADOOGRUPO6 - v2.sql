CREATE DATABASE TPOGRUPO6;

USE TPOGRUPO6;

CREATE TABLE IF NOT EXISTS Publicacion(
	idPublicacion int(15) NOT NULL AUTO_INCREMENT,
    tituloBusqueda varchar(50),
    descripcionPuesto varchar(250),
    modalidadContrato varchar(50),
    tipoDeTrabajo varchar(50),
    lugarDeTrabajo varchar(50),
    categoria varchar(50),
    requisitos varchar(200),
    sueldoOfrecido float,
    activa boolean,
    fechaCierre date,
    PRIMARY KEY (idPublicacion)
);

CREATE TABLE IF NOT EXISTS Postulante(
	idPostulante int(15) NOT NULL AUTO_INCREMENT,
    nombreYApe varchar(50),
    fechaNacimiento date,
    nacionalidad varchar(50),
    idiomas varchar(50),
    intereses varchar(200),
    remuneracionPretendida float,
    PRIMARY KEY (idPostulante)
);

CREATE TABLE IF NOT EXISTS Empresa(
	idEmpresa int(15) NOT NULL AUTO_INCREMENT,
    cuit Integer,
    razonSocial varchar(200),
    PRIMARY KEY (idEmpresa)
);

CREATE TABLE IF NOT EXISTS Favoritos(
	idFavorito int(15) NOT NULL AUTO_INCREMENT,
	idPostulante int(15) not null,
	idPublicacion int(15) not null,
	PRIMARY KEY (idFavorito),
	FOREIGN KEY (idPublicacion) REFERENCES Publicacion(idPublicacion),
	FOREIGN KEY (idPostulante) REFERENCES Postulante(idPostulante)
);

CREATE TABLE IF NOT EXISTS PubliPostu(
	idPubliPostu int(15) NOT NULL AUTO_INCREMENT,
    fechaPostulacion date,
    publicacion int(15),
    postulante int(15),
    PRIMARY KEY (idPubliPostu),
    FOREIGN KEY (publicacion) REFERENCES Publicacion(idPublicacion),
    FOREIGN KEY (postulante) REFERENCES Postulante(idPostulante)
);

CREATE TABLE IF NOT EXISTS EmpresaPubli(
	idEmpresaPubli int(15) NOT NULL AUTO_INCREMENT,
    empresa int(15),
    publicacion int(15),
    PRIMARY KEY (idEmpresaPubli),
    FOREIGN KEY (empresa) REFERENCES Empresa(idEmpresa),
    FOREIGN KEY (publicacion) REFERENCES Publicacion(idPublicacion)
);

--------------------------
-- Inserts en PUBLICACION
--------------------------

insert into publicacion 
values(1,'DevOps Jr','Analizar;Desplegar;Integrar;Automatizar','part-time','presencial','Av Callao 1000','Sistemas','ELK;Service Mesh;Jenkins;Openshift;Shell Scripting;',25000.0,true,sysdate());

insert into publicacion 
values(2,'QA Jr','Analizar;Testear;Casuistica','full-time','remoto','Sin Nombre 123','Sistemas','ALM;Playwright;Cypress;Javascript;ISTQB;JQuery;Git;Linux;CSS;',30000.0,true,sysdate());

insert into publicacion 
values(3,'Dev Jr','Analizar;Desarrollar;Debuguear;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;	',30000.0,true,sysdate());

insert into publicacion 
values(4,'Dev Ssr','CodeReview;AnalizarDesarrollar;Debuguear;Refactorear;Capacitar;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;',50000.0,true,sysdate());

insert into publicacion 
values(5,'QA Ssr','Analizar;Testear;Casuistica;Automatizar;UAT;Generar datos;Preparar ambiente;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;',55000.0,true,sysdate());

insert into publicacion 
values(6,'DevOps Ssr','Construir pipelines;definir metricas; generar tableros;capacitar;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;	',50000.0,true,sysdate());

insert into publicacion 
values(7,'Dev Sr','CodeReview;AnalizarDesarrollar;Debuguear;Refactorear;Capacitar;Definir patrones;Buscar mejora continua;Evaluar puntos de dolor;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;	',80000.0,true,sysdate());

insert into publicacion 
values(8,'QA Sr','Analizar;Testear;Casuistica;Automatizar;UAT;Generar datos;Preparar ambiente;Asesor funcional;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;	',90000.0,true,sysdate());

insert into publicacion 
values(9,'DevOps Sr','Construir pipelines;definir metricas; generar tableros;capacitar;S2I;Construir Pods;','part-time','remoto','Av Corrientes 710','Sistemas','React;NextJS;Logica Programacional;MVC;Git;Linux;JQuery;CSS;Angular;HTML;Python;	',100000.0,true,sysdate());

insert into publicacion 
values(10,'Pay Roll','Analisis de pagos;Analisis de impuestos;Documentacion;','part-time','remoto','Av Corrientes 710','RRHH','Contabilidad;Payroll;Facturas;',80000.0,true,sysdate());

insert into publicacion 
values(11,'Recruiter','Reclutar;Analizar CVs;','part-time','remoto','Av Corrientes 710','RRHH','Habilidades blandas;Negociacion;Coach;',90000.0,true,sysdate());

insert into publicacion 
values(12,'Analista N2','Resolver Tickets;Mantener SLAs;Comunicacion;','part-time','remoto','Av Corrientes 710','Service Desk','Unix;Ticket;Remedy;SVN;BPM;',100000.0,true,sysdate());

--------------------------
-- Inserts en POSTULANTE
--------------------------

insert into postulante 
values(1,'Helen Chufe','1992-12-03','Argentina','Español','Programacion',25000.0);

insert into postulante 
values(2,'Delfor Zudo','1981-01-15','Argentino','Español','QA',15000.0);

insert into postulante 
values(3,'Amilcar Cajada','1977-06-28','Venezolana','Español','RRHH',30000.0);

insert into postulante 
values(4,'Isaac Mocos','1996-12-03','Colombiano','Ingles','DevOps',800000.0);

--------------------------
-- Inserts en EMPRESA
--------------------------

alter table empresa
modify column cuit varchar(12);

insert into empresa
values (1,30500006613,'BANCO PATAGONIA SOCIEDAD ANONIMA');

insert into empresa
values (2,30663205621,'CAJA DE SEGUROS SA');

insert into empresa
values (3,30704961983,'INTEGRITY SEGUROS ARGENTINA S.A.');

insert into empresa
values (4,30504018845,'VOLKSWAGEN ARGENTINA S A');

insert into empresa
values (5,30562113289,'CENTRO DE INTEGRACION LIBRE Y SOLIDARIO DE ARGENTINA ( C I L S A )');

--------------------------
-- Inserts en FAVORITOS
--------------------------

insert into favoritos
values (1,1,3);

insert into favoritos
values (2,2,2);

insert into favoritos
values (3,3,1);

insert into favoritos
values (4,4,1);

--------------------------
-- Inserts en PUBLIPOSTU
--------------------------

insert into publipostu 
values (1,'2021-10-30',1,4);

insert into publipostu 
values (2,'2021-10-30',1,1);

insert into publipostu 
values (3,'2021-10-30',1,3);

insert into publipostu 
values (4,'2021-10-28',2,2);

insert into publipostu 
values (5,'2021-10-10',3,4);

insert into publipostu 
values (6,'2021-10-30',3,1);

insert into publipostu 
values (7,'2021-10-28',2,4);

insert into publipostu 
values (8,'2021-10-30',3,2);

insert into publipostu 
values (9,'2021-10-30',10,1);

insert into publipostu 
values (10,'2021-10-28',11,4);

insert into publipostu 
values (11,'2021-10-30',12,2);

insert into publipostu 
values (12,'2021-10-30',10,2);

insert into publipostu 
values (13,'2021-10-28',11,3);

insert into publipostu 
values (14,'2021-10-30',12,4);

--------------------------
-- Inserts en EMPRESAPUBLI
--------------------------

insert into empresapubli 
values(1,1,1);

insert into empresapubli 
values(2,1,2);

insert into empresapubli 
values(3,4,3);

--------------------------
-- La oferta laboral que más postulantes recibió en un mes y/o año determinado.
--------------------------

select idPubliPostu, pp.publicacion, p.tituloBusqueda, count(*) as cantidadPostulados
from publipostu pp
inner join publicacion p
on pp.publicacion = p.idPublicacion 
where fechaPostulacion = '2021-10-30'
group by publicacion
order by 4 desc
limit 1;

--------------------------
-- Las primeras 5 categorías más seleccionadas en las ofertas laborales.
--------------------------

select categoria, count(categoria) as cantidadSeleccion
from publipostu pp
inner join publicacion p
on pp.publicacion = p.idPublicacion
group by categoria
order by 1 desc
limit 5;

--------------------------
-- Cuál es el trabajo “más accesible”, considerando que “el más accesible” es aquel trabajo part-time,
-- remoto, con menor cantidad de tareas asignadas y menor cantidad de requisitos.
--------------------------

select * from(
	SELECT 
	    idPublicacion, tituloBusqueda ,
	    ROUND((LENGTH(requisitos)-LENGTH(REPLACE(requisitos,";","")))/LENGTH(";")) AS cantRequisitos,
	    ROUND((LENGTH(descripcionPuesto)-LENGTH(REPLACE(descripcionPuesto,";","")))/LENGTH(";")) AS cantTareas
	FROM publicacion
	where modalidadContrato = 'part-time'
	and tipoDeTrabajo = 'remoto'
	order by 4 asc
) as masAccesible
order by 3 asc;

--------------------------
-- Cuál es el trabajo “más accesible”, considerando que “el más accesible” es aquel trabajo part-time,
-- remoto, con menor cantidad de tareas asignadas y menor cantidad de requisitos.
--------------------------

SELECT 
    idPublicacion, tituloBusqueda ,
    ROUND((LENGTH(requisitos)-LENGTH(REPLACE(requisitos,";","")))/LENGTH(";")) AS count
FROM publicacion
where modalidadContrato = 'part-time'
and tipoDeTrabajo = 'remoto'
order by 3 desc;