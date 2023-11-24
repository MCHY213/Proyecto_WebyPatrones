drop schema if exists Parlante;
drop user if exists user123;

create database Parlante;

use Parlante;

create user 'user123'@'%' identified by 'a_user123';

grant all privileges on Parlante.* to 'user123';
flush privileges;

create table parlante(
id_producto int not null auto_increment,
nombre varchar(20),
descripcion varchar(30),
precio int,
imagen varchar(1024),
primary key(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into parlante(nombre, descripcion, precio, imagen) values
('Sony', 'Vive con la mejor experciencia en su vida', 1800, 'HT-AX7.png'),
('Aiwa', 'Prueba el mejor bajo para el parlante', 800, 'aiwa.png'),
('Bose', 'Obten la mejor experiencia de calidad de sonido', 1450, 'SRS-GGX300');