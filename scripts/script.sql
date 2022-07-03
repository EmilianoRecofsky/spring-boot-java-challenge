/*
 * Script MySQL para creacion de base de datos y su modelo
 */

create database autobuses;

use autobuses;

CREATE TABLE reserva(
	`id_reserva` INT NOT NULL AUTO_INCREMENT,
	`nombre` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`origen` varchar(255) NOT NULL,
	`destino` varchar(255) NOT NULL,
	`fecha_hora_salida` varchar(255) NOT NULL,
	`duracion` varchar(255) NOT NULL,
PRIMARY KEY
(
	`id_reserva` ASC
));
