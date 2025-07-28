1. Lambda Expressions – Case Study: Sorting and Filtering Employees
Scenario:
You are building a human resource management module. You need to:
• Sort employees by name or salary.
• Filter employees with a salary above a certain threshold.
Use Case:
Instead of creating multiple comparator classes or anonymous classes, you use Lambda expressions
to sort and filter employee records in a concise and readable manner.

// Employee.java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - ₹" + salary;
    }
}


// LambdaDemo.java
import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 30000)
        );

        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("Sorted by name:");
        employees.forEach(System.out::println);

        System.out.println("Filtered (salary > 40000):");
        employees.stream()
                 .filter(e -> e.getSalary() > 40000)
                 .forEach(System.out::println);
    }
}

2. Stream API & Operators – Case Study: Order Processing System
Scenario:
In an e-commerce application, you must:
• Filter orders above a certain value.
• Count total orders per customer.
• Sort and group orders by product category.
Use Case:
Streams help to process collections like orders using operators like filter, map, collect,
sorted, and groupingBy to build readable pipelines for data processing.

  
// Order.java
public class Order {
    private String customerId;
    private String category;
    private double amount;

    public Order(String customerId, String category, double amount) {
        this.customerId = customerId;
        this.category = category;
        this.amount = amount;
    }

    public String getCustomerId() { return customerId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return customerId + " - " + category + " - ₹" + amount;
    }
}


// StreamDemo.java
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("C1", "Books", 1200),
            new Order("C2", "Electronics", 800),
            new Order("C1", "Books", 500)
        );

        List<Order> highValue = orders.stream()
            .filter(o -> o.getAmount() > 1000)
            .collect(Collectors.toList());

        System.out.println("High Value Orders:");
        highValue.forEach(System.out::println);

        Map<String, Long> orderCount = orders.stream()
            .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));

        System.out.println("Order count per customer: " + orderCount);

        Map<String, List<Order>> grouped = orders.stream()
            .collect(Collectors.groupingBy(Order::getCategory));

        System.out.println("Grouped by Category:");
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

3. Functional Interfaces – Case Study: Custom Logger
Scenario:
You want to create a logging utility that allows:
• Logging messages conditionally.
• Reusing common log filtering logic.
Use Case:
You define a custom LogFilter functional interface and allow users to pass behavior using
lambdas. You also utilize built-in interfaces like Predicate and Consumer.

  
// LoggerDemo.java
@FunctionalInterface
interface LogFilter {
    boolean shouldLog(String msg);
}

public class LoggerDemo {
    public static void logMessage(String msg, LogFilter filter) {
        if (filter.shouldLog(msg)) {
            System.out.println("LOG: " + msg);
        }
    }

    public static void main(String[] args) {
        logMessage("Error occurred", msg -> msg.contains("Error"));
        logMessage("Info message", msg -> msg.contains("Error"));
    }
}

4. Default Methods in Interfaces – Case Study: Payment Gateway Integration
Scenario:
You're integrating multiple payment methods (PayPal, UPI, Cards) using interfaces.
Use Case:
You use default methods in interfaces to provide shared logic (like transaction logging or currency
conversion) without forcing each implementation to re-define them.

  
// PaymentMethod.java
interface PaymentMethod {
    void pay(double amount);

    default void logTransaction(double amount) {
        System.out.println("Paid ₹" + amount);
    }
}


// PayPal.java
public class PayPal implements PaymentMethod {
    public void pay(double amount) {
        logTransaction(amount);
    }

    public static void main(String[] args) {
        PayPal pp = new PayPal();
        pp.pay(2500);
    }
}

5. Method References – Case Study: Notification System
Scenario:
You’re sending different types of notifications (Email, SMS, Push). The methods for sending are
already defined in separate classes.
Use Case:
You use method references (e.g., NotificationService::sendEmail) to refer to
existing static or instance methods, making your event dispatcher concise and readable.

  
// NotificationService.java
import java.util.function.Consumer;

public class NotificationService {
    public static void sendEmail(String msg) {
        System.out.println("Email: " + msg);
    }

    public static void sendSMS(String msg) {
        System.out.println("SMS: " + msg);
    }

    public static void main(String[] args) {
        Consumer<String> emailSender = NotificationService::sendEmail;
        emailSender.accept("Welcome to Java 8 features!");
    }
}

6. Optional Class – Case Study: User Profile Management
Scenario:
User details like email or phone number may be optional during registration.
Use Case:
To avoid NullPointerException, you wrap potentially null fields in Optional. This
forces developers to handle absence explicitly using methods like orElse, ifPresent, or
map.
  
// User.java
import java.util.Optional;

public class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public static void main(String[] args) {
        User user = new User(null);
        Optional<String> email = user.getEmail();

        email.ifPresent(e -> System.out.println("Email: " + e));
        System.out.println("Email: " + email.orElse("Not provided"));
    }
}

7. Date and Time API (java.time) – Case Study: Booking System
Scenario:
A hotel or travel booking system that:
• Calculates stay duration.
• Validates check-in/check-out dates.
• Schedules recurring events.
Use Case:
You use the new LocalDate, LocalDateTime, Period, and Duration classes to
perform safe and readable date/time calculations.

  
// DateDemo.java
import java.time.*;

public class DateDemo {
    public static void main(String[] args) {
        LocalDate checkIn = LocalDate.of(2025, 7, 25);
        LocalDate checkOut = LocalDate.of(2025, 7, 28);

        Period stay = Period.between(checkIn, checkOut);
        System.out.println("Stay duration: " + stay.getDays() + " days");

        boolean isValid = checkIn.isBefore(checkOut);
        System.out.println("Valid Dates? " + isValid);
    }
}

8. Executor Service – Case Study: File Upload Service
Scenario:
You allow users to upload multiple files simultaneously and want to manage the processing
efficiently.
Use Case:
You use ExecutorService to handle concurrent uploads by creating a thread pool, managing
background tasks without blocking the UI or main thread

  
// ExecutorDemo.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable uploadTask = () -> {
            System.out.println("Uploading by: " + Thread.currentThread().getName());
        };

        for (int i = 0; i < 5; i++) {
            executor.submit(uploadTask);
        }

        executor.shutdown();
    }
}
