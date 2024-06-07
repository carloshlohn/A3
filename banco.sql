create database db_A3;
use db_A3;
CREATE TABLE amigos (
  id INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;
CREATE TABLE ferramentas (
  id INT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  preço DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS emprestimo (
  id_emprestimo INT auto_increment PRIMARY KEY,
  id_ferramenta INT NOT NULL,
  id_amigos INT NOT NULL,
  data_emprestimo timestamp default NULL,
  data_limite DATE NOT NULL,
  amigos_id INT NOT NULL,
  ferramentas_id INT NOT NULL,
  CONSTRAINT fk_table1_amigos
    FOREIGN KEY (amigos_id)
    REFERENCES amigos (id),
 FOREIGN KEY (ferramentas_id)
    REFERENCES ferramentas (id))
    ENGINE = InnoDB;
CREATE TABLE evento (
id_evento INT AUTO_INCREMENT PRIMARY KEY,
id_amigo INT,
data_evento DATE NOT NULL,
local_ VARCHAR(100) NOT NULL,
descricao TEXT,
foreign key (id_amigo) references amigos(id)
);
