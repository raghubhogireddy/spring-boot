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