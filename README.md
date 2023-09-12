## Projeto de Gerenciamento de Transações Financeiras

Este é um projeto de exemplo que demonstra um sistema simples de gerenciamento de transações financeiras usando Java com Spring Boot e Thymeleaf para o front-end. O projeto inclui recursos de autenticação, autorização e persistência de dados.

### Configuração e Execução

#### Pré-requisitos

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

#### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `financas`.

2. Atualize as configurações do banco de dados em `application.properties` no diretório `src/main/resources`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/financas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

#### Executando o Projeto

1. Clone este repositório para sua máquina local.

2. Navegue até o diretório raiz do projeto no terminal.

3. Execute o seguinte comando para construir o projeto:

```
mvn clean install
```

4. Em seguida, execute o projeto usando o seguinte comando:

```
mvn spring-boot:run
```

O projeto será executado localmente em `http://localhost:8080`.

### Funcionalidades Principais

- **Listagem de Transações Financeiras**: Acesse a página inicial em `http://localhost:8080/api/transacoes/listar` para visualizar todas as transações financeiras. O total das transações é exibido no rodapé da página.

- **Adicionar Transação Financeira**: Clique no botão "Adicionar Transação" na página de listagem para adicionar uma nova transação financeira. Preencha os detalhes da transação e clique em "Salvar".

- **Editar Transação Financeira**: Cada transação listada possui um link "Editar" que permite editar os detalhes da transação. Após fazer as alterações, clique em "Salvar" para atualizar a transação.

- **Excluir Transação Financeira**: Cada transação listada possui um link "Excluir" que permite excluir a transação.

### Estrutura do Projeto

- `TransacaoFinanceiraController`: Controlador que gerencia as operações relacionadas às transações financeiras.

- `TransacaoFinanceira`: Classe de modelo para representar uma transação financeira.

- `TransacaoFinanceiraRepository`: Interface de repositório para operações de banco de dados relacionadas às transações financeiras.

- `TransacaoFinanceiraService`: Serviço que contém a lógica de negócios relacionada às transações financeiras.

- Páginas HTML Thymeleaf no diretório `src/main/resources/templates`: Essas páginas são usadas para renderizar a interface do usuário para adicionar, editar e listar transações financeiras.

