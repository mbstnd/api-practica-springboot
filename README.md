# 🛠️ Practica API - Backend

## 📜 Descripción

Este es un proyecto backend para gestionar prácticas profesionales utilizando Spring Boot. La API proporciona endpoints para gestionar prácticas, profesores y estudiantes en el contexto de un sistema de registro de prácticas profesionales.

## 🚀 Características

- **Gestión de prácticas**: Permite crear, actualizar y obtener detalles de prácticas profesionales.
- **Gestión de profesores**: Los profesores pueden ser registrados, consultados y relacionados con las prácticas.
- **Gestión de estudiantes**: Los estudiantes pueden ser registrados y asignados a prácticas específicas.
- **Base de datos**: Utiliza una base de datos para almacenar la información de prácticas, profesores y estudiantes.

## 📚 Endpoints

### 📝 Practicas

- **GET /api/practicas/getAll**: Obtiene todas las prácticas registradas.
- **GET /api/practicas/getById/{id}**: Obtiene una práctica por su ID.
- **POST /api/practicas/create**: Crea una nueva práctica.
- **PUT /api/practicas/update/{id}**: Actualiza una práctica existente.

### 👨‍🏫 Profesores

- **GET /api/profesores/getAll**: Obtiene todos los profesores registrados.
- **GET /api/profesores/getById/{id}**: Obtiene un profesor por su ID.
- **POST /api/profesores/create**: Crea un nuevo profesor.
- **PUT /api/profesores/update/{id}**: Actualiza un profesor existente.

### 👩‍🎓 Estudiantes

- **GET /api/estudiantes/getAll**: Obtiene todos los estudiantes registrados.
- **GET /api/estudiantes/getById/{id}**: Obtiene un estudiante por su ID.
- **POST /api/estudiantes/create**: Crea un nuevo estudiante.

## 🛠️ Instalación

### Prerequisitos

- Java 11 o superior.
- Maven para gestionar dependencias.

### Pasos para correr el proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/registro-practicas.git
