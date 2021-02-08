use test;

drop table persona;
create table Persona(
idPersona int primary key auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
email varchar(25) not null,
telefono varchar(10) not null
);
describe persona;
alter table persona change column
idPersona id_persona int auto_increment;
describe persona;

insert into persona(nombre,apellido, email,telefono) values
("Juan","Perez","jperez@gmail.com","467814635");

use test;
create table Usuario(
id_usuario int primary key auto_increment,
username varchar(45) not null,
password varchar(128) not null
);

create table Rol(
id_rol int primary key auto_increment,
nombre varchar(30) NOT NULL,
id_usuario int(11) not null,
constraint fk_usuarios_roles 
foreign key(id_usuario)
References usuario(id_usuario)
);

insert into usuario(username,password) 
values("admin","123456");

insert into usuario(username,password)
values("jestefo","123456");

insert into rol(nombre,id_usuario)
values("ROLE_ADMIN",1);
insert into rol(nombre,id_usuario)
values("ROLE_USER",1);

insert into rol(nombre,id_usuario)
values("ROLE_USER",2);

select * from usuario;

update usuario set 
password="$2a$10$kFbQfpYHVg8cxlf05GaH9u.YWlogtUpPHeAQWXZwo3J4NUPr1brfm"
where id_usuario=1;

update usuario set
password="$2a$10$NnnOaLXijmjAyocVAt2jbuBieF5.r4n8KXUCPzbiKUGux02eyPnTy"
where id_usuario=2;

select * from usuario;
