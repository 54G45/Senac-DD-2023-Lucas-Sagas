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
idpessoa int auto_increment,
nome varchar(100) not null,
dataNascimento datetime,
sexo char,
cpf varchar(11),
tipo varchar(45)

);

insert into pessoa()
values ();

insert into vacina (paisDeOrigem, estagioDaPesquisa, dataDeInicioDaPesquisa, pesquisadorResponsavel)
values ();

select * from vacina;




