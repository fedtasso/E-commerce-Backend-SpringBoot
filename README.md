# 🛒 E-commerce Backend - Spring Boot

## Descripción

Backend completo para plataforma de e-commerce desarrollado en **Spring Boot 3** con arquitectura en
capas y mejores prácticas de seguridad.

🔗 **Frontend conectado a esta API:** https://fedtasso-ecommerce.netlify.app/

## Características Técnicas

- **Gestión de Productos** — CRUD completo con validaciones
- **Gestión de Usuarios** — Registro, autenticación y perfiles
- **Carrito de Compras** — Agregar, actualizar y eliminar productos
- **Transacciones Seguras** — Manejo de operaciones atómicas
- **Validaciones** — Bean Validation para datos de entrada
- **Arquitectura Limpia** — Separación de responsabilidades
- **API Documentada** — Endpoints claros y organizados
- **DEPLOY EN PRODUCCIÓN - Render**

## Arquitectura

    src/
    ├── controller/     # Endpoints REST
    ├── service/        # Lógica de negocio
    ├── repository/     # Acceso a datos (Spring Data JPA)
    ├── dto/            # Data Transfer Objects
    | ├── user/
    | ├── product/
    | ├── cart/
    ├── mapper/         # Conversiones Entity ↔ DTO
    ├── model/          # Entidades JPA
    ├── config/         # Configuraciones de la aplicación
    ├── constanst/      # Constantes reutilizables# 📚 Endpoints de la API

---

## 🏪 Productos

| Método | Endpoint                | Descripción                 |
|--------|--------------------------|------------------------------|
| GET    | /api/products            | Obtener todos los productos |
| GET    | /api/products/{id}       | Obtener producto por ID     |
| POST   | /api/products            | Crear nuevo producto        |
| PUT    | /api/products/{id}       | Actualizar producto         |
| DELETE | /api/products/{id}       | Eliminar producto           |

---

## 👥 Usuarios

| Método | Endpoint                               | Descripción               |
|--------|-----------------------------------------|---------------------------|
| POST   | /api/users/register                     | Registrar nuevo usuario   |
| GET    | /api/users                              | Obtener todos los usuarios|
| GET    | /api/users/{id}                         | Obtener usuario por ID    |
| GET    | /api/users/search?email={email}         | Buscar usuario por email  |
| PUT    | /api/users/{id}                         | Actualizar usuario        |
| PATCH  | /api/users/{id}/password                | Actualizar contraseña     |
| DELETE | /api/users/{id}                         | Eliminar usuario          |

---

## 🛒 Carrito de Compras

| Método | Endpoint                                        | Descripción        | Comportamiento     |
|--------|--------------------------------------------------|--------------------|---------------------|
| GET    | /api/carts/user/{userId}                        | Obtener carrito    | -                   |
| POST   | /api/carts/user/{userId}/items                  | Agregar producto   | Acumula cantidad    |
| PUT    | /api/carts/user/{userId}/items                  | Actualizar producto| Reemplaza cantidad  |
| DELETE | /api/carts/user/{userId}/items/{productId}      | Eliminar producto  | -                   |
| DELETE | /api/carts/user/{userId}/clear                  | Vaciar carrito     | -                   |

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database** (desarrollo)
- **Lombok**
- **MapStruct**
- **Bean Validation**
- **Maven**
- **Render** (deployment)

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


## 👨‍💻 Autor

**Federico Tasso**

📧 **Email:** fedtasso@gmail.com  
💼 **LinkedIn:** https://www.linkedin.com/in/fede-tasso/  
🐙 **GitHub:** @fedtasso
      
