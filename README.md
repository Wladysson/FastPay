# FastPay

> **⚠️ Project Status:** **Planning**
>
> This project is currently in the architecture and design phase. The implementation will focus on building a cloud-native payment platform composed of a Smart POS application and a microservices ecosystem capable of processing card transactions with acquirer integration, scalability, and high reliability.

---

## 📖 About the Project

**FastPay** is a modern payment platform designed to simulate the architecture of payment processors and fintechs that handle card transactions through **Smart POS** devices. The platform aims to provide a complete payment processing workflow, from transaction initiation on the terminal to authorization, processing, and settlement through an acquiring integration.

The solution will be built using **Java 21** and **Quarkus**, adopting a cloud-native architecture optimized for fast startup, low memory consumption, and high throughput. The backend will be organized into independent microservices, each responsible for a specific business capability such as payment processing, transaction management, merchant management, settlement, and notifications.

Communication between services will follow an **Event-Driven Architecture** using **Apache Kafka**, enabling asynchronous processing, loose coupling, and resilient workflows throughout the payment lifecycle. Events such as payment authorization, capture, reversal, settlement, and notification will be propagated across the platform in real time.

Business data will be persisted in **PostgreSQL**, with each microservice maintaining its own database to preserve service autonomy and bounded contexts. APIs will be documented using **OpenAPI**, providing standardized contracts for integrations and simplifying API consumption.

The entire platform will be containerized with **Docker** and orchestrated using **Kubernetes**, allowing horizontal scaling, self-healing deployments, and cloud-native operation. The architecture will follow **Domain-Driven Design (DDD)** and **Clean Architecture** principles to ensure maintainability, scalability, and a clear separation between business logic and infrastructure concerns.

The final solution will reproduce many of the core concepts found in modern payment platforms, including Smart POS communication, transaction processing, acquiring integration, asynchronous event handling, and distributed microservices, providing a realistic simulation of enterprise-grade payment systems.
