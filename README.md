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

- [**Java 21**](https://www.oracle.com/java/technologies/javase//jdk21-archive-downloads.html) - El lenguaje de programación utilizado para la implementación de la lógica del backend.
- [**Spring Boot 3.4.0**](https://spring.io/projects/spring-boot) - Framework para construir aplicaciones robustas y modulares.

### 📚 Databases
- [**JPA (Java Persistence API)**](https://jakarta.ee/specifications/persistence/) - Interacción con bases de datos relacionales y construcción de servicios RESTful.
- [**MongoDB**](https://www.mongodb.com/) - Base de datos NoSQL para almacenamiento flexible y consultas dinámicas.

### 🧰 Development Tools
- [**Spring Boot DevTools**](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.devtools) - Para recarga automática y aceleración del desarrollo.
- [**Maven**](https://maven.apache.org/) - Herramienta de gestión de dependencias y construcción.

### ⚙️ Utilities
- [**Lombok**](https://projectlombok.org/) - Reduce el código repetitivo mediante anotaciones.

### 🧪 Testing
- [**Spring Boot Starter Test**](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing) - Dependencias para pruebas unitarias e integración.

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

## 🚀 Getting Started

> [!IMPORTANTE]
> Antes de enviar cualquier cambio, asegúrate de tener permiso o que la licencia te permita hacerlo. Si no estás seguro, por favor contacta al responsable del proyecto o al autor.

Requerimientos:

- [JDK 21 o superior (recommended 20 LTS)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org)
- [Git](https://git-scm.com/)

1. **Haz un fork de este repositorio y clónalo localmente:**

```bash
git clone https://github.com/mbstnd/api-practica-springboot.git
```

2. **Instala las dependencias:**

Asegúrate de que tienes Maven y JDK 21 correctamente instalados en tu sistema. Instala Maven (si no lo tienes instalado) siguiendo las instrucciones en la página oficial de Maven. 

Para comprobar que Maven está correctamente instalado, ejecuta el siguiente comando:

```bash 
mvn -v
```

3. **Descarga las dependencias del proyecto:**

Una vez clonado el proyecto, navega al directorio del proyecto y ejecuta el siguiente comando para descargar las dependencias:

```bash
# Si no tienes Maven instalado, puedes hacerlo desde su página oficial:
# https://maven.apache.org/install.html

# Para asegurarte de que todo está configurado correctamente, ejecuta:
mvn clean install
```

4. **Ejecuta el proyecto:**

Para iniciar el proyecto localmente y verificar que todo funcione correctamente, ejecuta el siguiente comando:

```bash
# Ejecuta el proyecto con Maven:
mvn spring-boot:run
```
5. **Verifica la ejecución del proyecto:**
   Una vez que el proyecto se inicie correctamente, podrás interactuar con la API localmente:
- **Accede a la API a través de tu navegador en http://localhost:8080.**  
- **Usa herramientas como Postman o Insomnia para probar los endpoints y verificar que las funcionalidades estén operativas.**  



