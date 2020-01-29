

drop database if exists profesorfk4;

create database profesorfk4;

use profesorfk4; 

create table Direccion (
        Id integer not null AUTO_INCREMENT,
        calle varchar(255),
        numero integer,
        poblacion varchar(255),
        provincia varchar(255),
        primary key (Id)
    )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
    
create table Modulo (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        creditos float,
        primary key (Id)
    )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
    
create table Profesor (
        Id integer not null AUTO_INCREMENT,
        direccion_id integer NOT NULL,
        modulo_id integer NOT NULL,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        primary key (Id),
        CONSTRAINT `FKDIR` FOREIGN KEY (`direccion_id`) REFERENCES `Direccion` (`Id`),
        CONSTRAINT `FKMOD` FOREIGN KEY (`modulo_id`) REFERENCES `Modulo` (`Id`)
    )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
