# Employee Manager Application

A console-based Java application for managing employees using PostgreSQL database.  
Users interact with the application via terminal input using Scanner to add, delete, and list employees.

## Description

This project was built to practice Java, database integration with PostgreSQL, and console interaction.  
It demonstrates basic CRUD operations (Create, Delete, List) for employee management in a terminal-based environment.

## Features

- Add new employees (via Scanner input)
- Delete employees
- List all employees

## Technologies Used

- Java 17
- Spring Boot
- PostgreSQL
- Maven
- Git & GitHub
- Scanner for console input

## How to Run

1. Clone the repository:
   git clone https://github.com/Anca88-spec/EmployeeManager.git

2. Configure PostgreSQL database in `application.properties`:
   spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. Run the application:
- Open `Main.java` in IntelliJ and click **Run**,  
  or run in terminal:
  ./mvnw spring-boot:run

4. Use the console input (Scanner) to interact with the application:
- Add new employees
- Delete employees
- List all employees

## Future Improvements

- Add Update employee functionality
- Add a frontend interface
- Add authentication (Spring Security)