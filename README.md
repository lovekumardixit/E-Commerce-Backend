# Enterprise E-Commerce Backend Platform

Production-focused microservices backend inspired by Amazon/Flipkart architecture using Java 17, Spring Boot, Spring Security, MySQL, MongoDB, Redis, Kafka, Docker, and GitHub Actions.

## Microservices
- config-server (port 8888)
- discovery-service (port 8761)
- api-gateway (port 8080)
- user-service (port 8081)
- product-service (port 8082)
- order-service (port 8083)
- payment-service (port 8084)
- notification-service (port 8085)

## Enterprise Capabilities (Implemented Foundation)
- Multi-module Maven architecture with service isolation.
- Gateway route aggregation for auth/user/product/order/payment APIs.
- User registration baseline with BCrypt password encryption and role fields.
- JWT-ready auth contract with access + refresh token response shape.
- Product, order, payment business workflow endpoints (starter implementation).
- Dockerized infra stack: MySQL, MongoDB, Redis, Kafka, Zookeeper.
- CI/CD workflow for build/test and container build.

## Planned/Extensible Components
- Full JWT issuance/validation + refresh token persistence.
- Cart, wishlist, address management, order history, invoices.
- Product variants/reviews/inventory with low-stock events.
- Kafka event producers/consumers for order-payment-notification choreography.
- Redis cache-aside for product/search/session performance.
- OpenAPI, Postman collections, and integration/security test suites.
- AI recommendation engine module with OpenAI/Gemini integration.

## Local Run
```bash
docker compose up -d
mvn -B -ntp clean verify
````

## CI/CD
`.github/workflows/ci-cd.yml`:
- Build
- Test
- Docker image build

## Recruiter-grade next steps
1. Add domain-complete DTO/service/repository implementations per service.
2. Add Flyway migrations for user/order/payment schemas.
3. Add Mongo indexes for product search patterns.
4. Add full observability (structured logs, tracing, metrics dashboards).

## Event Choreography Blueprint
- `order.created` -> payment-service (`payment.initiate`)
- `payment.success` -> order-service (`PAID`) + product-service (`inventory.deduct`)
- `order.paid` -> notification-service (email/sms dispatch)
- `refund.requested` -> payment-service + product-service rollback + notification-service

## Security Hardening Included
- Validation + global exception handling baseline in user-service.
- Access/refresh token rotation endpoints scaffolded.
- Password hashing via BCrypt in user-service registration flow.

## AI Recommendation Service
A dedicated `recommendation-service` module is included for OpenAI/Gemini integration, trending, and cross-sell logic.
