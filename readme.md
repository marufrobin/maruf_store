# Learn Spring boot
---

# Table of Contents
- [Learn day - 01](#learn-day---01)
    - [File Structure](#file-structure)
    - [src/main/java (Java source files)](#srcmainjava-java-source-files)
    - [src/main/resources (Configuration files)](#srcmainresources-configuration-files)
    - [src/test/java (Test source files)](#srctestjava-test-source-files)
    - [src/test/resources (Test resources)](#srctestresources-test-resources)
    - [pom.xml (Maven configuration)](#pomxml-maven-configuration)
    - [application.properties (Application configuration)](#applicationproperties-application-configuration)
    - [Learn about SpringBoot MVC (Model-View-Controller) architecture](#learn-about-springboot-mvc-model-view-controller-architecture)
    - [Learn about SpringBoot Annotations](#learn-about-springboot-annotations)



---
## Adding Dependencies
To add dependencies in a Spring Boot project, you can modify the `pom.xml` file if you are using Maven. Here’s how to add a dependency:

1. Open the `pom.xml` file in the root directory of your project.
2. Locate the `<dependencies>` section. If it doesn't exist, you can create one.
3. Add the desired dependency in the following format:

```xml
<dependency>
    <groupId>group-id</groupId>
    <artifactId>artifact-id</artifactId>
    // Optional: specify the version recommended for the dependency
    <version>version</version>
</dependency>
```

4. Save the `pom.xml` file.
5. If you are using an IDE like IntelliJ IDEA or Eclipse, it may automatically download the new dependency. Otherwise, you can run the following Maven command in the terminal:

```
mvn clean install
```

This will download the specified dependency and make it available in your project.

----

## Running the Application
just use idea to run the application or for alternative you can use the terminal:
```
mvn spring-boot:run
```
---
## Testing the Application
To test the application, you can use the following command in the terminal:
```
mvn test
```
This will run all the tests defined in your project. If you want to run a specific test class, you can use the following command:
```
mvn -Dtest=TestClassName test
```
Replace `TestClassName` with the name of the test class you want to run.

---

## Use of application.properties

The `application.properties` file is used to configure various settings for your Spring Boot application. You can specify properties such as server port, database connection details, logging levels, and more.
Here are some common properties you might find in `application.properties`:
```properties
# Server port
server.port=8080
# Database connection
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=password
# App name 
spring.application.name=myapp
# page size
app.page-size=10
```
You can add or modify properties in this file to customize the behavior of your application. Spring Boot will automatically read these properties and apply them at runtime.

## SpringBoot MVC
Spring Boot follows the Model-View-Controller (MVC) architecture, which separates the application into three interconnected components:
- Model: Represents the data and business logic of the application.
- View: Represents the user interface and displays the data to the user.
- Controller: Handles user requests, interacts with the model, and returns the appropriate view.

This separation of concerns makes it easier to manage and scale the application.
## SpringBoot Annotations
Spring Boot provides several annotations to simplify the development process. Here are some commonly used annotations:
- `@SpringBootApplication`: Indicates that this is a Spring Boot application.
- `@RestController`: Combines `@Controller` and `@ResponseBody`, indicating that the class is a controller and the return values of its methods should be written directly to the HTTP response body.
- `@RequestMapping`: Maps HTTP requests to specific handler methods in the controller.
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Shorthand annotations for `@RequestMapping` with specific HTTP methods.
---

## Dependency injection

What is dependency injection?
ans: Dependency injection is a design pattern used in software development to achieve Inversion of Control (IoC) between classes and their dependencies. It allows a class to receive its dependencies from an external source rather than creating them itself, promoting loose coupling and enhancing testability.
for example:
imagine you have two classes one is `OrderService` and another is payment service `PaymentService` and you want to use the `PaymentService` in the `OrderService` class, you can inject the `PaymentService` into the `OrderService` class using dependency injection.
so by this example you can see that in for payment service you can use any payment service like `PayPal`, `Stripe` or any other payment service, so you can easily switch between them without changing the `OrderService` class.
Here is an example of how you can implement dependency injection in Spring Boot using annotations:
```java
@Service
public class OrderService {
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void placeOrder(Order order) {
        // Use paymentService to process the payment
        paymentService.processPayment(order.getPaymentDetails());
        // Logic to place the order
    }
}
@Service
public class PaymentService {
    public void processPayment(PaymentDetails paymentDetails) {
        // Logic to process the payment
    }
}
```
In this example, `OrderService` depends on `PaymentService`, and the `PaymentService` is injected into the `OrderService` constructor. This allows for better separation of concerns and makes it easier to test the `OrderService` class by mocking the `PaymentService`.