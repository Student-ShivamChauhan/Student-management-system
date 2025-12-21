# Student-management-system
The Student Record Management System is a Java-based application used to store and manage student information efficiently.

# Student Management System

A Java GUI-based application to manage student records using **Java**,
**Swing**, **JDBC**, and **MySQL**.

------------------------------------------------------------------------

## Features

-   Add new students
-   Update student details
-   Delete students
-   Search students
-   Display all records

------------------------------------------------------------------------

## Project Structure

    StudentManagementSystem/
     ├── src/
     │    ├── model/Student.java
     │    ├── dao/StudentDAO.java
     │    ├── ui/StudentUI.java
     │    └── util/DBConnection.java
     ├── database.sql
     └── README.md

------------------------------------------------------------------------

## Technologies Used

-   Java (OOP Concepts)
-   Swing for GUI
-   JDBC for database connectivity
-   MySQL database

------------------------------------------------------------------------

## How to Run

1.  Install Java JDK 8+\
2.  Install MySQL Server\
3.  Import `database.sql` into MySQL\
4.  Update DB credentials inside `DBConnection.java`\
5.  Compile and run:

```{=html}
<!-- -->
```
    javac *.java
    java Main

------------------------------------------------------------------------

## Database Schema (MySQL)

    CREATE TABLE students (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(100),
        age INT,
        department VARCHAR(100)
    );

------------------------------------------------------------------------

## JDBC Flow

-   Load driver\
-   Connect to DB\
-   Run queries\
-   Display results in GUI


StudentManagement/
│
├── src/
│   ├── controller/
│   │   └── StudentServlet.java
│   ├── dao/
│   │   └── StudentDAO.java
│   ├── model/
│   │   └── Student.java
│   └── util/
│       └── DBConnection.java
│
├── WebContent/
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   └── validation.js
│   ├── addStudent.jsp
│   ├── viewStudent.jsp
│   └── index.jsp
│
├── WEB-INF/
│   └── web.xml
│
└── README.md





# Student Management Web Application

## Technologies Used
- Java (Servlet, JSP)
- MySQL
- HTML, CSS, JavaScript

## Features
- Add Student
- View Student List
- Input Validation
- MVC Architecture

## How to Run
1. Import project in Eclipse
2. Configure MySQL DB
3. Run on Apache Tomcat


