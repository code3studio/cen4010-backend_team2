# System Setup Guide

## Prerequisites

Before running the system, ensure you have the following dependencies installed:

### Frontend (Next.js)

1. **Node.js** (v18.x or later) - Download and install from [Node.js official site](https://nodejs.org/).
2. **npm** or **yarn** (Package Manager) - Installed with Node.js.
3. **Git** (optional, for cloning the repository) - Download from [Git official site](https://git-scm.com/).

### Backend (Spring Boot with Java 17)

1. **Java 17** - Install from [Adoptium](https://adoptium.net/) or another distribution.
3. **MySQL** (v8.x recommended) - Install from [MySQL official site](https://dev.mysql.com/downloads/mysql/).
4. **Postman** (optional, for testing API endpoints) - Download from [Postman](https://www.postman.com/).

## Environment Setup

### Database Configuration

- Create a MySQL database named `database_name`.
- Configure user permissions and credentials.
- Example MySQL command:
  ```sql
  CREATE DATABASE database_name;
  CREATE USER 'your_user'@'localhost' IDENTIFIED BY 'your_password';
  GRANT ALL PRIVILEGES ON database_name.* TO 'your_user'@'localhost';
  FLUSH PRIVILEGES;
  ```

### Backend Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/jusoto/cen4010-backend
   cd cen4010-backend
   ```
2. Configure the `application.yml` file for database connection:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/database_name
   spring.datasource.username=your_user
   spring.datasource.password=your_password
   ```
3. Build and run the backend:
   ```sh
   ./gradlew bootRun
   ```

### Frontend Setup

1. Navigate to the frontend directory:
   ```sh
   git clone https://github.com/jusoto/cen4010-front-end
   cd cen4010-front-end
   ```
2. Install dependencies:
   ```sh
   npm install  # or yarn install
   ```
3. Start the Next.js application:
   ```sh
   npm run dev  # or yarn dev
   ```

## Running the System

- Ensure the database is running.
- Start the backend first, then the frontend.
- Access the frontend via `http://localhost:3000`.
- API should be accessible at `http://localhost:8080`.

## Notes

- Adjust port configurations in `application.properties` file if necessary.
- Ensure firewall or antivirus is not blocking required ports.
- Use Docker if you prefer containerized deployment.

For further setup or troubleshooting, refer to the respective framework documentation.

