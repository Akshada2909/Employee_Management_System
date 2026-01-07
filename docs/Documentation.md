# Employee Management System – Project Documentation

## 1. Project Overview
The **Employee Management System** is a console-based Java application designed to manage employee records efficiently.  
The system allows users to add, view, search, update, and delete employee details, generate reports, and store employee data permanently using file handling.

This project is developed as part of the **Week 4 Internship Task** to demonstrate the use of **Java Collections, File Handling, Exception Handling**, and Object-Oriented Programming concepts.

---

## 2. Project Objectives
- Understand and apply Java Collections (`ArrayList`)
- Implement CRUD operations on employee data
- Store and retrieve data using file handling
- Apply exception handling for runtime safety
- Generate employee-based reports
- Build a menu-driven console application

---

## 3. Technologies Used
- Java (JDK 8 or above)
- Spring Tool Suite (STS) / Eclipse
- Java Collections Framework
- Java File Handling
- GitHub

---

## 4. System Requirements

### Hardware Requirements
- Minimum 4 GB RAM
- Any standard desktop or laptop

### Software Requirements
- Windows Operating System
- Java JDK 8 or above
- Spring Tool Suite (STS)

---

## 5. Project Installation Steps
1. Install Java JDK (8 or above)
2. Install Spring Tool Suite (STS)
3. Clone or download the project repository
4. Open STS → File → Import → Existing Projects into Workspace
5. Select the project folder and click **Finish**
6. Ensure `employees.txt` file exists inside the `data` folder
7. Run `EmployeeManagementSystem.java`
8. Follow the console menu

---

## 6. Project Structure
Employee-Management-System/
│
├── src/
│ ├── Employee.java
│ ├── EmployeeManagementSystem.java
│ ├── EmployeeFileHandler.java
│ └── EmployeeReportGenerator.java
│
├── data/
│ └── employees.txt
│
├── docs/
│ └── Documentation.md
│
└── README.md


---

## 7. Code Description

### Employee.java
- Defines employee properties
- Uses encapsulation with private variables
- Provides getters and setters

### EmployeeManagementSystem.java
- Main class
- Displays menu
- Handles user input
- Controls application flow

### EmployeeFileHandler.java
- Saves employee data to file
- Loads employee data from file
- Uses exception handling

### EmployeeReportGenerator.java
- Generates employee reports
- Salary and department-based summaries

---

## 8. Application Features
- Add new employee
- View all employees
- Search employee
- Update employee details
- Delete employee record
- Generate reports
- Save data to file
- Load data from file

---

## 9. Menu Options


Add New Employee

View All Employees

Search Employee

Update Employee

Delete Employee

Generate Reports

Save to File

Load from File

Exit


---

## 10. Data Validation and Exception Handling
- Prevents duplicate employee IDs
- Validates numeric salary input
- Handles file read/write exceptions
- Prevents program crash

---


## 11. Conclusion
The Employee Management System is a complete console-based Java application fulfilling all **Week 4 Internship Task** requirements.  
It demonstrates practical implementation of OOP concepts, collections, file handling, and exception handling.

---

## 12. Author
**Akshada Shelke**  
T.Y. BSc Computer Science  
Internship Project – Week 4