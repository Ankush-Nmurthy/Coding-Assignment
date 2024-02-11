# Coding-Assignment
Code is in Folder 'src/main/java/com/example'

# Theory Question are answered in here 
click here : https://docs.google.com/document/d/19rp-1Nb983rqYhx0dOMAky7XGY6RkkJ0QsV4WZ7DFMw/edit?usp=sharing

## .CSV file code is done here
click here: https://github.com/Ankush-Nmurthy/Coding-Assignment/blob/main/src/main/java/com/example/csv/CSVProcessor.java

## Endpoints

1. [GET] /entries?category?[category to be searched]:
    - Use this endpoint to search the entries based on category.
2. [POST] /entries:
    - Use this endpoint to save the entry object into database.


## Project Configuration

The project uses the following configuration for the Spring Boot application:

```properties
server.port = 8080
#To configuer your own server port please follow the path provided below and change the server.port value;
#Grow-Garden/src/main/resources/application.properties


spring.datasource.driver=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/codingAssignment
spring.datasource.username= Your Username
spring.datasource.password= Your Password

spring.jpa.hibernate.ddl-auto=update

```
## Setup

To run the application, follow these steps:

1. Ensure you have Java and MySQL installed on your system.

2. Set up the database with the provided connection details in the `application.properties`.

3. Run the Spring Boot application.

4. Access the application using the specified port (e.g., http://localhost:8080).
