CREATE DATABASE db_A3;
USE db_A3;
CREATE TABLE amigos (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE ferramentas (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  custo DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE emprestimo (
  id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
  data_emprestimo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  data_devolucao DATE NOT NULL,
  status BOOLEAN NOT NULL DEFAULT TRUE,
  nome_amigo VARCHAR(100),
  nome_ferramenta VARCHAR(50)
) ENGINE = InnoDB;

CREATE TABLE evento (
  id_evento INT AUTO_INCREMENT PRIMARY KEY,
  id_amigo INT,
  data_evento DATE NOT NULL,
  local_evento VARCHAR(100) NOT NULL,
  descricao TEXT,
  FOREIGN KEY (id_amigo) REFERENCES amigos(id)
) ENGINE = InnoDB;

CREATE TABLE ferramenta_emprestimo (
  id_ferramenta INT,
  id_emprestimo INT,
  PRIMARY KEY (id_ferramenta, id_emprestimo),
  FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id),
  FOREIGN KEY (id_emprestimo) REFERENCES emprestimo(id_emprestimo)
) ENGINE = InnoDB;
