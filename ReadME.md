# To_Do_App API

## Overview
The **To_Do_App API** provides a simple and efficient way to manage tasks, including creating, updating, deleting, and filtering tasks by status and priority. This API also supports user authentication with features for user registration, login, and logout.

---

## Table of Contents
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Task Management](#task-management)
- [Schemas](#schemas)
- [Error Handling](#error-handling)

---

## API Endpoints

### Base URL
```plaintext
https://To_Do_App
```

### Authentication

#### Register a User
- **Endpoint**: `POST /api/v1/auth/register`
- **Description**: Registers a new user.
- **Request Body**:
  ```json
  {
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com",
    "password": "password123",
    "confirmPassword": "password123",
    "phoneNumber": "1234567890"
  }
  ```
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Registration successful",
    "registrationInfo": {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "token": "eyJhb..."
    }
  }
  ```

#### Login
- **Endpoint**: `POST /api/v1/auth/login`
- **Description**: Logs in an existing user.
- **Request Body**:
  ```json
  {
    "email": "john.doe@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Login successful",
    "loginInfo": {
      "email": "john.doe@example.com",
      "token": "eyJhb..."
    }
  }
  ```

#### Logout
- **Endpoint**: `POST /api/v1/auth/logout`
- **Description**: Logs out the authenticated user.
- **Headers**:
    - **Authorization**: Bearer token
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Logout successful"
  }
  ```

---

### Task Management

#### Get All Tasks
- **Endpoint**: `GET /api/v1/task`
- **Description**: Retrieves all tasks, with optional filtering by status and priority.
- **Query Parameters**:
    - `status` (optional): Filter by task status (`pending`, `in_progress`, `completed`).
    - `priority` (optional): Filter by task priority (`high`, `medium`, `low`, `none`).
- **Response**:
  ```json
  [
    {
      "id": 1,
      "title": "Complete project documentation",
      "description": "Finalize and submit the project documentation for review.",
      "priority": "high",
      "status": "in_progress"
    }
  ]
  ```

#### Create a Task
- **Endpoint**: `POST /api/v1/task`
- **Description**: Creates a new task.
- **Request Body**:
  ```json
  {
    "title": "New Task Title",
    "description": "Task description here"
  }
  ```
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Task created successfully"
  }
  ```

#### Update a Task
- **Endpoint**: `PUT /api/v1/task/{taskId}`
- **Description**: Updates an existing task.
- **Path Parameters**:
    - `taskId`: ID of the task to update.
- **Request Body**:
  ```json
  {
    "title": "Updated Task Title",
    "description": "Updated task description"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "title": "Updated Task Title",
    "description": "Updated task description",
    "priority": "medium",
    "status": "pending"
  }
  ```

#### Delete a Task
- **Endpoint**: `DELETE /api/v1/task/{taskId}`
- **Description**: Deletes a task by ID.
- **Path Parameters**:
    - `taskId`: ID of the task to delete.
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Task deleted successfully"
  }
  ```

#### Update Task Priority
- **Endpoint**: `PATCH /api/v1/task/{taskId}/priority`
- **Description**: Updates the priority of a task.
- **Path Parameters**:
    - `taskId`: ID of the task.
- **Request Body**:
  ```json
  {
    "priority": "high"
  }
  ```
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Priority updated successfully"
  }
  ```

#### Update Task Status
- **Endpoint**: `PATCH /api/v1/task/{taskId}/status`
- **Description**: Updates the status of a task.
- **Path Parameters**:
    - `taskId`: ID of the task.
- **Request Body**:
  ```json
  {
    "status": "completed"
  }
  ```
- **Response**:
  ```json
  {
    "responseCode": "200",
    "responseMessage": "Status updated successfully"
  }
  ```

---

## Schemas

### TaskResponseDto
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "priority": "String",
  "status": "String"
}
```

### TaskRequestDto
```json
{
  "title": "String",
  "description": "String"
}
```

### PriorityUpdateDto
```json
{
  "priority": "String"
}
```

### StatusUpdateDto
```json
{
  "status": "String"
}
```

### AuthenticationResponse
```json
{
  "responseCode": "String",
  "responseMessage": "String",
  "registrationInfo": {
    "firstName": "String",
    "lastName": "String",
    "email": "String",
    "token": "String"
  }
}
```

---

## Error Handling
All errors are returned in the following format:
```json
{
  "responseCode": "Error_Code",
  "responseMessage": "Detailed error message"
}
```

---

## Conclusion
The **To_Do_App API** is a robust solution for managing tasks and user authentication. It offers flexibility with filters and comprehensive task management capabilities. For any issues or further assistance, please contact the development team.

