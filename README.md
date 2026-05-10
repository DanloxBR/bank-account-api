<div align="center">

# 💳 Banking API

### API REST Bancária Segura desenvolvida com Java + Spring Boot

<p align="center">

<img src="https://img.shields.io/badge/Java-8-red?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring_Boot-2.7-success?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql" />
<img src="https://img.shields.io/badge/JWT-Autenticação-orange?style=for-the-badge" />
<img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />

</p>

---

### 🚀 Backend bancário completo com autenticação JWT, gerenciamento de contas e operações financeiras.

</div>

---

# 📖 Sobre o Projeto

Este projeto simula um sistema bancário digital moderno utilizando tecnologias e padrões de arquitetura utilizados no mercado.

A API permite operações financeiras seguras como:

- Autenticação de usuários
- Gerenciamento de contas
- Depósitos
- Saques
- Transferências
- Extrato bancário

O projeto foi desenvolvido com foco em:

✅ Segurança  
✅ Escalabilidade  
✅ Arquitetura Limpa  
✅ Boas Práticas REST  
✅ Manutenibilidade  

---

# ✨ Funcionalidades

## 🔐 Autenticação & Segurança

- Autenticação JWT
- Spring Security
- Criptografia de senha com BCrypt
- Rotas protegidas
- Autenticação Stateless

---

## 👤 Gerenciamento de Usuários

- Cadastro de usuários
- Login de usuários

---

## 🏦 Gerenciamento de Contas

- Criação de contas bancárias
- Consulta de saldo

---

## 💸 Operações Financeiras

- Depósito
- Saque
- Transferência entre contas

---

## 📄 Sistema de Extrato

- Histórico de transações
- Extrato bancário

---

# 🛠 Tecnologias Utilizadas

<div align="center">

| Tecnologia | Descrição |
|---|---|
| ☕ Java 8 | Linguagem Backend |
| 🌱 Spring Boot | Framework Principal |
| 🔒 Spring Security | Autenticação e Autorização |
| 🔑 JWT | Autenticação via Token |
| 🐘 PostgreSQL | Banco de Dados Relacional |
| 🗃 Spring Data JPA | ORM |
| 🔥 Hibernate | Persistência |
| 📦 Maven | Gerenciamento de Dependências |
| ⚡ Lombok | Redução de Boilerplate |
| ✅ Bean Validation | Validação de Dados |

</div>

---

# 📁 Estrutura do Projeto

```text
src/main/java/com/danieldev/api
│
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── repository
├── service
└── security
```

---

# 🔐 Autenticação

A API utiliza autenticação JWT.

Após realizar login, envie o token em todas as rotas protegidas:

```http
Authorization: Bearer SEU_TOKEN
```

---
# 🔑 Autenticação

## Login

```http
POST /auth/login
```

### Request

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

### Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# 👤 Usuários

## Criar Usuário

```http
POST /usuarios
```

### Request

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

---

# 🏦 Contas

## Criar Conta

```http
POST /contas
```

### Request

```json
{
  "numeroConta": "123",
  "saldo": 1000,
  "usuarioId": 1
}
```

---

## Consultar Saldo

```http
GET /contas/{numeroConta}/saldo
```

### Exemplo

```http
GET /contas/123/saldo
```

---

# 💰 Transações

## Depósito

```http
POST /transacoes/deposito
```

### Request

```json
{
  "numeroConta": "123",
  "valor": 500
}
```

---

## Saque

```http
POST /transacoes/saque
```

### Request

```json
{
  "numeroConta": "123",
  "valor": 100
}
```

---

## Transferência

```http
POST /transacoes/transferencia
```

### Request

```json
{
  "contaOrigem": "123",
  "contaDestino": "456",
  "valor": 200
}
```

---

# 📄 Extrato Bancário

## Consultar Extrato

```http
GET /extratos/{numeroConta}
```

### Exemplo

```http
GET /extratos/123
```

---

# ⚙️ Variáveis de Ambiente

Configure as seguintes variáveis:

```env
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

jwt.secret=${JWT_SECRET}
jwt.expiration=86400000

spring.mvc.pathmatch.matching-strategy=ant_path_matcher

```

---

# 🗄 Configuração do Banco

## Criar Banco PostgreSQL

```sql
CREATE DATABASE banking_db;
```

---

# ▶️ Executando o Projeto

## Clonar Repositório

```bash
git clone https://github.com/DanloxBR/bank-account-api.git
```

---

## Entrar na Pasta

```bash
cd bank-account-api
```

---

## Instalar Dependências

```bash
mvn clean install
```

---

## Executar Aplicação

```bash
mvn spring-boot:run
```

---

# 📬 Testando a API

Você pode testar utilizando:

- Postman
- Swagger

---

# 🔒 Recursos de Segurança

✅ Criptografia BCrypt  
✅ Autenticação JWT  
✅ Rotas Protegidas  
✅ Segurança Stateless  
✅ Tratamento de Validações  

---

# 🧠 Conceitos Aplicados

- API RESTful
- Princípios SOLID
- DTO Pattern
- Arquitetura em Camadas
- Injeção de Dependência
- Tratamento de Exceções
- Gerenciamento de Transações

---

<div align="center">

# 👨‍💻 Autor

## Daniel Oliveira

### Desenvolvedor Backend Java

🔗 GitHub  
https://github.com/DanloxBR

---

# ⭐ Contribuição

Contribuições, issues e sugestões são bem-vindas.

Sinta-se à vontade para abrir um Pull Request.

---

# 📄 Licença

Este projeto está sob a licença MIT.

</div>
