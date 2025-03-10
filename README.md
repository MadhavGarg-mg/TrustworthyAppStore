# **Trustworthy App Store**

This README provides instructions on how to set up the Trustworthy App Store project. This is a Spring Boot web application with MySQL integration for user registration and secure login functionality.

---

## **Requirements**
- **Java:** JDK 21
- **MySQL:** 8.0.41
- **Spring Boot:** 3.2.2
- **Maven:** 3.8.1+
- **IntelliJ IDEA:** Recommended IDE

---

## **Setup**

### 1. Creating Database using MySQL
```bash
CREATE DATABASE trustworthyappstoredb;  
CREATE USER 'developer'@'localhost' IDENTIFIED BY 'password123';  
GRANT ALL PRIVILEGES ON trustworthyappstoredb.* TO 'developer'@'localhost';  
FLUSH PRIVILEGES;
```

### 2. Configure application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/trustworthyappstoredb  
spring.datasource.username=developer  
spring.datasource.password=password123  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect  
spring.jpa.show-sql=true  

server.port=8443  # Can change the port if 8443 is already in use.
server.ssl.enabled=true  
server.ssl.key-store=classpath:keystore.p12  
server.ssl.key-store-password=your-keystore-password  
server.ssl.key-store-type=PKCS12  
```

### 3. Running the application
To run the application, follow these steps:

1. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
2. Navigate to the main application file: BasicWebsiteApplication.java.
3. Run the file.

Once the application is running, you can access the website at: https://localhost:8443/myapp

## **Troubleshooting**

* Port Conflict: If port 8443 is already in use, change the port in application.properties.
* SSL Configuration: Ensure the keystore.p12 file is correctly placed in the src/main/resources directory and the password matches the one in application.properties.
* Database Connection: Verify that MySQL is running and the credentials in application.properties are correct.