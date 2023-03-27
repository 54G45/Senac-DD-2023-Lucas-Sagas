set sql_safe_updates = 0;
drop database if exists Vacinadb;
create database Vacinadb;
use Vacinadb;

create table vacina(

idvacina int auto_increment primary key,
paisDeOrigem varchar(45),
estagioDaPesquisa int,
dataDeInicioDaPesquisa datetime,
pesquisadorResponsavel varchar(100)

);

create table pessoa(
idpessoa int auto_increment primary key,
nome varchar(100) not null,
dataNascimento datetime,
sexo char,
cpf varchar(11),
tipo int

);

create table tipoPessoa(
idTipoPessoa int auto_increment primary key,
tipo varchar(15)
);

insert into tipoPessoa(tipo) values ('pesquisador');
insert into tipoPessoa(tipo) values ('voluntario');
insert into tipoPessoa(tipo) values ('comum');






