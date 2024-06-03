# A3 Sistema de Empréstimo de Ferramentas

## Integrantes 

A3 2024/1
Carlos Henrique Lohn(owner)
Silvia Koch Fernandes
Murilo dos Santos Ferreira
Caue Rodrigues Fenn
José Henrique Lohn da Silva

### Contextualização

- Esta é uma versão do sistema para a IDE NetBeans.<br> 
- Os dados estão armazenados no banco de dados MySQL.<br>
- Este programa possui diversas classes organizada nos pacotes, principal, visao, dao e model.<br>
- A pasta src contêm os fontes do projeto.<br>
- A interface gráfica foi construída *com* o auxílio da IDE NetBeans.<br>

#### Banco de Dados

```
CREATE TABLE IF NOT EXISTS a3teste.ferramentas (
  idferramentas INT NOT NULL,
  nomeferramentas VARCHAR(150) NULL,
  preçoferramentas REAL NULL,
  marcaferramentas VARCHAR(50) NULL,
  PRIMARY KEY (idferramentas))
ENGINE = InnoDB

;CREATE TABLE IF NOT EXISTS a3teste.amigos (
  idtable1 INT NOT NULL,
  nomeamigos VARCHAR(200) NULL,
  telefoneamigos VARCHAR(50) NULL,
  emailamigos VARCHAR(50) NULL,
  PRIMARY KEY (idtable1))
ENGINE = InnoDB;
```

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

####### Regras de Negócio:

- Restrição de Acesso: Apenas o tio-avô deve ter acesso ao sistema, garantindo sua privacidade.
- Atualização de Cadastros: As informações sobre ferramentas e amigos devem ser facilmente atualizáveis para refletir mudanças na coleção de ferramentas ou na lista de amigos.
- Notificação de Devolução: O sistema deve notificar o tio-avô quando uma ferramenta emprestada for devolvida ou estiver atrasada.
- Integridade dos Dados: As informações registradas no sistema devem ser precisas e atualizadas para evitar inconsistências nos relatórios e registros de empréstimos.

######## Arquivos

- banco.sql - Script do banco de dados.
- pom.xml - Arquivo de configuração da ferramenta de automação Maven.
- *.png - Arquivos de imagens do README.md.
