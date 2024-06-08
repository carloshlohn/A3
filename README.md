# A3 Sistema de Empréstimo de Ferramentas

## Integrantes 

A3 2024/1

Carlos Henrique Lohn(owner) -> carloshlohn, carlo, 1072410683 (RA)

Silvia Koch Fernandes -> Asus, silviakochf, 1072416359 (RA)

Murilo dos Santos Ferreira -> Muri8973, 1072416485 (RA)

Caue Rodrigues Fenn -> CaueFenn, 10724112205 (RA)

José Henrique Lohn da Silva -> JoseHL0hn, 10724112626 (RA)


### Contextualização

- Esta é uma versão do sistema para a IDE NetBeans.<br> 
- Os dados estão armazenados no banco de dados MySQL.<br>
- Este programa possui diversas classes organizada nos pacotes, principal, visao, dao e model.<br>
- A pasta src contêm os fontes do projeto.<br>
- A interface gráfica foi construída com o auxílio da IDE NetBeans.<br>

#### Banco de Dados


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
foreign key (id_amigo) references amigos(id));
CREATE TABLE ferramenta_emprestimo (
id_ferramenta int,
id_emprestimo int,
primary key (id_ferramenta, id_emprestimo),
foreign key (id_ferramenta) references ferramentas (id),
foreign key (id_emprestimo) references emprestimo (id_emprestimo))
;

##### Requisitos Funcionais

- Cadastro de Ferramentas: O sistema deve permitir o cadastro de ferramentas, incluindo nome, marca e custo de aquisição.
- Cadastro de Amigos: Deve ser possível cadastrar amigos, fornecendo nome e telefone.
- Registro de Empréstimos: Os empréstimos de ferramentas devem ser registrados, associando uma ou mais ferramentas a um amigo, e incluindo datas de empréstimo e devolução.
- Relatórios de Ferramentas: O sistema deve gerar relatórios que exibam as ferramentas cadastradas e o total gasto com aquisições.
- Relatórios de Empréstimos: Devem ser gerados relatórios de empréstimos ativos e de todos os empréstimos realizados, incluindo informações sobre quando foi emprestado e se foi devolvido.
- Verificação de Empréstimos Pendentes:* Ao realizar um novo empréstimo, o sistema deve verificar se o amigo ainda tem ferramentas emprestadas e notificar sobre isso.
- Integração com Google Agenda: O sistema deve integrar-se com o Google Agenda para compartilhar lembretes para devolução das ferramentas por e-mail.

###### Requisitos Não Funcionais:

- Localidade: O software deve ser instalado e executado localmente no computador do tio-avô.
- Usabilidade: A interface do usuário deve ser intuitiva e fácil de usar, considerando o público-alvo que pode não ter experiência técnica.
- Desempenho: O sistema deve ser responsivo e eficiente, mesmo com grandes volumes de dados.
- Segurança: Deve garantir a segurança dos dados armazenados localmente, incluindo medidas de backup e proteção contra acesso não autorizado.
- Privacidade: O sistema deve garantir a privacidade de todos os dados pessoais armazenados no banco de dados.

###### Regras de Negócio:

- Restrição de Acesso: Apenas o tio-avô deve ter acesso ao sistema, garantindo sua privacidade.
- Atualização de Cadastros: As informações sobre ferramentas e amigos devem ser facilmente atualizáveis para refletir mudanças na coleção de ferramentas ou na lista de amigos.
- Notificação de Devolução: O sistema deve notificar o tio-avô quando uma ferramenta emprestada for devolvida ou estiver atrasada.
- Integridade dos Dados: As informações registradas no sistema devem ser precisas e atualizadas para evitar inconsistências nos relatórios e registros de empréstimos.

###### Arquivos

- banco.sql - Script do banco de dados.
- pom.xml - Arquivo de configuração da ferramenta de automação Maven.
- *.png - Arquivos de imagens do README.md.

###### Interfaces Gráficas

- Tela para Cadastrar Ferramentas:
  
![TelaCadastroFerramenta](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/f035e339-579c-4e04-b340-8a1d88fe5f09)

- Tela para Cadastrar Empréstimos:
  
![TelaCadastrarEmprestimo](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/b27860c3-2a33-40c7-afad-5158d06dd852)

- Tela para Cadastro de Amigo

![TelaCadastroAmigo](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/77172d23-7f53-47cf-842e-acd4de7adc3f)
