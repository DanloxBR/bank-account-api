<div align="center">

# 💳 Banking API

### Secure Digital Banking REST API built with Java + Spring Boot

<p align="center">

<img src="https://img.shields.io/badge/Java-8-red?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring_Boot-2.7-success?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql" />
<img src="https://img.shields.io/badge/JWT-Authentication-orange?style=for-the-badge" />
<img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />

</p>

---

### 🚀 A complete backend banking system with authentication, transactions, and account management.

</div>

---

# 📖 Overview

This project simulates a modern digital banking backend using enterprise-level technologies and architecture patterns.

The API provides secure financial operations such as:

- User Authentication
- Account Management
- Deposits
- Withdrawals
- Transfers
- Bank Statements

Built with focus on:

✅ Security  
✅ Scalability  
✅ Clean Architecture  
✅ RESTful Principles  
✅ Maintainability  

---

# ✨ Features

## 🔐 Authentication & Security

- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- Protected Routes
- Stateless Authentication

---

## 👤 User Management

- User Registration
- User Authentication

---

## 🏦 Account Management

- Create Bank Account
- Balance Inquiry

---

## 💸 Financial Operations

- Deposit
- Withdraw
- Transfer Between Accounts

---

## 📄 Statement System

- Transaction History
- Bank Statement

---

# 🛠 Tech Stack

<div align="center">

| Technology | Description |
|---|---|
| ☕ Java 8 | Backend Language |
| 🌱 Spring Boot | Main Framework |
| 🔒 Spring Security | Authentication & Authorization |
| 🔑 JWT | Token Authentication |
| 🐘 PostgreSQL | Relational Database |
| 🗃 Spring Data JPA | ORM |
| 🔥 Hibernate | Persistence |
| 📦 Maven | Dependency Management |
| ⚡ Lombok | Boilerplate Reduction |
| ✅ Bean Validation | Request Validation |

</div>

---

# 📁 Project Structure

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

# 🔐 Authentication

This API uses JWT Authentication.

After login, include the token in all protected requests:

```http
Authorization: Bearer YOUR_TOKEN
```

---

# 📌 API Endpoints

# 🔑 Authentication

## Login

```http
POST /auth/login
```

### Request

```json
{
  "email": "user@email.com",
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

# 👤 Users

## Create User

```http
POST /usuarios
```

### Request

```json
{
  "email": "user@email.com",
  "senha": "123456"
}
```

---

# 🏦 Accounts

## Create Account

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

## Get Balance

```http
GET /contas/{numeroConta}/saldo
```

### Example

```http
GET /contas/123/saldo
```

---

# 💰 Transactions

## Deposit

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

## Withdraw

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

## Transfer

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

# 📄 Bank Statement

## Get Statement

```http
GET /extratos/{numeroConta}
```

### Example

```http
GET /extratos/123
```

---

# ⚙️ Environment Variables

Configure the following environment variables:

```env
DB_URL=jdbc:postgresql://localhost:5432/banking_db
DB_USERNAME=postgres
DB_PASSWORD=your_password

JWT_SECRET=your_secret_key
```

---

# 🗄 Database Setup

## Create PostgreSQL Database

```sql
CREATE DATABASE banking_db;
```

---

# ▶️ Running the Project

## Clone Repository

```bash
git clone https://github.com/DanloxBR/bank-account-api.git
```

---

## Enter Project Folder

```bash
cd bank-account-api
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

---

# 📬 API Testing

You can test the API using:

- Postman
- Insomnia
- Swagger (future implementation)

---

# 🔒 Security Features

✅ BCrypt Password Encryption  
✅ JWT Authentication  
✅ Protected Endpoints  
✅ Stateless Security  
✅ Validation Handling  

---

# 🧠 Software Engineering Concepts

- RESTful API Design
- SOLID Principles
- DTO Pattern
- Layered Architecture
- Dependency Injection
- Exception Handling
- Transaction Management

---

# 🚀 Future Improvements

- Refresh Token
- Swagger/OpenAPI
- Docker Support
- Redis Cache
- Kafka Integration
- RabbitMQ
- CI/CD Pipeline
- Unit Tests
- Integration Tests
- Role-Based Authorization
- Monitoring & Observability
- Microservices Architecture

---

<div align="center">

# 👨‍💻 Author

## Daniel Oliveira

### Backend Java Developer

🔗 GitHub  
https://github.com/DanloxBR

---

# ⭐ Contributing

Contributions, issues, and feature requests are welcome.

Feel free to fork this repository and submit a pull request.

---

# 📄 License

This project is licensed under the MIT License.

</div>
