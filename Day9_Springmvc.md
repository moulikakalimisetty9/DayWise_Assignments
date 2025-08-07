**1. Course.java**



package model;



public class Course {

&nbsp;   private String id;

&nbsp;   private String name;



&nbsp;   public Course(String id, String name) {

&nbsp;       this.id = id;

&nbsp;       this.name = name;

&nbsp;   }



&nbsp;   public String getId() { return id; }

&nbsp;   public String getName() { return name; }

}



**2. Student.java**



package model;



public class Student {

&nbsp;   private String name;

&nbsp;   private String email;

&nbsp;   private String courseId;



&nbsp;   // Getters and Setters

&nbsp;   public String getName() { return name; }

&nbsp;   public void setName(String name) { this.name = name; }



&nbsp;   public String getEmail() { return email; }

&nbsp;   public void setEmail(String email) { this.email = email; }



&nbsp;   public String getCourseId() { return courseId; }

&nbsp;   public void setCourseId(String courseId) { this.courseId = courseId; }

}



**3. CourseController.java**



package controller;



import model.Course;

import model.Student;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.\*;



import java.util.\*;



@Controller

public class CourseController {



&nbsp;   private List<Course> courses = Arrays.asList(

&nbsp;       new Course("C001", "Java"),

&nbsp;       new Course("C002", "Spring Boot"),

&nbsp;       new Course("C003", "Web Development")

&nbsp;   );



&nbsp;   @GetMapping("/courses")

&nbsp;   public String showCourses(Model model) {

&nbsp;       model.addAttribute("courses", courses);

&nbsp;       return "courses";

&nbsp;   }



&nbsp;   @GetMapping("/enroll")

&nbsp;   public String showEnrollmentForm(Model model) {

&nbsp;       model.addAttribute("student", new Student());

&nbsp;       return "enroll";

&nbsp;   }



&nbsp;   @PostMapping("/submitEnrollment")

&nbsp;   public String submitEnrollment(@ModelAttribute Student student, Model model) {

&nbsp;       model.addAttribute("student", student);

&nbsp;       return "success";

&nbsp;   }

}



**4. AppConfig.java**



import org.springframework.context.annotation.\*;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration

@EnableWebMvc

@ComponentScan("controller")

public class AppConfig {

&nbsp;   @Bean

&nbsp;   public InternalResourceViewResolver viewResolver() {

&nbsp;       InternalResourceViewResolver vr = new InternalResourceViewResolver();

&nbsp;       vr.setPrefix("/view/");

&nbsp;       vr.setSuffix(".jsp");

&nbsp;       return vr;

&nbsp;   }

}



**5. web.xml**



<web-app>

&nbsp;   <servlet>

&nbsp;       <servlet-name>dispatcher</servlet-name>

&nbsp;       <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

&nbsp;       <init-param>

&nbsp;           <param-name>contextConfigLocation</param-name>

&nbsp;           <param-value>/WEB-INF/app-config.xml</param-value>

&nbsp;       </init-param>

&nbsp;       <load-on-startup>1</load-on-startup>

&nbsp;   </servlet>



&nbsp;   <servlet-mapping>

&nbsp;       <servlet-name>dispatcher</servlet-name>

&nbsp;       <url-pattern>/</url-pattern>

&nbsp;   </servlet-mapping>

</web-app>



**6. courses.jsp**



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>

<h2>Available Courses</h2>

<ul>

&nbsp;   <c:forEach var="course" items="${courses}">

&nbsp;       <li>${course.name}</li>

&nbsp;   </c:forEach>

</ul>

<a href="enroll">Enroll Now</a>

</body>

</html>



**7. enroll.jsp**



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<body>

<h2>Enroll Form</h2>

<form:form method="POST" modelAttribute="student" action="submitEnrollment">

&nbsp;   Name: <form:input path="name"/><br/>

&nbsp;   Email: <form:input path="email"/><br/>

&nbsp;   Course ID: <form:input path="courseId"/><br/>

&nbsp;   <input type="submit" value="Enroll"/>

</form:form>

</body>

</html>



**8. success.jsp**



<html>

<body>

<h2>Enrollment Successful!</h2>

<p>Thank you, ${student.name}.</p>

<p>Course ID: ${student.courseId}</p>

</body>

</html>



**Case Study 2: Online Shopping Portal – Order Processing (Spring AOP)**



**1. OrderService.java**



package service;



import org.springframework.stereotype.Component;



@Component

public class OrderService {



&nbsp;   public void addToCart(String product) {

&nbsp;       System.out.println("Product added: " + product);

&nbsp;   }



&nbsp;   public void placeOrder(String orderId) {

&nbsp;       if ("INVALID".equals(orderId)) {

&nbsp;           throw new RuntimeException("Invalid Order ID");

&nbsp;       }

&nbsp;       System.out.println("Order placed: " + orderId);

&nbsp;   }



&nbsp;   public void cancelOrder(String orderId) {

&nbsp;       System.out.println("Order cancelled: " + orderId);

&nbsp;   }

}



**2. OrderLoggingAspect.java**



package aspect;



import org.aspectj.lang.annotation.\*;

import org.springframework.stereotype.Component;



@Aspect

@Component

public class OrderLoggingAspect {



&nbsp;   @Before("execution(\* service.OrderService.\*(..))")

&nbsp;   public void beforeAdvice() {

&nbsp;       System.out.println("→ \[Before] Method execution starting...");

&nbsp;   }



&nbsp;   @AfterReturning("execution(\* service.OrderService.\*(..))")

&nbsp;   public void afterReturnAdvice() {

&nbsp;       System.out.println("→ \[AfterReturning] Method executed successfully.");

&nbsp;   }



&nbsp;   @AfterThrowing("execution(\* service.OrderService.\*(..))")

&nbsp;   public void afterThrowingAdvice() {

&nbsp;       System.out.println("→ \[AfterThrowing] Exception occurred during method.");

&nbsp;   }



&nbsp;   @After("execution(\* service.OrderService.\*(..))")

&nbsp;   public void afterAdvice() {

&nbsp;       System.out.println("→ \[After] Method finished.");

&nbsp;   }

}



**3. AppConfig.java**



import org.springframework.context.annotation.\*;

import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Configuration

@ComponentScan(basePackages = {"service", "aspect"})

@EnableAspectJAutoProxy

public class AppConfig {

}



**4. MainApp.java**



import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.OrderService;



public class MainApp {

&nbsp;   public static void main(String\[] args) {

&nbsp;       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

&nbsp;       OrderService orderService = context.getBean(OrderService.class);



&nbsp;       orderService.addToCart("Laptop");

&nbsp;       orderService.placeOrder("ORD123");



&nbsp;       try {

&nbsp;           orderService.placeOrder("INVALID");

&nbsp;       } catch (Exception e) {

&nbsp;           System.out.println("Caught exception in main: " + e.getMessage());

&nbsp;       }

&nbsp;   }

}







