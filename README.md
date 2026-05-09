# Enterprise E-Commerce Backend (Microservices)

Production-oriented Java 17 + Spring Boot microservices e-commerce backend with security, eventing, caching, and CI/CD.

## Services
- Config Server
- Discovery Service (Eureka)
- API Gateway
- User Service (JWT auth + RBAC)
- Product Service (MongoDB + Redis)
- Order Service (MySQL + Kafka)
- Payment Service (MySQL + Kafka)

## Tech Stack
Java 17, Spring Boot, Spring Security, MySQL, MongoDB, Redis, Kafka, Docker, GitHub Actions.

## Architecture Highlights
- Clean layered service structure (`controller`, `service`, `repository`, `dto`, `entity`, `config`).
- JWT + refresh-token design (starter endpoints included).
- Event-driven workflow stubs for order/payment/inventory notifications using Kafka.
- Redis strategy for product/session caching.
- Health checks via Spring Actuator.

## Run Locally
```bash
docker compose up -d
mvn clean verify
```

## CI/CD
Pipeline at `.github/workflows/ci-cd.yml` runs build/test and container build on push/PR.

## API Docs
Each service should expose OpenAPI at `/swagger-ui.html` after adding service-level springdoc dependency and controllers.

## AI Recommendations
Integrate OpenAI/Gemini in Product Service recommendation module using user behavior events from Kafka.
