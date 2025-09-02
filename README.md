# 📋 Task Manager API

Task Manager API is a RESTful service built with **Spring Boot** that allows managing tasks efficiently.  
It supports creating, retrieving, updating, and deleting tasks, providing a simple workflow for task tracking.

---

## 🚀 Features
- Create new tasks
- List all tasks
- Retrieve task by ID
- Update task status
- Delete tasks
- API documentation with **Swagger**
- Containerization with **Docker**
- In-memory database support (H2)
  
H2 database is embedded; no additional configuration is needed and already include some inserted records.
H2 will store data in memory by default, so all data is lost when you stop the container.

---

## 🗂️ API Endpoints

All endpoints are prefixed with `/tasks`.

| Method | Endpoint         | Description              | Request Body         | Response |
|--------|------------------|--------------------------|----------------------|----------|
| `GET`  | `/tasks`         | Get all tasks           | —                    | `200 OK` JSON array of tasks |
| `POST` | `/tasks`         | Create a new task       | JSON (title, status, description?, dueDate?) | `200 OK` Task object |
| `GET`  | `/tasks/{id}`    | Get task by ID          | —                    | `200 OK` Task object |
| `PUT`  | `/tasks/{id}`    | Update task status      | JSON Task object     | `200 OK` Task updated |
| `DELETE` | `/tasks/{id}`  | Delete task by ID       | —                    | `200 OK` |

**Sample task object:**
```json
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "title": "Finish project",
  "description": "Complete the API and prepare docs",
  "dueDate": "2025-10-01",
  "status": "PENDING"
}
```
---

# 📖 Swagger API Docs

Once the application is running, visit:

http://localhost:8080/swagger-ui/index.html

---

## ⚙️ Running the Project Locally
### ✅ Prerequisites
- Java 21+
- Maven

### ▶️ Run
#### 1. Clone the repository:

```bash
git clone https://github.com/DenisseCruz16/task-manager.git

cd task-manager
```

#### 2. Build the project:

```bash
mvn clean install
```

#### 3. Run the application:

```bash
mvn spring-boot:run
```

#### 4. Test the API using Postman or CURL:

```bash
curl -X GET http://localhost:8080/tasks
```

---

## 🐳 Running the Project with Docker 
### ✅ Prerequisites

- Docker installed on your machine.

## ▶️ Steps

### 1. Build the Docker image:

```bash
docker build -t task-manager .
```

### 2. Run the container:

```bash
docker run -p 8080:8080 task-manager
```

Similar to local run, the API will be available at: http://localhost:8080.

---
## Rapid Learning Challenges

**• What steps did you take to learn Swagger if you hadn't used it before?**

  - Investigate Swagger and how to implement it with Spring.
  - Compared different sources (YouTube videos, written articles, and updated guides) to grasp how to present an organized and professional documentation view.
  - Used Swagger editor template and corrected with AI help.
  - Continuous testing of the interface.
  - Consulted specific questions among several web resources.
  - Took brief written notes and saved useful links in a Word file for future reference.
    
**• How did you resolve questions about Docker?**
- Refresh Docker knowledge on docker file, docker image and docker container concepts.
- Compared different sources (YouTube videos, written articles, and official guides) to understand basic structure and compare benefits or Spring generated and manual Dockerfile.
- Continuous testing and specific corrections with AI help.
- Use comments in file for my reference.

**• What challenges did you encounter?**

  - Coming from a production support background, I realized that I needed to refresh and deepen my knowledge in certain technologies that I had not actively worked with for some time. This project gave me the opportunity to revisit those tools and concepts, and although it required effort to get back up to speed, it turned out to be an enriching experience. I not only reinforced my technical skills but also gained greater confidence in applying them in a practical context. Overall, I truly value the challenge because it pushed me out of my comfort zone and contributed significantly to my professional growth.
    
**• What would you improve if you had more time?**

  - Stronger validations for Request Body and exception handling to cover edge cases.
  - Investigate more on how to leverage Lombok.
  - Implement bonus criteria (especially security)
  - Delve deeper on Docker and Swagger
