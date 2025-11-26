# 🛒 E-commerce Backend - Spring Boot

## Descripción

Backend completo para plataforma de e-commerce desarrollado en **Spring Boot 3** con arquitectura en
capas y mejores prácticas de seguridad.

## Características Técnicas

- **Framework**: Spring Boot 3.5.8 + Java 21
- **Arquitectura**: Controller → Service → Repository
- **Base de datos**: H2 (desarrollo) + PostgreSQL (producción)
- **Seguridad**: DTOs, validaciones, protección contra SQL injection
- **API REST**: CRUD completo con respuestas estandarizadas

## Arquitectura

    src/
    ├── controller/     # Endpoints REST
    ├── service/        # Lógica de negocio
    ├── repository/     # Acceso a datos (Spring Data JPA)
    ├── dto/            # Data Transfer Objects
    ├── mapper/         # Conversiones Entity ↔ DTO
    ├── model/          # Entidades JPA
    └── exception/      # Manejo centralizado de errores

## Endpoints Principales

| Método | Endpoint             | Descripción                |
|--------|----------------------|----------------------------|
| POST   | `/api/products`      | Crear producto             |
| GET    | `/api/products`      | Listar todos los productos |
| GET    | `/api/products/{id}` | Obtener producto por ID    |
| PUT    | `/api/products/{id}` | Actualizar producto        |
| DELETE | `/api/products/{id}` | Eliminar producto          |

## Tecnologías Utilizadas

- **Spring Boot 3.5.8** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **H2 Database** - Base de datos en memoria (desarrollo)
- **Lombok** - Reducción de boilerplate code
- **Jakarta Validation** - Validaciones de datos
- **Maven** - Gestión de dependencias

## Características de Seguridad

- DTOs para controlar datos expuestos
- Validaciones automáticas con `@Valid`
- Prepared Statements contra SQL injection
- Manejo centralizado de excepciones
- Tipado fuerte de Java

## Próximas Características (Post-entrega de TP en Talento Tech)

- Autenticación con Spring Security + JWT
- Sistema de carrito de compras
- Integración con pasarela de pagos
- Dockerización
- Deployment en cloud
- Sistema de reviews y ratings
- Notificaciones por email

      
