

create database bancosistema;

use bancosistema;

create table produto(idproduto int primary key auto_increment,
nome varchar (250) unique,
descricao varchar(250),
preco double);


