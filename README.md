# 🕐 OpenHours — Automated Office Hours Builder

A Spring Boot application designed to help professors and graders **automatically build and manage office hours schedules**. The system manages users (with roles such as Professor, Grader, and Student), tracks class sessions with time windows, and provides a REST API for querying and scheduling availability.

## ✨ Features

- **Role-based user management** — users are stored with a `role` field (Professor, Grader, Student) and associated `course`
- **Class session tracking** — `ClassSessions` entity records the day of week, start time, and end time for each class, linked to users by email
- **Spring Data JPA persistence** — user and class session data persisted to MySQL via Hibernate
- **Spring Security** — authentication layer configured for protecting scheduling endpoints
- **Grader repository** — dedicated `GraderRepository` for querying grader-specific scheduling data
- **Service layer abstraction** — `UserService` interface + `UserServiceImplementation` and `Professor` + `ProfessorClassImplmentation` separate business logic from controllers

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot |
| Persistence | Spring Data JPA + Hibernate |
| Database | MySQL |
| Security | Spring Security |
| Build | Maven |
| Dev Tools | Spring Boot DevTools |

## 🚀 Setup & Installation

**Prerequisites:** Java 17+, Maven, MySQL

```bash
# 1. Clone the repository
git clone https://github.com/moksh555/OpenHours.git
cd OpenHours

# 2. Create a MySQL database
mysql -u root -p -e "CREATE DATABASE open_hours;"

# 3. Configure database credentials
# Edit src/main/resources/application.properties:
#   spring.datasource.url=jdbc:mysql://localhost:3306/open_hours
#   spring.datasource.username=<your_username>
#   spring.datasource.password=<your_password>
#   spring.jpa.hibernate.ddl-auto=update

# 4. Build and run
mvn spring-boot:run
```

## 🏗️ Architecture

The application follows a standard Spring Boot layered architecture:

```
HTTP Request
    │
Controller Layer
    │
Service Layer (UserService / Professor interfaces + implementations)
    │
Repository Layer (UserRepository / GraderRepository — JPA)
    │
MySQL Database
```

### Data Model

**User**
| Field | Type | Description |
|-------|------|-------------|
| id | Integer | Primary key |
| firstName | String | User's first name |
| lastName | String | User's last name |
| email | String | Unique identifier for class linking |
| role | String | `Professor`, `Grader`, or `Student` |
| course | String | Associated course identifier |
| classes | List\<ClassSessions\> | Scheduled class sessions |

**ClassSessions**
| Field | Type | Description |
|-------|------|-------------|
| email | String | Links session to a user |
| day | String | Day of week (e.g., `Monday`) |
| startTime | LocalDateTime | Session start |
| endTime | LocalDateTime | Session end |

## 📋 Design Notes

- The `Professor` service interface and `ProfessorClassImplmentation` class are scaffolded for future office-hours generation logic (finding open windows between class sessions)
- The `GraderRepository` (separate from `UserRepository`) supports dedicated queries for grader availability independently of professors
- `ClassSessions` is stored in a `classes` table and linked to users via the `email` field, enabling cross-user schedule lookups without foreign key coupling
