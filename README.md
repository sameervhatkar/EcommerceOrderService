# E-commerce Order Microservice

# Overview

This microservice handles order management within the e-commerce platform. It provides endpoints for creating, viewing, and updating orders, as well as managing order items. Additionally, this microservice communicates with other services such as User, Product, and Payment to validate the user, check product availability, and process payments. The Order Microservice is critical for maintaining order records and ensuring smooth e-commerce transactions.

## Technologies Used
* Java
* Spring Boot
* JPA (Java Persistence API)
* Hibernate
* MySQL
* RESTful API
* JWT
* Spring Security

## Architecture
The microservice follows a layered architecture with the following packages:
* Controller: Contains REST controllers for handling HTTP requests.
* DTO (Data Transfer Objects): Defines the objects used to transfer data between layers.
* Entity: Represents the database entities.
* Exceptions: Custom exception handling.
* Mapper: Maps entities to DTOs and vice versa.
* Repository: JPA repositories for database access.
* Service: Contains the business logic.
* Client: Communicates with other microservices like Payment, Product, and User for order validation.

## Entities
### Order
```Java
public class Order {
    private UUID customerId;
    private LocalDate orderDate;
    private OrderStatus status;
    private double totalAmount;
    private List<OrderItem> productList;
    private String shippingAddress;
    private String billingAddress;
    private UUID paymentId;
}
```

### OrderItem
``` Java
public class OrderItem {
    private UUID productId;
    private String productName;
    private double unitPrice;
}
```

### User
``` Java
public class User {
    @Id
    private UUID userId;
    private String userName;
    private String userEmail;
}
```

## Endpoints

### OrderController

* Create Order: POST /createOrder
  - Request Header: Authorization token
  - Request Body: OrderRequestDTO
  - Response: OrderResponseDTO

## Service

### Order Service
* createOrder: Creates a new order after validating the user’s token and fetching product details.
