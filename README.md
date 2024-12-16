# 🛠️ Práctica API - Backend

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

### Lenguaje de Programación
- **Java 21:** El lenguaje base para la implementación de la lógica backend.

### Framework Principal
- **Spring Boot 3.4.0:** Framework que facilita la construcción de aplicaciones robustas y modulares.

### Bases de Datos
- **JPA (Java Persistence API):** Interacción con bases de datos relacionales y RESTFULL.  
- **MongoDB:** Base de datos NoSQL para almacenamiento flexible y consultas dinámicas.

### Herramientas de Desarrollo
- **Spring Boot DevTools:** Para recarga automática y aceleración del desarrollo.  
- **Maven:** Gestión de dependencias y compilación.

### Utilidades
- **Lombok:** Reduce el código repetitivo mediante anotaciones.  

### Testing
- **Spring Boot Starter Test:** Dependencias para pruebas unitarias e integración.

---

## 📚 Endpoints

### 📝 Prácticas
- **GET /api/practicas/getAll:** Obtiene todas las prácticas registradas.  
- **GET /api/practicas/getById/{id}:** Obtiene una práctica por su ID.  
- **POST /api/practicas/create:** Crea una nueva práctica.  
- **PUT /api/practicas/update/{id}:** Actualiza una práctica existente.

### 👨‍🏫 Profesores
- **GET /api/profesores/getAll:** Obtiene todos los profesores registrados.  
- **GET /api/profesores/getById/{id}:** Obtiene un profesor por su ID.  
- **POST /api/profesores/create:** Crea un nuevo profesor.  
- **PUT /api/profesores/update/{id}:** Actualiza un profesor existente.

### 👩‍🎓 Estudiantes
- **GET /api/estudiantes/getAll:** Obtiene todos los estudiantes registrados.  
- **GET /api/estudiantes/getById/{id}:** Obtiene un estudiante por su ID.  
- **POST /api/estudiantes/create:** Crea un nuevo estudiante.

---

## 🛠️ Configuración Adicional

### Repositorios
- **Spring Milestones:** Integración de dependencias experimentales o en desarrollo.

### Plugins
- **Maven Compiler Plugin:** Configurado para soportar anotaciones de Lombok.  
- **Spring Boot Maven Plugin:** Empaqueta la aplicación como un archivo ejecutable.

---

