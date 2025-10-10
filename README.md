# Employee Management System

A simple Java project for managing employees using MySQL.  
The project allows you to **add, update, delete, and list employees** from a database through an interactive console menu.

---

## Features

- **Add Employee** – Insert new employees into the database.  
- **Update Employee** – Modify existing employee information.  
- **Delete Employee** – Remove employees from the database.  
- **List Employees** – Display all employee records.  
- **Console Menu** – Easy-to-use interactive menu for managing employees.

---

## Installation

1. Add the **MySQL connector JAR** file to your project dependencies.  
2. Ensure you have a **MySQL server running locally**.  
3. Update the connection settings in "GestionBBDD.java" if needed.

---

## Classes

### Employee
Represents an employee with the following attributes:  
- `id` (int)  
- `name` (String)  
- `age` (int)  
- `department` (String)  
- `salary` (double)  

Includes a **constructor**, **getters**, **setters**, and a **toString method**.

### GestionBBDD
Handles database operations:  
- Connects to the MySQL database.  
- Creates the database and `Employees` table if they do not exist.  
- Implements **CRUD operations**:
  - **Add Employee** – Insert new employees.  
  - **Update Employee** – Modify employee information by ID.  
  - **Delete Employee** – Remove employees by ID.  
  - **List Employees** – Display all employee records.  
- Provides a **console menu** for easy interaction.

### Main
Runs the **interactive console menu** to manage employees.

---

## Usage

1. Run the `main` method in `GestionBBDD.java`.  
2. Use the menu to:  
   - Add new employees.  
   - Update existing employees by ID.  
   - Delete employees by ID.  
   - List all employees.


