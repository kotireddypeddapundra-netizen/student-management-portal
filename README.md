# 🎓 Student Management Portal

[![Java](https://img.shields.io/badge/Java-25%20%2F%2017%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-blue.svg)](https://spring.io/projects/spring-data-jpa)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM%207-lightgrey.svg)](https://hibernate.org/)
[![React](https://img.shields.io/badge/React-19.3.0-blue.svg)](https://reactjs.org/)
[![React Router](https://img.shields.io/badge/React%20Router-7.18.4-red.svg)](https://reactrouter.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue.svg)](https://www.mysql.com/)

A modern full-stack web application designed for colleges and universities to manage students, academic branches, and course enrollments. **Student Management Portal** features a RESTful backend built with **Spring Boot** and **Spring Data JPA**, paired with an interactive **React** single-page frontend.

The system features robust relational entity mapping with **One-to-Many** (`Course` ➔ `Student`) and **Many-to-One** (`Student` ➔ `Course`) associations, cascading persistence, batch student enrollment, real-time student directory, and full CRUD operations.

---

## 🌟 Key Features

### 📚 Academic & Course Management
- **Course Administration**: Create, view, update, and delete academic courses.
- **Relational One-to-Many Mapping**: Each course can enroll multiple students with automatic cascading persistence (`CascadeType.ALL`).
- **Course Student Filtering**: Instantly fetch all students enrolled in a specific course via `/student/bycourse/{cId}`.

### 🎓 Student Records & Enrollment
- **Full Student Lifecycle Tracking**: Store and manage first name, last name, branch, age, marks, email ID, phone number, and enrolled course.
- **Insert Multiple Students in One Course**:
  - Automatically cascade and persist a list of students when creating a course in a single payload.
  - Bulk-enroll multiple students via the dedicated batch endpoint (`/student/insertmany`).
- **Relational Mapping & Jackson Recursion Handling**: Bi-directional `@OneToMany` and `@ManyToOne` mapping utilizing `@JsonIgnoreProperties` to eliminate bidirectional recursion during JSON serialization.

### 💻 Modern React Frontend
- **Student Registration**: Clean, responsive form to register new students with instant state updates.
- **Live Student Directory**: Tabular overview displaying all registered students with personal details, marks, and contact records.
- **Client-Side Routing**: Built with React Router v7 for seamless client-side navigation between student registration and directory views.
- **Configured Cross-Origin Support**: Pre-configured with `@CrossOrigin(origins = "http://localhost:3000")` for smooth local and development integration.

---

## 🏗️ Tech Stack & Architecture

- **Backend**: Java 25 / 17+, Spring Boot 4.1.1, Spring Data JPA, Hibernate ORM 7.x, Spring Web MVC, Project Lombok, MySQL Connector/J.
- **Database**: MySQL 8.0+ (`new`).
- **Frontend**: React 19.3, React Router DOM 7.18, Axios, HTML5, CSS3.
- **Architecture**: Layered RESTful MVC architecture:
  - **Controllers**: Handle HTTP endpoints, parameter validation, and JSON responses.
  - **Services**: Encapsulate business logic, transactional boundaries, and cascading associations.
  - **Repositories**: Spring Data JPA repositories with query derivation.
  - **Models**: JPA entities representing relational tables.
- **Testing**: Automated JUnit 5 integration tests (`StudentApplicationTests.java`).

---

## 📂 Project Structure

```
student-management-portal/
├── backend/
│   ├── pom.xml                                  # Maven dependencies & build configuration
│   ├── mvnw / mvnw.cmd                          # Maven Wrapper executables
│   ├── .mvn/                                    # Maven Wrapper properties
│   └── src/
│       ├── main/
│       │   ├── resources/
│       │   │   └── application.properties       # Server port (9998) & MySQL connection
│       │   └── java/com/college/student/
│       │       ├── StudentApplication.java      # Spring Boot application entry point
│       │       ├── controller/
│       │       │   ├── CourseController.java    # REST controller for Course endpoints
│       │       │   └── StudentController.java   # REST controller for Student endpoints & batch operations
│       │       ├── model/
│       │       │   ├── Course.java              # Course Entity (@OneToMany with Student)
│       │       │   └── Student.java             # Student Entity (@ManyToOne with Course)
│       │       ├── repo/
│       │       │   ├── CourseRepo.java          # Spring Data JPA repository for Course
│       │       │   └── StudentRepo.java         # Spring Data JPA repository for Student
│       │       └── service/
│       │           ├── CourseService.java       # Course service contract
│       │           ├── CourseServiceImpl.java   # Course business logic & cascading save
│       │           ├── StudentService.java      # Student service contract
│       │           └── StudentServiceImpl.java  # Student business logic & batch operations
│       └── test/java/com/college/student/
│           └── StudentApplicationTests.java     # Automated integration & CRUD tests
├── frontend/
│   ├── package.json                             # React dependencies & NPM scripts
│   ├── package-lock.json                        # NPM dependency tree lockfile
│   ├── public/
│   │   ├── index.html                           # Single-page HTML shell
│   │   ├── favicon.ico
│   │   └── manifest.json
│   └── src/
│       ├── App.js                               # Application root component
│       ├── Routing.js                           # React Router v7 routes (/insert, /selectall)
│       ├── Nav.js                               # Top navigation component
│       ├── InsertStudent.js                     # Student registration form
│       ├── GetStudent.js                        # Tabular student directory viewer
│       ├── StudentService.js                    # Axios API service client
│       ├── index.js                             # React DOM bootstrap entry point
│       └── index.css / App.css                  # UI styles
├── .gitignore                                   # Root Git ignore rules (node_modules, target, IDE files)
└── README.md                                    # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites
- **Java 17+ or 25** (Java 25 LTS recommended)
- **Node.js** (v18+ LTS recommended) & **npm**
- **MySQL Server** (running on port `3306`)

---

### 1. Database Setup
Open MySQL Workbench or MySQL CLI and run:
```sql
CREATE DATABASE new;
```

---

### 2. Backend Setup
1. Open `backend/src/main/resources/application.properties` and verify your MySQL username and password:
   ```properties
   spring.application.name=student
   server.port=9998

   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://localhost:3306/new
   spring.datasource.username=root
   spring.datasource.password=root

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
2. Open terminal in the `backend` folder and start the backend using Maven:
   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```
   *(Or open `backend` in Eclipse, IntelliJ IDEA, or Spring Tool Suite as a Maven project and run `StudentApplication.java`)*.
3. The backend service will start on **`http://localhost:9998`**.

---

### 3. Frontend Setup
1. Open a new terminal and navigate to the `frontend` folder:
   ```bash
   cd frontend
   npm install
   ```
2. Start the React development server:
   ```bash
   npm start
   ```
3. Open **`http://localhost:3000`** in your browser.

---

## 📡 API Documentation

### 📚 Course Endpoints (`/course`)

| Method | Endpoint | Description | Sample Request Body |
| :--- | :--- | :--- | :--- |
| `POST` | `/course/insert` | Create a course (supports cascading student list) | See below |
| `GET` | `/course/selectall` | Retrieve all courses | - |
| `GET` | `/course/selectbyid/{cId}` | Retrieve a course by its ID | - |
| `PUT` | `/course/update/{cId}` | Update course details | `{ "cName": "Computer Science & Engineering" }` |
| `DELETE` | `/course/delete/{cId}` | Delete a course and its associated records | - |

#### Sample Request: Create Course with Multiple Students
```json
POST /course/insert
Content-Type: application/json

{
  "cName": "Artificial Intelligence",
  "students": [
    {
      "fName": "Alice",
      "lName": "Johnson",
      "branch": "CSE",
      "age": 21,
      "marks": 92,
      "emailId": "alice.j@college.edu",
      "phnNo": 9876543210
    },
    {
      "fName": "Bob",
      "lName": "Williams",
      "branch": "CSE",
      "age": 22,
      "marks": 88,
      "emailId": "bob.w@college.edu",
      "phnNo": 9876543211
    }
  ]
}
```

---

### 🎓 Student Endpoints (`/student`)

| Method | Endpoint | Description | Sample Request Body |
| :--- | :--- | :--- | :--- |
| `GET` | `/student/hi` | Service status check | - |
| `POST` | `/student/insert` | Register a single student | See below |
| `POST` | `/student/insertmany` | Batch register multiple students | Array of student objects |
| `GET` | `/student/selectall` | Retrieve all registered students | - |
| `GET` | `/student/selectbyid/{sId}` | Retrieve a student by ID | - |
| `GET` | `/student/bycourse/{cId}` | Retrieve all students in a specific course | - |
| `PUT` | `/student/update/{sId}` | Update student information | See below |
| `DELETE` | `/student/delete/{sId}` | Delete student record | - |

#### Sample Request: Insert Single Student
```json
POST /student/insert
Content-Type: application/json

{
  "fName": "John",
  "lName": "Doe",
  "branch": "ECE",
  "age": 20,
  "marks": 85,
  "emailId": "john.doe@college.edu",
  "phnNo": 9876543210,
  "course": {
    "cId": 1
  }
}
```

#### Sample Request: Update Student
```json
PUT /student/update/1
Content-Type: application/json

{
  "fName": "John",
  "lName": "Doe",
  "branch": "ECE",
  "age": 21,
  "marks": 90,
  "emailId": "john.doe@college.edu",
  "phnNo": 9876543210,
  "course": {
    "cId": 1
  }
}
```

---

## 🧪 Automated Testing

Automated integration tests verify complete end-to-end relational workflows:
```bash
cd backend
./mvnw test
```

The test suite validates:
- Course creation with cascading student list.
- Batch enrollment and retrieval by course ID.
- Bi-directional association persistence and isolation.
- Full CRUD operations on both courses and students.

---

## 👤 Author

Developed by **[PEDDAPUNDRA KOTI REDDY](https://github.com/kotireddypeddapundra-netizen)**.
