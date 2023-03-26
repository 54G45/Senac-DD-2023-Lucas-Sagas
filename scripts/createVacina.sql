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

insert into vacina (paisDeOrigem, estagioDaPesquisa, dataDeInicioDaPesquisa, pesquisadorResponsavel)
values ();

select * from vacina;




