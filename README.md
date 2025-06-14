# GreetingsApp-springboot


This is a simple Spring Boot application that demonstrates basic RESTful API operations with an in-memory database using JPA. It provides a greeting service that returns "Hello World" messages, supports personalized greetings, and allows CRUD operations on greeting messages.

---

##  Features

### ✅ Use Cases Covered:
1. **Basic HTTP Methods** – Returns simple text messages for GET, POST, PUT, DELETE requests.
2. **Service Layer Greeting** – Returns a message from the service layer (`"Hello World"`).
3. **Personalized Greeting** – Generates a greeting message based on optional first and/or last name.
4. **Save Greeting** – Stores a greeting message in the database.
5. **Find Greeting by ID** – Retrieves a greeting by its unique ID.
6. **List All Greetings** – Displays all stored greeting messages.
7. **Edit Greeting** – Updates an existing greeting's message by ID.
8. **Delete Greeting** – Deletes a greeting by ID.

---



## API Endpoints

### Basic HTTP Methods

| Method | Endpoint     | Description             |
|--------|--------------|-------------------------|
| GET    | `/greetings` | Returns "GET: Hello World" |
| POST   | `/greetings` | Returns "POST: Hello World" |
| PUT    | `/greetings` | Returns "PUT: Hello World" |
| DELETE | `/greetings` | Returns "DELETE: Hello World" |

### Functional Endpoints

| Method | Endpoint                | Description |
|--------|-------------------------|-------------|
| GET    | `/greetings/message`    | Returns static message from service |
| GET    | `/greetings/custom`     | Returns personalized message via `firstName` and/or `lastName` |
| POST   | `/greetings/save`       | Saves a new greeting (`Greeting` JSON in body) |
| GET    | `/greetings/{id}`       | Fetches greeting by ID |
| GET    | `/greetings/all`        | Lists all saved greetings |
| PUT    | `/greetings/{id}`       | Updates greeting message by ID |
| DELETE | `/greetings/{id}`       | Deletes greeting by ID |

---

## Testing With Postman or Curl

### Save a Greeting
```bash
POST /greetings/save
Content-Type: application/json

{
  "message": "Good Morning!"
}
````

### Get Greeting by ID

```bash
GET /greetings/1
```

### Get All Greetings

```bash
GET /greetings/all
```

### Update Greeting

```bash
PUT /greetings/1
Content-Type: application/json

{
  "message": "Updated Message"
}
```

### Delete Greeting

```bash
DELETE /greetings/1
```

### Personalized Greeting

```bash
GET /greetings/custom?firstName=likhitha&lastName=pulluru
```

---

## ⚙️ Run the Project

1. Clone the repo:

   ```bash
   git clone https://github.com/your-repo-name/greeting-app.git
   cd greeting-app
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Visit: `http://localhost:8080/greetings`


