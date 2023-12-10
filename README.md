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
  - Order of precedence will be 
    - `@Qualifier("<name>) at method parameter > @Primary at method level >  @Qualifier("<name>) at method level`
### Question 5 : @Primary vs @Qualifier which one to use ?
- `@Primary` means a bean should be given preference when multiple candidates are available
- `@Qualifier` means a specific bean should be autowired (name of the bean used for qualifier with starting letter non-capital) 

### Question 6 : Annotations 
- `@Component` means to a class that an instance of the class managed by Spring framework
  - Auto-wiring can be done using field/constructor/setters.
  - class level annotation
- `@Bean` method level annotation that produces a class instance that can be used. 
  - Auto-wiring can be done using method call / method parameters.
  - Typically used on methods in Spring Configuration classes.
  - use it if you have to create class instance using custom Business logic or for 3rd party libraries.
  - side Note: `@Bean` annotation work even if the method which got annotated was not part of `@Configuration` annotated class. 
- `@ComponentScan` means Spring framework scans packages to find components. If no package name given, Spring scans for current package.
  - Spring Container looks for beans, based on the class that you pass for applicationContext. If your class has beans getting initialized using `@Bean` annotation, then Spring Container is okay with it. If there are not beans definitions available, you need to give the package where it can look for. This can be done by using `@ComponentScan`
- `Dependency injection` means identify beans, their dependencies and wire them together (IOC - Inversion of Control)
- `@Autowired` or `Autowiring` means process of wiring dependencies for a spring bean
- 
### Question  : Spring is managing objects and also performing auto-wiring


### Exploring Spring - Dependency Injection Types
- `Constructor-based` : dependencies are set by creating the Bean using it's constructor
- `Setter-based` : dependencies are set by calling setter methods on your beans
- `Field` : no setter or constructor. dependency injected using reflection. 
- Recommended to use Constructor based injection as dependencies are automatically set when an object is created. Also no need to use `@Autowired` annotation if we are using constructor based injection.

### Lazy & Eager Initialization of Spring Beans
- By default all Spring Beans are Eager Initialized. 
  - This means, By the time Spring Context getting initialized all Spring bean in your application will be initialized. 
- Eager initialization is recommended as errors in configuration are discovered immediately at app startup.
- However, you can configure beans to be initialized lazily using `@Lazy` annotation.
  - Not recommended and Not frequently used.
  - can be used almost everywhere `@Component` and `@Bean` are used.
  - Can be used on Configuration classes (`@Configuration`)
    - In this case, all `@Bean` methods will be initialized lazily.

### Spring Bean Scopes
- Spring beans are defined to be used in a specific scope
  - `Singleton` - One object instance per Spring IoC Container
  - `Prototype` - Possibly many object instances per Spring IoC Container
- By default all Spring beans created are singleton in nature
- Singleton Beans are stateless and Prototype Beans are stateful
- Scopes applicable ONLY for web-aware Spring Application Context
  - `Request` - one object instance per single HTTP request
  - `Session` - one object instance per user HTTP session
  - `Application` - one object instance per web application runtime
  - `Websocket` - one object instance per WebSocket instance
- Java Singleton vs Spring Singleton
  - Spring Singleton: One object instance per Spring IoC Container
  - Java Singleton: One object instance per JVM