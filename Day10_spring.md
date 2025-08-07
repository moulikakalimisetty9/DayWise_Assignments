**1. EmployeeApiApplication.java**



package com.company.employeeapi;



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class EmployeeApiApplication {

&nbsp;   public static void main(String\[] args) {

&nbsp;       SpringApplication.run(EmployeeApiApplication.class, args);

&nbsp;   }

}



**2. EmployeeController.java**



package com.company.employeeapi.controller;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



@RestController

public class EmployeeController {



&nbsp;   @GetMapping("/employee")

&nbsp;   public Map<String, Object> getEmployee() {

&nbsp;       return Map.of(

&nbsp;           "id", 101,

&nbsp;           "name", "John Doe",

&nbsp;           "department", "Engineering"

&nbsp;       );

&nbsp;   }

}



**3. application.properties**



\# Optional: Custom port

\# server.port=8081



**4. pom.xml**



<dependencies>

&nbsp;   <dependency>

&nbsp;       <groupId>org.springframework.boot</groupId>

&nbsp;       <artifactId>spring-boot-starter-web</artifactId>

&nbsp;   </dependency>

</dependencies>



**Test in browser/Postman:**



http://localhost:8080/employee



**Case Study 2: Monitoring with Spring Boot Actuator**



**1. pom.xml (add actuator dependency)**



<dependency>

&nbsp;   <groupId>org.springframework.boot</groupId>

&nbsp;   <artifactId>spring-boot-starter-actuator</artifactId>

</dependency>



**2. application.properties**



management.endpoints.web.exposure.include=\*



**3. ✅ Available Endpoints**



After running the app, access:

http://localhost:8080/actuator/health

http://localhost:8080/actuator/beans

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/env



