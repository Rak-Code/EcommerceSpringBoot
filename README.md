Here’s a **revised and improved README** for your Spring Boot E-Commerce Backend project. It’s concise, well-structured, and provides all the necessary details for developers to understand and use the project.

---

# Spring Boot E-Commerce Backend

A robust and scalable backend for a clothing e-commerce platform built with **Spring Boot**, **MySQL**, and **Spring Data JPA**. This project provides RESTful APIs for managing users, products, categories, and orders.

---

## Features
- **User Management**: Register and manage users with roles (`USER`, `ADMIN`).
- **Product & Category Management**: Perform CRUD operations on products and categories.
- **Order Management**: Users can place orders with multiple products.
- **Validation**: Input validation for all entities (e.g., email format, required fields).
- **Database Integration**: MySQL for persistent storage with Hibernate ORM.

---

## Technologies Used
- **Backend**: Spring Boot 3.3.8
- **Database**: MySQL
- **ORM**: Spring Data JPA/Hibernate
- **Build Tool**: Maven
- **Libraries**: Lombok, Validation, Spring Web

---

## Getting Started

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/ecommerce-springboot.git
   ```
2. **Set up MySQL**:
   - Create a database:
     ```sql
     CREATE DATABASE ecommerce_clothing_db;
     ```
   - Update `application.properties` with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_clothing_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```
3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

---

## API Documentation

### Users
| Method | Endpoint          | Description                |
|--------|-------------------|----------------------------|
| POST   | `/api/users`      | Create a new user          |
| GET    | `/api/users`      | Get all users              |

### Categories
| Method | Endpoint            | Description                |
|--------|---------------------|----------------------------|
| POST   | `/api/categories`   | Create a category          |
| GET    | `/api/categories`   | Get all categories         |

### Products
| Method | Endpoint            | Description                |
|--------|---------------------|----------------------------|
| POST   | `/api/products`     | Create a product           |
| GET    | `/api/products`     | Get all products           |

### Orders
| Method | Endpoint                  | Description                |
|--------|---------------------------|----------------------------|
| POST   | `/api/orders/{userId}`    | Place an order             |
| GET    | `/api/orders`             | Get all orders             |

---

## Example Requests

### Create a User
```http
POST /api/users
Content-Type: application/json

{
  "username": "IGRIS",
  "email": "igris@gmail.com",
  "password": "password123",
  "role": "USER"
}
```

### Create a Product
```http
POST /api/products
Content-Type: application/json

{
  "name": "Cotton T-Shirt",
  "description": "Premium quality",
  "price": 25.99,
  "categoryId": 1
}
```

### Place an Order
```http
POST /api/orders/1
Content-Type: application/json

[
  {
    "productId": 1,
    "quantity": 2
  }
]
```

---

## Database Schema

### Tables
- **`user`**: Stores user details.
  ```sql
  CREATE TABLE user (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      username VARCHAR(255) UNIQUE NOT NULL,
      email VARCHAR(255) UNIQUE NOT NULL,
      password VARCHAR(255) NOT NULL,
      role VARCHAR(50) NOT NULL
  );
  ```
- **`product`**: Stores product details.
  ```sql
  CREATE TABLE product (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(255) NOT NULL,
      description TEXT,
      price DOUBLE NOT NULL,
      category_id BIGINT,
      FOREIGN KEY (category_id) REFERENCES category(id)
  );
  ```
- **`orders`**: Stores order details.
  ```sql
  CREATE TABLE orders (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      status VARCHAR(50) NOT NULL,
      total_amount DOUBLE NOT NULL,
      user_id BIGINT,
      FOREIGN KEY (user_id) REFERENCES user(id)
  );
  ```

---

## Example SQL Query
To fetch user orders with product details:
```sql
SELECT 
    u.username AS user_name,
    p.name AS product_name,
    od.quantity,
    od.price_at_purchase,
    o.total_amount,
FROM 
    user u
JOIN 
    orders o ON u.id = o.user_id
JOIN 
    order_details od ON o.id = od.order_id
JOIN 
    product p ON od.product_id = p.id;
```

---

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---

## Contact
For questions or feedback, please reach out at [your.email@example.com](mailto:your.email@example.com).

---

This README is concise, developer-friendly, and provides all the necessary information to get started with the project. Let me know if you need further adjustments! 🚀
