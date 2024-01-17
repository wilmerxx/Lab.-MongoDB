# Acceso a repositorios de Datos NoSQL
> Spring Boot ha llevado Spring Framework al siguiente nivel. Ha reducido drásticamente la configuración y el tiempo que
  este conlleva en proyectos empresariales. Puede configurar un proyecto con una configuración casi nula y comenzar a
  crear las cosas que realmente importan para su aplicación.
  En este Laboratorio, crearemos una API Restful CRUD para una aplicación simple para tomar notas. Una nota puede
  tener un título y algún contenido. Primero crearemos las API para crear, recuperar, actualizar y eliminar una nota, y luego
  las probaremos usando la herramienta Postman.

## Requisitos
- Java 8
- Maven 3.0+
- MongoDB 3.6+
- IDE (Eclipse, STS o IntelliJ IDEA)
- Postman
- Git

## Clonar repositorio
```
git clone https://github.com/wilmerxx/Lab.-MongoDB.git
```

## Configuración de la base de datos
```
server.port=8080

# Database mongo
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=my-database
spring.data.mongodb.username=test
spring.data.mongodb.password=123456
spring.data.mongodb.authentication-database=admin

```



