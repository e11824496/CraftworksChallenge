# Creativeworks Challenge

## Usage

To start Posgresql and Backend use: 
```
docker compose up --build 
```

This builds the backend based on the latest local build. 
The jar files are included within the repo (yeah probably not the best method but works well for this challenge). 

Standard gradle build should work for Java 17. 

## API Endpoints

The `TaskController` class in this Spring Boot application provides a set of endpoints to manage tasks. The endpoints allow you to perform various CRUD (Create, Read, Update, Delete) operations on tasks. Here's a summary of the available endpoints:

### 1. Get All Tasks

- **Endpoint:** `GET /tasks`
- **Description:** Retrieves a list of all tasks.
- **Response:** Returns a list of `TaskDto` objects representing tasks. Returns an empty list if no tasks are found. Returns HTTP status code 200 (OK) if successful, or 204 (No Content) if no tasks are available.
- **Error Handling:** Returns HTTP status code 500 (Internal Server Error) if an exception occurs during the operation.

### 2. Get Task by ID

- **Endpoint:** `GET /tasks/{id}`
- **Description:** Retrieves a specific task by its ID.
- **Parameters:** `id` (Long) - The ID of the task.
- **Response:** Returns a `TaskDto` object representing the requested task.
- **Error Handling:** Returns HTTP status code 404 (Not Found) if the task with the specified ID is not found. Returns HTTP status code 500 (Internal Server Error) if an exception occurs during the operation.

### 3. Delete Task by ID

- **Endpoint:** `DELETE /tasks/{id}`
- **Description:** Deletes a specific task by its ID.
- **Parameters:** `id` (Long) - The ID of the task to be deleted.
- **Response:** Returns a `TaskDto` object representing the deleted task.
- **Error Handling:** Returns HTTP status code 404 (Not Found) if the task with the specified ID is not found. Returns HTTP status code 500 (Internal Server Error) if an exception occurs during the operation.

### 4. Create Task

- **Endpoint:** `POST /tasks`
- **Description:** Creates a new task.
- **Request Body:** Expects a JSON object representing a `TaskDto`.
- **Response:** Returns a `TaskDto` object representing the newly created task.
- **Error Handling:** Returns HTTP status code 500 (Internal Server Error) if an exception occurs during the operation.

### 5. Update Task by ID

- **Endpoint:** `PUT /tasks/{id}`
- **Description:** Updates an existing task by its ID.
- **Parameters:** `id` (Long) - The ID of the task to be updated.
- **Request Body:** Expects a JSON object representing a `TaskDto` with updated information.
- **Response:** Returns a `TaskDto` object representing the updated task.
- **Error Handling:** Returns HTTP status code 404 (Not Found) if the task with the specified ID is not found. Returns HTTP status code 500 (Internal Server Error) if an exception occurs during the operation.
