# IHF-Integrated-Backend


## Purpose

**IHF-Integrated-Backend** is a dual login, dual project, single frontend application that integrates both Python and Java projects within a single version control repository. This project shares instance data via a common database and uses different DNS names for each project. The aim is to explore the challenges and solutions for database migration, build files, Docker files, and frontend logic to support two distinct logins.

## Project Structure

- **flask/**: Contains the Python Flask application.
- **spring/**: Contains the Java Spring Boot application.
- **.gitignore**: Specifies intentionally untracked files to ignore.
- **README.md**: Project documentation.
- **docker-compose.yml**: Configuration for Docker services.
- **sqlite.db**: SQLite database file.

## Getting Started

### Prerequisites

- Docker
- Docker Compose
- Java Development Kit (JDK) 11+
- Python 3.8+

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/giggle-juice.git
    cd giggle-juice
    ```

2. Build and start the Docker containers:

    ```bash
    docker-compose up --build
    ```

### Project Details

#### Flask (Python)

The Flask application handles one part of the dual login system. It includes:

- User authentication
- Interaction with the shared SQLite database
- API endpoints for frontend integration

Directory: `flask/`

#### Spring Boot (Java)

The Spring Boot application handles the other part of the dual login system. It includes:

- User authentication
- Interaction with the shared SQLite database
- API endpoints for frontend integration

Directory: `spring/`

### Database

This project uses a shared SQLite database (`sqlite.db`) to maintain instance data. Both the Flask and Spring Boot applications interact with this database.

### Configuration

The `docker-compose.yml` file contains environment variables and service definitions for running the applications. Update the environment variables as needed.

### Running the Applications

1. **Flask Application**:

    The Flask application will be accessible at the specified DNS name in your Docker configuration.

2. **Spring Boot Application**:

    The Spring Boot application will be accessible at the specified DNS name in your Docker configuration.

### Frontend

The frontend is designed to handle logins for both the Flask and Spring Boot applications. It routes requests based on the login type and interacts with the respective backend service.

### Issues and Considerations

- **Database Migration**: Ensure consistent schema across both projects. Use migration tools as needed.
- **Build Files**: Maintain separate build files for Flask (Python) and Spring Boot (Java).
- **Docker Files**: Use the `docker-compose.yml` to manage services and dependencies.
- **Frontend Logic**: Implement logic to distinguish and route logins to the correct backend.
