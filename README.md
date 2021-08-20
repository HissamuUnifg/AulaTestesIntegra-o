# AulaTestesIntegração
Repositório com código exemplo para aula de Testes Integração

Roteiro de Aula Testes de Integração automatizados;

 - clonar o repositório do github;
 - instalar o .jar mockito;
 - Apresentar a proposta do software (diagrama de classes);
   - incrementos ao software da aula de TDD: 
   - uso de banco de dados SQLite
   - classe GestorPagamentos, campos novos em Funcionario e FuncionarioDAO, classe BancoService
   - a classe GestorPagamentos gerencia o pagamento de todos os funcionários da empresa;
   - a classe BancoService atua como um mediator para um API bancária externa

 - A integração nos testes pode ser feita tanto em termos de módulos internos quanto externos;
   - modulos internos podemos citar o uso do BancoService injetado em GestorPagamentos e até mesmo o uso das classes Funcionario;
   - módulos externos podem ser vistos no exemplo com as classes de conexão ao banco de dados e a classe mediator de uma API bancária externa;

 - Usar o método main para verificar o funcionamento da classe GestorPagamentos. Criar funcionarios e executar o pagamento de todos. Os funcionários deverão ao fim estar com o campo pago marcado como 1;
 - questionar: Como testar caso de uma falha no pagamento?

 - Explicar o conceito de dublês de teste e mock junto com mockito.

 - demonstrar o funcionamento do mockito para alterar o comportamento tanto do banco de dados quanto do BancoService;
  - banco de dados: emular o funcionamento sem precisar de fato de um banco de dados;
  - BancoService: emular um erro no Serviço da API;

 - Passar para os alunos terminarem a implementação do método resetarPagamento usando TDD e Mockito para resetar a flag pago no banco de dados a cada novo mês. 
