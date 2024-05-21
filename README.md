# A3 emprestimo
A3 2024/1
Carlos Henrique Lohn(owner)
Silvia Koch Fernandes
Murilo dos Santos Ferreira
Caue Rodrigues Fenn
José Henrique Lohn da Silva
- Requisitos Funcionais


RF001 - *Cadastro de Ferramentas:* O sistema deve permitir o cadastro de ferramentas, incluindo nome, marca e custo de aquisição.

RF002 - *Cadastro de Amigos:* Deve ser possível cadastrar amigos, fornecendo nome e telefone.

RF003 - *Registro de Empréstimos:* Os empréstimos de ferramentas devem ser registrados, associando uma ou mais ferramentas a um amigo, e incluindo datas de empréstimo e devolução.

RF004 - *Relatórios de Ferramentas:* O sistema deve gerar relatórios que exibam as ferramentas cadastradas e o total gasto com aquisições.

RF005 - *Relatórios de Empréstimos:* Devem ser gerados relatórios de empréstimos ativos e de todos os empréstimos realizados, incluindo informações sobre quando foi emprestado e se foi devolvido.

RF006 - *Verificação de Empréstimos Pendentes:* Ao realizar um novo empréstimo, o sistema deve verificar se o amigo ainda tem ferramentas emprestadas e notificar sobre isso.

RF007 - *Integração com Google Agenda:* O sistema deve integrar-se com o Google Agenda para compartilhar lembretes para devolução das ferramentas por e-mail.


- Requisitos Não Funcionais:

  
RNF001 - *Localidade:* O software deve ser instalado e executado localmente no computador do tio-avô.

RNF002 - *Usabilidade:* A interface do usuário deve ser intuitiva e fácil de usar, considerando o público-alvo que pode não ter experiência técnica.

RNF003 - *Desempenho:* O sistema deve ser responsivo e eficiente, mesmo com grandes volumes de dados.

RNF004 - *Segurança:* Deve garantir a segurança dos dados armazenados localmente, incluindo medidas de backup e proteção contra acesso não autorizado.

RNF005 - *Privacidade:* O sistema deve garantir a privacidade de todos os dados pessoais armazenados no banco de dados.


- Regras de Negócio:

  
RN001 - *Restrição de Acesso:* Apenas o tio-avô deve ter acesso ao sistema, garantindo sua privacidade.

RN002 - *Atualização de Cadastros:* As informações sobre ferramentas e amigos devem ser facilmente atualizáveis para refletir mudanças na coleção de ferramentas ou na lista de amigos.

RN003 - *Notificação de Devolução:* O sistema deve notificar o tio-avô quando uma ferramenta emprestada for devolvida ou estiver atrasada.

RN004 - *Integridade dos Dados:* As informações registradas no sistema devem ser precisas e atualizadas para evitar inconsistências nos relatórios e registros de empréstimos.

- BD

User: root

Passaward: lohnaldoN9!
