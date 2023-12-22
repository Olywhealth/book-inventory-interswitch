# book-inventory-interswitch

# Overview
This is a Java 17 and Spring Boot 3.2.0 based application that serves as a simple online bookstore. The application provides various functionalities such as searching for books, managing a shopping cart, performing checkouts through different payment options (Web, USSD, Transfer), and viewing purchase history. The documentation below outlines the key features and how to interact with the application.

## Table of Contents
- Swagger Documentation
- Functionalities
- Search Functionality
- Shopping Cart
- Checkout
- Purchase History
- Unit Testing
- Swagger Documentation
The Swagger documentation for this application is available at the default Swagger URL. You can access it by navigating to http://localhost:8080/swagger-ui.html once the application is running.

## Functionalities
### Search Functionality
Users can search for books based on various criteria, including title, author, year of publication, or genre.

 ### Shopping Cart
Implement a shopping cart that allows users to add books.
Users can view the contents of the shopping cart.

 ### Checkout
Provide options for checkout with Web, USSD, and Transfer payment options.
The checkout process does not involve payment gateway integration but simulates the payment process.

### Purchase History
Users can view their purchase history to track their previous transactions.

### Unit Testing
The application includes unit tests to ensure the functionality of its components. You can run the tests using your preferred testing framework.

### Getting Started
To run the application locally, follow these steps:
Clone the application and cd to the directory
Open it with any IDE of your choice
It uses postgres for database management with default username and password has postgres
