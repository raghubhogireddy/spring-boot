### JDBC to Spring JDBC to JPA to Spring Data JPA
- JDBC
  - Write a lot of SQL Queries
  - And write a lot of Java code
- Spring JDBC
  - Write a lot of SQL Queries
  - But lesser Java code
- JPA
  - Do Not worry about queries
  - Just Map Entities to Tables!
- Spring Data JPA

### Hibernate vs JPA
- JPA defines the specification. It is an API.
  - Helps you to define entities
  - Helps you to map Attributes
  - Helps you to manage entities
- Hibernate is one of the popular implementations for JPA
- Using Hibernate directly would result in a lock into Hibernate
  - There are other JPA implementations (Toplink etc..)