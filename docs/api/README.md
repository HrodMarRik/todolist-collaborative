# API Documentation - ToDoList Collaborative

## Overview
This document describes the REST API endpoints for the ToDoList Collaborative application.

## Base URL
- Development: `http://localhost:8080/api`
- Production: `https://api.todolist-collaborative.com/api`

## Authentication
All endpoints (except login/register) require JWT authentication via the `Authorization` header:
```
Authorization: Bearer <jwt_token>
```

## Endpoints

### Authentication
| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/auth/login` | User login | `{email, password}` |
| POST | `/auth/register` | User registration | `{nom, email, password}` |
| POST | `/auth/refresh` | Refresh JWT token | `{refreshToken}` |

### Users
| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/users` | Get all users | - |
| GET | `/users/{id}` | Get user by ID | - |
| PUT | `/users/{id}` | Update user | `{nom, email, role}` |
| DELETE | `/users/{id}` | Delete user | - |

### Projects
| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/projects` | Get all projects | - |
| POST | `/projects` | Create project | `{nom, description}` |
| GET | `/projects/{id}` | Get project by ID | - |
| PUT | `/projects/{id}` | Update project | `{nom, description}` |
| DELETE | `/projects/{id}` | Delete project | - |
| POST | `/projects/{id}/members` | Add member to project | `{userId, role}` |
| DELETE | `/projects/{id}/members/{userId}` | Remove member from project | - |

### Tasks
| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/tasks` | Get all tasks | - |
| POST | `/tasks` | Create task | `{titre, description, statut, priorite, dateLimite, projetId, utilisateurId}` |
| GET | `/tasks/{id}` | Get task by ID | - |
| PUT | `/tasks/{id}` | Update task | `{titre, description, statut, priorite, dateLimite}` |
| DELETE | `/tasks/{id}` | Delete task | - |
| PUT | `/tasks/{id}/status` | Update task status | `{statut}` |
| PUT | `/tasks/{id}/assign` | Assign task to user | `{utilisateurId}` |

## Response Format
All responses follow this format:
```json
{
  "success": true,
  "data": { ... },
  "message": "Operation successful",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

## Error Format
Error responses follow this format:
```json
{
  "success": false,
  "error": "Error message",
  "code": "ERROR_CODE",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

## Status Codes
- `200` - Success
- `201` - Created
- `400` - Bad Request
- `401` - Unauthorized
- `403` - Forbidden
- `404` - Not Found
- `500` - Internal Server Error
