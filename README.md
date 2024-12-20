# 🛠️ Práctica API REST

## 📜 Descripción

Este proyecto backend para el sistema de registro de prácticas profesionales está desarrollado utilizando **Spring Boot** y cuenta con un conjunto de endpoints para gestionar prácticas, profesores y estudiantes. 

### **Integrantes del equipo (Grupo 12, Sección 70):**
- **Mario Quevedo**  
- **Patricio Ibargaray**  
- **Franco Vasquez**

## 🚀 Características

- **Gestión de prácticas:**  
  Los estudiantes pueden registrar y consultar sus prácticas, mientras que los profesores tienen la capacidad de administrar estos registros.

- **Gestión de profesores:**  
  Registro y administración de profesores que supervisan y monitorean las prácticas profesionales.

- **Gestión de estudiantes:**  
  Registro de estudiantes y asignación de prácticas específicas.

- **Base de datos:**  
  La información se almacena en **MongoDB**, una base de datos no relacional que permite una gestión flexible y escalable de los datos.

---

## 🛠️ Stack

- [**Java 21**](https://www.oracle.com/java/technologies/javase//jdk21-archive-downloads.html) - The programming language used for backend logic implementation.
- [**Spring Boot 3.4.0**](https://spring.io/projects/spring-boot) - Framework for building robust and modular applications.

### 📚 Databases
- [**JPA (Java Persistence API)**](https://jakarta.ee/specifications/persistence/) - Interacting with relational databases and building RESTful services.
- [**MongoDB**](https://www.mongodb.com/) - NoSQL database for flexible storage and dynamic queries.

### 🧰 Development Tools
- [**Spring Boot DevTools**](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.devtools) - For automatic reload and accelerating development.
- [**Maven**](https://maven.apache.org/) - Dependency management and build tool.

### ⚙️ Utilities
- [**Lombok**](https://projectlombok.org/) - Reduces boilerplate code with annotations.

### 🧪 Testing
- [**Spring Boot Starter Test**](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing) - Dependencies for unit and integration testing.

---

## 📚 Endpoints

### 👩‍🎓 Estudiantes
- **GET api/estudiantes/getAll:** Obtiene todos los estudiantes registrados.  
- **GET api/estudiantes/getById/{id}:** Obtiene un estudiante por su ID.  
- **POST api/estudiantes/create:** Crea un nuevo estudiante y lo asocia a una practica.

### 📝 Prácticas
- **GET api/practicas/getAll:** Obtiene todas las prácticas registradas.  
- **GET api/practicas/getPracticaById/{id}:** Obtiene una práctica por su ID.  
- **POST api/practicas/create:** Crea una nueva práctica.  
- **PUT api/practicas/update/{id}:** Actualiza una práctica existente.
- **DELETE api/practicas/delete/{id}:** Elimina una práctica existente.

### 👨‍🏫 Profesores
- **GET api/profesores/getAll:** Obtiene todos los profesores registrados.  
- **GET api/profesores/getById/{id}:** Obtiene un profesor por su ID.  
- **POST api/profesores/create:** Crea un nuevo profesor.  
- **PUT api/profesores/update/{id}:** Actualiza un profesor existente.
- **DELETE api/profesores/delete/{id}:** Elimina una profesor existente.

---

## 🛠️ Configuración Adicional

### Repositorios
- **Spring Milestones:** Integración de dependencias experimentales o en desarrollo.

### Plugins
- **Maven Compiler Plugin:** Configurado para soportar anotaciones de Lombok.  
- **Spring Boot Maven Plugin:** Empaqueta la aplicación como un archivo ejecutable.

---

