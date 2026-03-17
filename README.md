# FileManagement

A Spring Boot-based security and authentication application with JWT (JSON Web Token) support for user registration and login functionality.

## Overview

FileManagement is a Spring Boot application that provides secure authentication and authorization mechanisms using JWT tokens. It demonstrates best practices for implementing user registration, login, and token-based authentication in a modern Spring Boot application.

## Features

- **User Registration**: Create new user accounts with secure password encoding
- **User Login**: Authenticate users and receive JWT tokens
- **JWT Authentication**: Token-based authentication for securing API endpoints
- **Password Security**: Encrypted password storage using Spring Security's PasswordEncoder
- **Database Integration**: MySQL database for persistent user storage
- **RESTful API**: Clean REST API endpoints for authentication operations

## Tech Stack

### Core Framework
- **Spring Boot 4.0.3** - Latest Spring Boot framework
- **Java 21** - Modern Java version with latest features
- **Maven** - Build and dependency management

### Key Dependencies
- **Spring Data JPA** - Object-relational mapping and database operations
- **Spring Security** - Authentication and authorization framework
- **Spring Web MVC** - RESTful web service development
- **JWT (JJWT 0.13.0)** - JSON Web Token creation and validation
- **MySQL Connector** - MySQL database driver

### Testing
- Spring Boot Test dependencies for unit and integration testing

## Project Structure

```
src/main/java/com/mphasis/security/
├── SecurityApplication.java          # Main Spring Boot application entry point
├── controller/
│   └── AuthController.java          # REST endpoints for authentication
├── service/
│   └── AuthService.java             # Business logic for auth operations
├── model/
│   └── User.java                    # User entity model
├── repository/
│   └── UserRepository.java          # Data access layer
├── dto/
│   ├── LoginRequest.java            # Login request payload
│   ├── RegisterRequest.java         # Registration request payload
│   └── AuthResponse.java            # Authentication response payload
├── security/
│   └── JwtUtil.java                 # JWT token generation and validation
└── config/
    └── SecurityConfig.java          # Spring Security configuration
```

## API Endpoints

### Register User
- **Endpoint**: `POST /auth/register`
- **Request Body**:
```json
{
  "username": "user123",
  "password": "password123"
}
```
- **Response**: `User Registered Successfully`

### Login User
- **Endpoint**: `POST /auth/login`
- **Request Body**:
```json
{
  "username": "user123",
  "password": "password123"
}
```
- **Response**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Database Schema

### Users Table
- `id` (BIGINT, Primary Key, Auto-increment)
- `username` (VARCHAR, Unique)
- `password` (VARCHAR)

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/SagarBisht23/FileManagement.git
cd FileManagement
```

2. **Configure Database**
Create a MySQL database and update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/filemanagement
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. **Build the project**
```bash
mvn clean install
```

4. **Run the application**
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Usage Examples

### Register a New User
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "password": "secure_password123"
  }'
```

### Login to Get Token
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "password": "secure_password123"
  }'
```

## Security Features

- **Password Encoding**: Passwords are encrypted using BCrypt hashing algorithm
- **JWT Tokens**: Stateless authentication using JSON Web Tokens
- **Spring Security**: Integrated security framework for authorization

## Development

### Building for Development
```bash
mvn clean install -DskipTests
```

### Running Tests
```bash
mvn test
```

### Building for Production
```bash
mvn clean package
```

## Project Metadata
- **Group ID**: `com.mphasis`
- **Artifact ID**: `security`
- **Version**: `0.0.1-SNAPSHOT`

## License

This project is open source and available under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## Author

**Sagar Bisht**
- GitHub: [@SagarBisht23](https://github.com/SagarBisht23)

## Support

For issues, questions, or suggestions, please open an issue on the [GitHub repository](https://github.com/SagarBisht23/FileManagement/issues).
