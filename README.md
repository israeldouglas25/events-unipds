# events

Projeto Spring Boot (Maven) para gerenciamento de conferências, sessões, inscrições e usuários.

## Visão geral
- Pacote base: `br.com.israel.events`
- Classe principal: `EventsApplication.java`
- Funcionalidades: autenticação JWT, CRUD de conferências, sessões, inscrições e usuários.

## Estrutura importante
- `src/main/java/br/com/israel/events/config` - configurações (ex.: SpringDoc)
- `src/main/java/br/com/israel/events/controllers` - endpoints REST (`AuthenticationController`, `ConferenceController`, `SessionController`, `SubscriptionController`, `UserController`)
- `src/main/java/br/com/israel/events/domain` - entidades de domínio (`Conference`, `Session`, `Subscription`, `User`, `SubscriptionID`)
- `src/main/java/br/com/israel/events/services` - lógica de negócio (submódulos: `authentication`, `conference`, `session`, `subscription`, `user`)
- `src/main/java/br/com/israel/events/interfaces` - repositórios (Spring Data)
- `src/main/java/br/com/israel/events/security` - configuração JWT e filtros
- `src/main/java/br/com/israel/events/exceptions` - tratamento de erros centralizado

## Requisitos
- JDK 17+ (ou versão do projeto)
- Maven 3.6+
- Banco de dados configurado via `application.yaml` (MySQL)
- Docker (Docker-compose)

## Docker

- É necessário ter o `Docker` instalado (Windows: instalar `Docker Desktop`) e em execução.
- Verificar se o Docker está rodando:
    - `docker info`
- Iniciar os containers do projeto (se houver `docker-compose.yml` ou `docker-compose` integrado):
    - `docker compose up -d`
    - alternativa (versões antigas): `docker-compose up -d`
- Parar e remover os containers do projeto:
    - `docker compose down`
    - alternativa: `docker-compose down`
- Windows (opção): abrir `Docker Desktop` pela interface do sistema (ícone na barra) para iniciar/parar o serviço do Docker.

## Rodando localmente (Windows)
1. Abrir o projeto no IntelliJ IDEA 2025.3.1.1.
2. Build do projeto: `mvn clean install`
3. Rodar a aplicação:
    - Pela IDE: executar `EventsApplication.java`
    - Pelo terminal: `mvn spring-boot:run`

## Comandos úteis
- Build: `mvn clean package`
- Rodar: `mvn spring-boot:run`
- Testes: `mvn test`
- Gerar jar: `mvn clean package` (artefato em `target/`)

## Links úteis
- phpMyAdmin: `http://localhost:8081/index.php`
- Swagger: `http://localhost:8080/swagger-ui.html`

## Documentação da API
- A configuração de OpenAPI/SpringDoc está em `config/SpringDocConfigurations.java`.
- Endpoints de documentação:
    - `/v3/api-docs`
    - `/swagger-ui.html` ou `/swagger-ui/index.html`

## Autenticação
- Autenticação via JWT (ver `security` e `authentication`).
- Endpoint de login/geração de token está em `AuthenticationController`.
- Para endpoints protegidos, enviar header:
    - `Authorization: Bearer <token>`

## Tratamento de erros
- Exceções customizadas em `exceptions` (`NotFoundException`, `BadRequestException`, `ForbiddenException`) e handler global em `GlobalExceptionHandler`.

## Observações
- Verifique as classes de serviço e repositório para regras de negócio e constraints (`ISessionService`, `IConferenceService`, `ISubscriptionService`, `IUserService`).
- Adaptar `application.properties` para o ambiente desejado antes de executar.

## Contato
- Gmail: `israeldouglas25@gmail.com`
- Hotmail: `israeldouglas25@hotmail.com`
- Linkedin: `https://www.linkedin.com/in/israeldouglas25/`
