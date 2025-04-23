# 🛡️ JWT Authentication API with Spring Boot

A secure REST API built with Spring Boot that provides JWT-based authentication and authorization. It supports user registration, login, and access to protected endpoints.

---

## ✨ Highlights

- Implements complete login + registration flow using JWTs
- Demonstrates token parsing and filter chaining in Spring Security
- Shows secure password storage with BCrypt
- Uses modern Spring practices (Beans, Filters, Config)
- Lightweight, extensible, and production-ready pattern

## 📁 Project Structure

```
com.jwtAuthProj.demo
│
├── auth/                  # Authentication layer
│   ├── AuthenticationController.java
│   ├── AuthenticationRequest.java
│   ├── AuthenticationResponse.java
│   ├── AuthenticationService.java
│   ├── RegisterRequest.java
│
├── config/                # Security and JWT configuration
│   ├── ApplicationConfig.java
│   ├── JwtAuthenticationFilter.java
│   ├── JwtService.java
│   ├── SecurityConfiguration.java
│
├── demo/                  # Protected sample controller
│   └── DemoController.java
│
├── user/                  # User entity (not shown here, assumed)
│   ├── User.java
│   ├── Role.java
│   └── UserRepository.java
```

---

## 🚀 Features

- ✅ User Registration with password hashing
- ✅ User Login with email/password
- ✅ JWT Token generation and validation
- ✅ Stateless session management (no server-side sessions)
- ✅ Global request filtering for token validation
- ✅ Protected endpoint requiring JWT
- ✅ Built-in BCrypt password encryption

---

## 🧪 API Endpoints

### 🔓 Public Endpoints

| Method | URL                       | Description              |
|--------|---------------------------|--------------------------|
| POST   | `/api/v1/auth/register`   | Register a new user      |
| POST   | `/api/v1/auth/authenticate` | Login and get JWT      |

**Request Format:**
- `RegisterRequest`: 
```json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

- `AuthenticationRequest`: 
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

**Response Format:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

---

### 🔐 Secured Endpoints

| Method | URL                          | Description                    |
|--------|------------------------------|--------------------------------|
| GET    | `/api/v1/demo-controller`    | Returns "Hello World..." (JWT required) |

**Headers**:
```
Authorization: Bearer <your_token>
```

---

## ⚙️ Configuration

### 🔐 JWT Secret Key

The JWT secret is defined in `JwtService.java` as a base64-encoded HMAC key.

### 🔧 Authentication Setup

- **`ApplicationConfig.java`**:
  - Provides beans: `UserDetailsService`, `AuthenticationManager`, and `PasswordEncoder`.

- **`SecurityConfiguration.java`**:
  - Disables CSRF
  - Allows unauthenticated access to `/auth/**`
  - Requires JWT for all other endpoints

- **`JwtAuthenticationFilter.java`**:
  - Intercepts requests
  - Validates token
  - Sets Spring Security context

---

## 🧰 Technologies Used

- Spring Boot
- Spring Security
- JWT (via `jjwt`)
- Lombok
- BCrypt Password Encoding
- Maven

---

## 🛠️ Running the App

### 📦 Prerequisites
- Java 17+
- Maven
- Spring Boot-compatible IDE (e.g., IntelliJ)

### ▶️ Run Locally
```bash
mvn clean install
mvn spring-boot:run
```

---

## 🧪 Testing the API

### Register
```bash
curl -X POST http://localhost:8080/api/v1/auth/register \
-H "Content-Type: application/json" \
-d '{"firstname":"John", "lastname":"Doe", "email":"john@example.com", "password":"1234"}'
```

### Authenticate
```bash
curl -X POST http://localhost:8080/api/v1/auth/authenticate \
-H "Content-Type: application/json" \
-d '{"email":"john@example.com", "password":"1234"}'
```

### Access Secure Endpoint
```bash
curl -X GET http://localhost:8080/api/v1/demo-controller \
-H "Authorization: Bearer <your_token_here>"
```

---

## 👨‍💻 Author

Built by Arjun Janakiraman  
🔗 [GitHub](https://github.com/arjunj05)  
📫 ajanakiraman7@gatech.edu

---

## 📜 License

MIT License
