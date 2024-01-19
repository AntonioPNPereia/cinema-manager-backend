# Cinema Management System (Backend)

Cinema Management System is a Java-based backend application that enables the administration of cinemas, movies, rooms, and screening schedules.

## Getting Started

These instructions will help you set up and run the backend on your local machine.

### Prerequisites

- Java Development Kit (JDK) 17
- Maven 3.x
- PostgreSQL
- Docker

### Installing

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/cinema-management-backend.git
   ```

2. Navigate to the project directory, and build the project using Maven:

   ```bash
   cd cinema-management-backend
    ```

    ```bash
    mvn clean install 
    ```

### Database Setup

1. Start a PostgreSQL container using Docker:

    ```bash
    docker run -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=db_cinemas postgres:latest
    ```




## Built With

* **Spring Boot** - Java-based framework;

* **Maven** - Dependency management;

* **PostgreSQ**L - Database;