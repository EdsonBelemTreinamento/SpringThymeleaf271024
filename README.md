# Projeto CRUD de Produtos com Spring MVC e JDBC

Este projeto implementa um sistema CRUD (Create, Read, Update, Delete) para gerenciar produtos utilizando Spring Boot e JDBC. Ele oferece uma interface para cadastrar, listar, editar e excluir produtos, com persistência de dados em um banco de dados MySQL.

## Estrutura do Projeto

- **Controller**: Contém a classe `ProdutoController`, que gerencia as requisições HTTP relacionadas aos produtos e controla as operações de CRUD.
- **Model**: Define a entidade `Produto`, com atributos `idProduto`, `nome`, `descricao` e `preco`.
- **Repository**: Implementa o acesso ao banco de dados com a classe `ProdutoDao`, que utiliza JDBC para realizar as operações de CRUD no banco MySQL.
- **DataSourceConfig**: Configuração do banco de dados, definindo a conexão com o MySQL.
- **View (Thymeleaf)**: Formulários HTML para criar, atualizar e listar produtos.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento do backend.
- **JDBC**: Conexão direta com o banco de dados MySQL.
- **Thymeleaf**: Motor de templates para renderizar as views.
- **MySQL**: Banco de dados para armazenar as informações dos produtos.

## Pré-requisitos

- Java 17 ou superior
- Banco de dados MySQL
- Maven

## Configuração do Banco de Dados

Para executar este projeto, você deve configurar uma base de dados MySQL com o seguinte nome e credenciais padrão (alteráveis no arquivo `DataSourceConfig`):

- URL: `jdbc:mysql://localhost:3306/bancosistema`
- Usuário: `root`
- Senha: `root1`

Crie a tabela `produto` com a seguinte estrutura:

```sql
CREATE TABLE produto (
    idProduto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao TEXT,
    preco DOUBLE
);
```

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/EdsonBelemTreinamento/projeto-crud-produto.git
   ```
2. Compile o projeto com Maven:
   ```bash
   mvn clean install
   ```
3. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints Principais

- **/produtos/novo**: Página para cadastrar um novo produto.
- **/produtos/gravar**: Salva o produto no banco de dados.
- **/produtos/listagem**: Lista todos os produtos cadastrados.
- **/produtos/altera/{id}**: Página para editar um produto específico.
- **/produtos/delete/{id}**: Exclui um produto com base no seu ID.

## Funcionalidades

- **Cadastro de Produto**: Permite criar novos produtos com nome, descrição e preço.
- **Listagem de Produtos**: Exibe a lista de produtos cadastrados.
- **Atualização de Produto**: Edita as informações de um produto específico.
- **Exclusão de Produto**: Remove um produto da base de dados.

## Exemplo de Uso

Acesse `http://localhost:8080/produtos/novo` para cadastrar um novo produto. Após salvar, o produto aparecerá na listagem em `http://localhost:8080/produtos/listagem`.

## Estrutura de Pastas

- `br.com.arq.controller`: Contém o controlador `ProdutoController`.
- `br.com.arq.model`: Define a entidade `Produto`.
- `br.com.arq.repository`: Contém a classe `ProdutoDao` para operações de banco de dados.
- `br.com.arq.database`: Configurações de conexão com o banco de dados MySQL.
- `src/main/resources/templates`: Contém as views Thymeleaf.

## Considerações Finais

Este projeto é um exemplo simples de CRUD com Spring MVC, JDBC e MySQL, ideal para quem deseja aprender sobre integração de banco de dados usando JDBC e desenvolvimento de aplicações web com Spring Boot e Thymeleaf.
