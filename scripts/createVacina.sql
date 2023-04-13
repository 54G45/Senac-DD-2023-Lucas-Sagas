set sql_safe_updates = 0;
drop database if exists Vacinadb;
create database Vacinadb;
use Vacinadb;

create table tipoPessoa(
id int not null primary key,
descricao varchar(15)
);

insert into tipoPessoa(id, descricao) values (1, 'pesquisador');
insert into tipoPessoa(id, descricao) values (2, 'voluntario');
insert into tipoPessoa(id, descricao) values (3, 'comun');

create table pessoa(
id int not null auto_increment primary key,
nome varchar(100) not null,
dataNascimento datetime,
sexo char,
cpf varchar(11),
tipo int not null,
foreign key(tipo) references tipoPessoa(id)
);

create table estagioPesquisa(
id int not null primary key,
descricao varchar(15)
);

insert into estagioPesquisa(id, descricao) values (1, 'inicial');
insert into estagioPesquisa(id, descricao) values (2, 'testes');
insert into estagioPesquisa(id, descricao) values (3, 'aplic_em_massa');

create table vacina(
idvacina int not null auto_increment primary key,
paisOrigem varchar(45),
estagioPesquisa int not null,
inicioPesquisa datetime,
pesquisadorResponsavel varchar(100),
foreign key (estagioPesquisa) references estagioPesquisa(id)
);

insert into vacina(paisOrigem, estagioPesquisa, inicioPesquisa, pesquisadorResponsavel)
values ('br', 1, '2020-01-01', 'Giuseppi');
insert into vacina(paisOrigem, estagioPesquisa, inicioPesquisa, pesquisadorResponsavel)
values ('br', 1, '2020-01-01', 'elma');
insert into vacina(paisOrigem, estagioPesquisa, inicioPesquisa, pesquisadorResponsavel)
values ('br', 1, '2020-01-01', 'kemmel');
insert into vacina(paisOrigem, estagioPesquisa, inicioPesquisa, pesquisadorResponsavel)
values ('br', 1, '2020-01-01', 'Giuseppi');
           




















-- insert into tipoPessoa(descricao) values ('pesquisador');insert into tipoPessoa(descricao) values ('voluntario');insert into tipoPessoa(descricao) values ('comum');






