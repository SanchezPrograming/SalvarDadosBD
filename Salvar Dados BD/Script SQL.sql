
create database SalvarBD;
use SalvarBD;
CREATE TABLE IF NOT EXISTS tabela_pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    endereco VARCHAR(255) NOT NULL
);
select * from tabela_pessoa;