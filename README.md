# Site de Vendas

## Descrição

Este é um projeto de um sistema de vendas desenvolvido em Java com o framework Spring Boot. O sistema oferece uma plataforma completa para gerenciar vendas, clientes, produtos e vendedores.

## Funcionalidades

- Cadastro de Clientes: Registre informações detalhadas sobre os clientes, incluindo nome, endereço e detalhes de contato.

- Cadastro de Produtos: Mantenha um catálogo de produtos, incluindo informações como nome, descrição, preço e quantidade em estoque.

- Cadastro de Vendedores: Gerencie uma lista de vendedores com detalhes pessoais e informações de contato.

- Registro de Vendas: Realize vendas, associando clientes, produtos e vendedores. A quantidade vendida é subtraída automaticamente do estoque.

## Requisitos

- Java 11 ou superior
- Maven
- Banco de Dados (por exemplo, MySQL)

## Como Executar

1. Clone este repositório:


git clone https://github.com/seu-usuario/site-de-vendas.git


2. Configure as propriedades do banco de dados no arquivo `src/main/resources/application.properties`.

3. Execute o aplicativo:


mvn spring-boot:run


O aplicativo estará disponível em `http://localhost:8080`.

## Contribuição

Se você deseja contribuir:

1. Faça um fork deste repositório.
2. Crie uma nova branch para sua feature ou correção de bug.
3. Faça as alterações e faça commit.
4. Faça push para a branch.
5. Crie um Pull Request explicando suas alterações.

## Licença

Licenciado sob a licença MIT - veja [LICENSE](LICENSE) para mais detalhes.


Certifique-se de substituir `"seu-usuario"` na URL do clone pelo seu nome de usuário no GitHub. Isso é um texto completo para copiar e colar em seu repositório.
