# Expense Tracker Web Application

## Project Overview

The Expense Tracker is a simple Java Web Application developed using Servlets, JSP, JDBC, and MySQL.

This application allows users to:
- Register
- Login
- Add Expenses
- View Expenses

The project demonstrates basic concepts of Java Web Technologies and database connectivity.

---

# Technologies Used

| Technology | Purpose |
|------------|----------|
| HTML | Create web pages |
| CSS | Styling |
| JavaScript | Form validation |
| JSP | Display dynamic content |
| Servlet | Backend processing |
| JDBC | Database connectivity |
| MySQL | Database storage |
| Apache Tomcat | Web server |

---

# Frontend (FE)

Frontend is the user interface of the application.  
It is the part users can see and interact with.

## Frontend Technologies Used
- HTML
- CSS
- JavaScript

## Frontend Pages
- register.html
- login.html
- dashboard.jsp

---

# Backend (BE)

Backend is responsible for:
- processing requests
- handling business logic
- database operations

## Backend Technologies Used
- Servlet
- JSP
- JDBC

## Backend Files
- RegisterServlet.java
- LoginServlet.java

---

# Database (DB)

Database stores application data permanently.

## Database Used
- MySQL

## Stored Data
- User Details
- Expense Details

---

# What is SQL?

SQL (Structured Query Language) is used to communicate with databases.

## SQL Operations
- Insert Data
- Retrieve Data
- Update Data
- Delete Data

## Example SQL Query

```sql
SELECT * FROM users;
```

---

# What is Apache Tomcat?

Apache Tomcat is a web server used to run Java Web Applications.

It executes:
- JSP
- Servlets

Tomcat receives browser requests and sends responses back to the client.

## Example URL

```text
http://localhost:8080
```

---

# What is Servlet?

Servlet is a Java class used for backend processing.

## Functions of Servlet
- Handle Requests
- Process Form Data
- Connect to Database
- Generate Responses

## Servlets Used
- RegisterServlet
- LoginServlet

---

# What is JSP?

JSP (Java Server Pages) is used to create dynamic web pages.

JSP combines:
- HTML
- Java Code

## Example

```jsp
<%= session.getAttribute("user") %>
```

---

# What is JDBC?

JDBC (Java Database Connectivity) is used to connect Java applications with databases.

## Functions of JDBC
- Connect Java with MySQL
- Execute SQL Queries
- Retrieve Database Data

## Example

```java
Connection con = DriverManager.getConnection();
```

---

# What is JavaScript?

JavaScript is used for client-side validation.

## Uses of JavaScript
- Validate Forms
- Check Empty Fields
- Validate Password Length

## Example

```javascript
if(password.length < 6)
```

---

# JSP vs Servlet

| JSP | Servlet |
|-----|----------|
| Used for UI | Used for Logic |
| HTML based | Java based |
| Displays data | Processes data |
| Easier for design | Easier for backend logic |

---

# What is web.xml?

web.xml is called Deployment Descriptor.

## Purpose of web.xml
- Maps URLs to Servlets
- Configures the Web Application

## Example

```xml
<url-pattern>/login</url-pattern>
```

---

# MVC Architecture

MVC stands for:

| Component | Meaning |
|-----------|----------|
| Model | Database |
| View | JSP/HTML Pages |
| Controller | Servlets |

---

# MVC Flow in This Project

## Model
- MySQL Database

## View
- register.html
- login.html
- dashboard.jsp

## Controller
- RegisterServlet
- LoginServlet

---

# Project Workflow

1. User opens registration page
2. User registers
3. Data stored in MySQL
4. User logs in
5. LoginServlet validates credentials
6. Session created
7. Dashboard displayed
8. User adds expenses
9. Expenses displayed from database

---

# Database Tables

## users Table

| Field |
|-------|
| name |
| email |
| password |

---

## expenses Table

| Field |
|-------|
| username |
| title |
| amount |

---

# Features

- User Registration
- User Login
- Session Management
- Add Expense
- View Expenses
- JavaScript Validation
- Database Connectivity

---

# Folder Structure

```text
ExpenseTracker/
│
├── src/
│   ├── RegisterServlet.java
│   └── LoginServlet.java
│
├── WebContent/
│   ├── register.html
│   ├── login.html
│   ├── dashboard.jsp
│   ├── style.css
│   │
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/
│           └── mysql-connector-j.jar
```

---

# Advantages

- Simple and easy to understand
- Beginner friendly
- Demonstrates Java Web concepts
- Lightweight application

---

# Conclusion

The Expense Tracker Web Application successfully demonstrates:
- Java Web Development
- Database Connectivity
- Session Management
- JSP and Servlet Integration
- MVC Architecture

This project helps understand the fundamentals of full-stack Java Web Application development.
