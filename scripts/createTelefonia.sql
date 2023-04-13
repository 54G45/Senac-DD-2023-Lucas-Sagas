set sql_safe_updates = 0;
drop database if exists telefonia;
create database telefonia;
                           use telefonia;


create table endereco(
id int not null auto_increment primary key,
numero varchar(50) not null,
cep varchar(8) not null,
rua varchar(255) not null,
bairro varchar(255) not null,
cidade varchar(255) not null,
estado varchar(2) not null
);

create table telefone(
id int not null auto_increment primary key,
ddd varchar(3) not null,
numero varchar(9) not null,
ativo boolean not null,
movel boolean not null,
id_cliente int not null
);

create table cliente(
id int not null auto_increment primary key,
nome varchar(125) not null,
cpf varchar(11) not null unique,
ativo boolean not null,
endereco int not null,
foreign key (endereco) references endereco(id)
);










