# 💳 Expense Tracker - Backend REST API

A Spring Boot 3.x REST API with MongoDB for the Expense Tracker application.

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.2.5** (Web, Validation, Data MongoDB)
- **MongoDB** (Default: `mongodb://localhost:27017/expense_tracker`)
- **Maven 3.9+**

## 🚀 Setup & Running
1. Ensure MongoDB is running locally on port `27017`:
   ```bash
   net start MongoDB
   ```
2. Run the application with Maven:
   ```bash
   mvn spring-boot:run
   ```
3. The server runs on `http://localhost:8081` (configurable in `src/main/resources/application.properties`).

## 📡 REST API Endpoints
- `POST /api/expenses` - Create a new expense (201 Created)
- `GET /api/expenses` - List all expenses (Supports `?category=Food`)
- `GET /api/expenses/{id}` - Get a single expense
- `PUT /api/expenses/{id}` - Update an expense (200 OK)
- `DELETE /api/expenses/{id}` - Delete an expense (200 OK)
- `GET /api/expenses/total` - Get total spent across all or filtered expenses
