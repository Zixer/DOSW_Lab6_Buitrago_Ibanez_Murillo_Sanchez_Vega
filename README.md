# DOSW_Lab6_Buitrago_Ibanez_Murillo_Sanchez_Vega
## Diagrama de Clases UML - Primer Ciclo

![Diagrama de Clases](../docs/uml/OficioYaLab6.png)

# PARTE 2 - Preguntas sobre la estructura de Spring Boot
 
| Paquete | Respuesta |
|---|---|
| **Controller** | Es la puerta de entrada de la API, aquí es donde llegan las peticiones HTTP del cliente (GET, POST, PUT, DELETE, entre otros) y se decide qué hacer con ellas. Su trabajo no es resolver la lógica de negocio, es recibir la petición, pasarla a la capa de `Service` para que la procese, y luego armar la respuesta HTTP que se le devuelve al cliente, con su respectivo código de estado y cuerpo |
| **Service** | Es donde está la lógica de negocio de la aplicación, esta capa actúa como intermediaria entre el `Controller` y el `Repository`, y es la encargada de aplicar reglas, validaciones y cálculos necesarios antes de que la información se guarde en la base de datos o se la retorne al cliente |
| **Model** | Agrupa los objetos y conceptos que representan el núcleo del negocio de la aplicación, el modelo define estructuras de datos puras, sin ninguna dependencia de cómo se almacenan en la base de datos |
| **Repository** | Esta capa es la que se encarga de hablar directamente con la base de datos, gracias a herramientas como Spring Data JPA, se exponen los métodos necesarios para hacer las operaciones típicas de CRUD (crear, leer, actualizar, borrar) sin que el resto de la aplicación tenga que preocuparse por los accesos de datos |
| **Entity** | Las clases dentro de `Entity` representan tal cual las tablas de una base de datos relacional, donde cada instancia equivale a una fila. Usan anotaciones de JPA como `@Id` y `@Column` para mapear los atributos del objeto con las columnas correspondientes en la base de datos |
| **DTO (Data Transfer Object)** | Su propósito es transportar datos entre las distintas capas de la aplicación, entre el cliente y el `Controller`. Esto permite que la estructura interna de las entidades pueda quedarse protegida, ya que solo se envían y reciben los datos que la API realmente necesita exponer |
| **Exception** | Centraliza el manejo de errores de la aplicación, aquí se definen tanto las excepciones personalizadas del negocio como las clases de configuración —normalmente con `@ControllerAdvice`, que capturan los fallos de forma global y le devuelven al cliente respuestas bien estructuradas con el código HTTP correspondiente |
 
## Bibliografía (Normas APA)
 
Spring. *Accessing data with JPA*. Spring Guides. https://spring.io/guides/gs/accessing-data-jpa
 
Spring.  *Spring Data JPA – Reference documentation*. https://docs.spring.io/spring-data/jpa/reference/index.html
 
Spring.  *Spring Framework overview*. Spring Framework Reference Documentation. https://docs.spring.io/spring-framework/reference/overview.html

