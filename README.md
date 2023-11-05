# spring-boot
This Repo contains practice and projects built with Spring and Spring Boot Framework

# FAQ's
### Question 1 : Spring Container vs Spring Context vs IOC Container vs Application Context ?
- Spring Container or Spring Context or even IOC Container refers to the same thing. The one that Manages Spring beans and 
  their lifecycle.
- There are 2 popular type of IOC Containers
  - Bean Factory - basic Spring container
  - ApplicationContext - Advanced Spring Container with enterprise-specific features
    - Easy to use in web apps
    - Easy Internationalization
    - Easy Integration with Spring AOP
### Question 2 : Java Bean vs Spring Bean ?
- POJO - any plain Old Java Object
- Java Bean - This EJB(Enterprise Java Besn standard) where it has following restrictions
  - public no-arg constructors
  - should have Setters and Getters
  - should be Serializable
- Spring Bean - Any class or object that was managed by Spring
### Question 3 : How can I list all the beans managed by Spring Framework ?
- The ApplicationContext provides set of methods which we can use to get info.
  - `context.getBeanDefinitionNames()` provides `String[]` which contains all the beans managed by the Context.
### Question 4 : What if multiple matching beans are available ?
- If you have multiple matching candidates Spring throws an exception. This can be fixed by making one of the `@Bean` as `@Primary`
- Additionally, if you don't want to use the default one, Spring provides an option to choose the Bean you required to pick. This can be done by using `@Qualifier("<name>")`
  - `@Qualifier("<name>")` should be added on both `@Bean` that you are auto wiring bean with another bean to get picked and also the reference where it was being injected in
### Question 5 : Spring is managing objects and also performing auto-wiring
