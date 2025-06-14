# TechStack Used :
1. Programming language : Java 21.
2. Application framework : Spring Boot 3.x.x.
3. Version control : Git and GitHub.
4. Build tool : Apache Maven.
5. Configuration management : Spring cloud config.
6. Service registration & discovery : Spring cloud eureka.
7. API Gateway : Spring cloud gateway.

# Useful Commands :
1. Check java version : java --version
2. Check maven version : mvn --version(also shows installed java version)
3. Check git version : git --version
4. To build the jar file : mvn clean install(run it from the directory where the pom.xml is located).
5. To run the jar file : mvn spring-boot:run | java -jar my_app.jar
6. To create docker image with Build packs : mvn spring-boot:build-image
7. To create docker image with Google jib : mvn compile jib:dockerBuild

# Useful ports :
1. Product : 8080
2. Order : 8090
3. Spring cloud config server : 8071
4. Spring cloud eureka server : 8070
5. Spring cloud gateway server : 8072

# Useful links :
1. Swagger UI : http://localhost:8080/swagger-ui.html
2. H2 UI : http://localhost:8080/h2-console
3. Actuator : http://localhost:8080/actuator
4. RabbitMQ UI : http://127.0.0.1:15672 | username : guest | password : guest
5. Eureka UI : http://localhost:8070
6. Netflix tech blog : https://netflixtechblog.com/netflix-oss-and-spring-boot-coming-full-circle-4855947713a0
7. Spring initializer : https://start.spring.io/
8. Spring cloud : https://spring.io/projects/spring-cloud

