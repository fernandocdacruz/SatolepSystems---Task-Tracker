# 📝 Task Tracker API

API RESTful para gerenciamento de tarefas e produtividade, desenvolvida com **Java 17** e **Spring Boot 3**. A aplicação oferece autenticação/autorização segura com tokens JWT, persistência em banco PostgreSQL, controle de migrações com Flyway, documentação interativa via OpenAPI (Swagger) e infraestrutura pronta para produção com Docker.

---

## 🚀 Tecnologias Utilizadas

* **Linguagem & Framework:** Java 17, Spring Boot 3.3 (Spring Security, Spring Data JPA, Spring Validation)
* **Autenticação & Segurança:** Spring Security, JWT (Java JWT - Auth0), BCrypt Password Encoder
* **Banco de Dados:** PostgreSQL, Flyway Migration
* **Containerização:** Docker, Docker Compose (Multi-Stage Build leve com Alpine)
* **Integração Externa:** RestClient (integração resiliente com API externa de conselhos/dicas com fallback)
* **Documentação:** OpenAPI 3 / Swagger UI
* **Build Tool:** Maven

---

## 🏗️ Arquitetura e Destaques Técnicos

* **Arquitetura em Camadas:** Separação clara de responsabilidades com Controllers, Services, Repositories, DTOs (Records) e Mappers explícitos.
* **Segurança Granular:** Controle de acesso por funções (`ROLE_USER` e `ROLE_ADMIN`) e comunicação Stateless.
* **Tratamento Global de Exceções:** Retornos estruturados (`@RestControllerAdvice`) para erros de validação, autenticação e regras de negócio.
* **Containerização Otimizada:** Dockerfile em multi-stage build executando em ambiente não-root para maior segurança.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
* [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/) instalados no seu sistema.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/task-tracker.git](https://github.com/seu-usuario/task-tracker.git)
   cd task-tracker

Suba os containers (Aplicação + PostgreSQL):

Bash
docker-compose up -d --build
Acesse os serviços:

API Base: http://localhost:8080

Documentação Swagger UI: http://localhost:8080/swagger-ui.html

📚 Endpoints Principais

Categoria	Método	Endpoint	Descrição	Acesso
Autenticação	POST	/auth/login	Autentica usuário e retorna o Token JWT	Público
Autenticação	POST	/auth/register	Cadastra um novo usuário no sistema	Público
Tarefas	GET	/tasks	Lista todas as tarefas do usuário	Autenticado
Tarefas	POST	/tasks	Cria uma nova tarefa	Autenticado
Tarefas	PUT	/tasks/{id}	Atualiza os dados de uma tarefa existente	Autenticado
Tarefas	DELETE	/tasks/{id}	Remove uma tarefa do sistema	Autenticado / Admin

🔒 Variáveis de Ambiente
As configurações de ambiente são gerenciadas através do docker-compose.yml:

SPRING_PROFILES_ACTIVE: Perfil de execução (prod / dev)

SPRING_DATASOURCE_URL: URL de conexão JDBC do PostgreSQL

SPRING_DATASOURCE_USERNAME: Usuário do banco de dados

SPRING_DATASOURCE_PASSWORD: Senha do banco de dados

API_SECURITY_TOKEN_SECRET: Chave secreta de assinatura do JWT

✒️ Autor
Desenvolvido por Fernando Campos da Cruz.

GitHub: @seu-usuario

LinkedIn: Fernando Campos da Cruz


---

### 💻 Como salvar no seu projeto pelo terminal:

1. Vá até a pasta do seu projeto no terminal Linux:
   ```bash
   cd /caminho/para/o/seu/projeto/task-tracker
Crie ou abra o arquivo README.md (pode ser com nano README.md ou code README.md se usar VS Code).

Cole o conteúdo do código acima, salve e feche.

Envie para o GitHub:

Bash
git add README.md
git commit -m "docs: adiciona README.md estruturado"
git push origin main