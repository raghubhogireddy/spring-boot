### Goal of Spring Boot
- Help you build Production-Ready app Quickly
  - Build Quickly
    - Spring Initializr
    - Spring Boot Starter Projects
    - Spring Boot Auto Configuration
    - Spring Boot Dev Tools
  - Be Production-Ready
    - Logging
    - Different Configuration for different Enviroments
      - Profiles, Configuration properties
    - Monitoring (Spring Boot Actuator)

### Log Levels in most Frameworks
- trace
- debug
- info
- warning
- error
- off

### Monitor Applications using Spring Boot Actuator
- Spring Boot Actuator provides number of endpoints to monitor the application
  - `/beans` - Complete list of Spring beans in your app
  - `/health` - App health information
  - `/metrics` - App metrics
  - `/mappings` - details about request mappings
- By default, `/health` will be enabled
- To enable all endpoints that actuator has to offer, we can configure using property `management.endpoints.web.exposure.include=*` where `*` indicates all endpoints to be exposed. `=health,metrics` is sample to expose specific endpoints

### Session vs Request Scopes
- All request from browser are handled by our web application deployed on a server
- `Request Scope`: Active for a single request only.
  - once the response is sent back, the request attributes will be removed from memory
  - These cannot be used for future requests
- `Session Scopes`: Details stored across multiple requests
  - Take additional memory as all details are stored in session

### Validations with Spring Boot
- Spring Boot Starter Validation
  -pom.xml
- Command Bean (Form Backing object)
  - 2-way binding(todo.jsp & TodoController.java)
    - 2-way Binding mean, populating the data from bean to view in case of GET and from view to Bean in case of POST
- Add Validations to Bean
- Display validation errors in the view