# SpringBoot-Ecommerce-Rest-API

A RESTful e-commerce backend built with **Spring Boot 4** and **Java 25**, featuring product catalog management, category associations, order processing, and payment tracking. Database migrations are managed with **Flyway**, and the API is documented with **Swagger/OpenAPI**.

## Tech Stack

- **Java 25**
- **Spring Boot 4.1.1**
    - Spring Web MVC
    - Spring Data JPA (Hibernate)
- **PostgreSQL** (serverless Postgres)
- **H2** (in-memory database for tests)
- **Flyway** - database schema migrations
- **springdoc-openapi** - Swagger UI / OpenAPI documentation
- **Maven** - build and dependency management
- **Docker** - containerized deployment
- **Render** - cloud hosting

## Domain Model

The API models a simple e-commerce domain:

| Entity | Description |
|---|---|
| `User` | Customers who place orders |
| `Product` | Items available for purchase, linked to one or more categories |
| `Category` | Product categories (many-to-many with `Product`) |
| `Order` | A purchase made by a `User`, with a status (`WAITING_PAYMENT`, `PAID`, `SHIPPED`, `DELIVERED`, `CANCELED`) |
| `OrderItem` | Line items within an `Order`, linking a `Product` with quantity and price |
| `Payment` | Payment record for a completed `Order` (one-to-one) |

## Getting Started

### Prerequisites

- JDK 25
- Maven (or use the included `mvnw` wrapper)
- A PostgreSQL database

### Clone the repository

```bash
git clone https://github.com/Loyius/SpringBoot-Ecommerce-Rest-API.git
```

### Configure environment

This project uses Spring profiles to separate configuration per environment:

| Profile | Purpose | Database |
|---|---|---|
| `dev` | Local development | PostgreSQL (Neon) |
| `test` | Automated tests | H2 (in-memory) |
| `prod` | Production deployment | PostgreSQL (Neon), via environment variables |

Create `src/main/resources/application-dev.properties` with your own database credentials:

```properties
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://DB_HOST/DB?sslmode=require&channel_binding=require
spring.datasource.username={$DB_USERNAME}
spring.datasource.password={$DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```
it can be found a demo of the file in "application-dev.properties.example"

### Run locally

```bash
./mvnw spring-boot:run "-Dspring-boot.run.profiles=dev"
```

### Run tests

```bash
./mvnw test
```

## Database Migrations

Schemas:

- `V1__create_tables.sql` - initial schema
- `V2__seed_data.sql` - sample data (users, products, categories, orders)

## API Documentation

Once the application is running, interactive API documentation is available via Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

The raw OpenAPI spec is available at:

```
http://localhost:8080/v3/api-docs
```

### Build the Docker image locally

```bash
docker build -t
docker run -p 8080:8080
```

## Project Structure

```
src/main/java/com/loyius/course/
├── entities/           # JPA entities (User, Product, Category, Order, ...)
├── repositories/       # Spring Data JPA repositories
├── services/           # Business logic
│   └── exceptions/     # Custom service exceptions
├── resources/          # REST controllers
│   └── exceptions/     # Global exception handling
└── config/             # Application test configuration

src/main/resources/
├── db/migration/
├── application.properties
├── application-prod.properties
├── application-dev.properties.example
└── application-test.properties
```