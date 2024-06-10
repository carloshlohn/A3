# A3 Sistema de Empréstimo de Ferramentas

## Integrantes 

A3 2024/1

Carlos Henrique Lohn(owner) -> carloshlohn, carlo, 1072410683 (RA)

Silvia Koch Fernandes -> Asus, silviakochf, 1072416359 (RA)

Murilo dos Santos Ferreira -> Muri8973, 1072416485 (RA)

Caue Rodrigues Fenn -> CaueFenn, CaueR 10724112205 (RA)

José Henrique Lohn da Silva -> JoseHL0hn, 10724112626 (RA)


### Contextualização

- Esta é uma versão do sistema para a IDE NetBeans.<br> 
- Os dados estão armazenados no banco de dados MySQL.<br>
- Este programa possui diversas classes organizada nos pacotes, principal, visao, dao e model.<br>
- A pasta src contêm os fontes do projeto.<br>
- A interface gráfica foi construída com o auxílio da IDE NetBeans.<br>

#### Banco de Dados

```
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
;
```

##### Requisitos Funcionais

- RF001 - Cadastro de Ferramentas: O sistema deve permitir o cadastro de ferramentas, incluindo nome, marca e custo de aquisição.
- RF002 - Cadastro de Amigos: Deve ser possível cadastrar amigos, fornecendo nome e telefone.
- RF003 - Registro de Empréstimos: Os empréstimos de ferramentas devem ser registrados, associando uma ou mais ferramentas a um amigo, e incluindo datas de empréstimo e devolução.
- RF004 - Relatórios de Ferramentas: O sistema deve gerar relatórios que exibam as ferramentas cadastradas e o total gasto com aquisições.
- RF005 - Relatórios de Empréstimos: Devem ser gerados relatórios de empréstimos ativos e de todos os empréstimos realizados, incluindo informações sobre quando foi emprestado e se foi devolvido.
- RF006 - Verificação de Empréstimos Pendentes:* Ao realizar um novo empréstimo, o sistema deve verificar se o amigo ainda tem ferramentas emprestadas e notificar sobre isso.
- RF007 - Integração com Google Agenda: O sistema deve integrar-se com o Google Agenda para compartilhar lembretes para devolução das ferramentas por e-mail.

###### Requisitos Não Funcionais:

- RNF001 - Localidade: O software deve ser instalado e executado localmente no computador do tio-avô.
- RNF002 - Usabilidade: A interface do usuário deve ser intuitiva e fácil de usar, considerando o público-alvo que pode não ter experiência técnica.
- RNF003 - Desempenho: O sistema deve ser responsivo e eficiente, mesmo com grandes volumes de dados.
- RNF004 - Segurança: Deve garantir a segurança dos dados armazenados localmente, incluindo medidas de backup e proteção contra acesso não autorizado.
- RNF005 - Privacidade: O sistema deve garantir a privacidade de todos os dados pessoais armazenados no banco de dados.

###### Regras de Negócio:

- RN001 - Restrição de Acesso: Apenas o tio-avô deve ter acesso ao sistema, garantindo sua privacidade.
- RN002 - Atualização de Cadastros: As informações sobre ferramentas e amigos devem ser facilmente atualizáveis para refletir mudanças na coleção de ferramentas ou na lista de amigos.
- RN003 - Notificação de Devolução: O sistema deve notificar o tio-avô quando uma ferramenta emprestada for devolvida ou estiver atrasada.
- RN004 - Integridade dos Dados: As informações registradas no sistema devem ser precisas e atualizadas para evitar inconsistências nos relatórios e registros de empréstimos.

###### Arquivos

- banco.sql - Script do banco de dados.
- pom.xml - Arquivo de configuração da ferramenta de automação Maven.
- *.png - Arquivos de imagens do README.md.

###### Interfaces Gráficas

- Tela do Menu Principal:

![TelaMenuPrincipalSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/e35accd3-a092-4951-886e-2c0d89eaaaa4)

- Tela para Cadastrar Ferramentas:
  
![TelaCadastroFerramentaSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/0b0a6c7f-a3d5-445d-9fc0-2c61bf13905a)

- Tela para Cadastrar Empréstimos:
  
![TelaCadastroEmprestimoSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/21c91ccc-b335-4d09-a146-04d0879eb1d8)

- Tela para Cadastro de Amigo:

![TelaCadastroDeAmigosSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/d0e423db-4553-4dcc-8da9-db47b5f8efe4)

- Tela para Gerenciar Ferramentas:

![TelaGerenciaFerramentaSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/71eb5744-a788-4ad2-82a6-09e4947ab908)

- Tela para Gerenciar Empréstimos:

![TelaGerenciaEmprestimosSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/2b336300-3a1a-4a84-889d-144c55887222)

- Tela para Gerenciar Amigos:

![TelaGerenciaAmigosSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/a80ab3d8-89fd-4b37-8448-862f6f283673)

- Tela de Relatório de Ferramentas:

![TelaRelatorioFerramentasSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/430ebfe5-0a04-4574-8839-bd72b2ddf532)

- Tela de Relatório de Emprestimos:

![TelaRelatorioEmprestimosSEF](https://github.com/carloshlohn/SistemaEmprestimoFerramentas/assets/165094807/ceeb7bd8-b2a7-4218-b312-141308d05da5)
