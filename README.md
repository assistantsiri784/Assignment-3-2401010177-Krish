# Assignment-3-2401010177-Krish
📘 Student Result Management System (Java)

A Java-based console application that manages student information, validates marks, calculates results, and demonstrates complete Java exception-handling concepts.
This project is part of an academic assignment focusing on robust error handling, custom exceptions, and clean program structure.

🚀 Features
✔ Student Management

Add student details (Roll Number, Name, Marks)

Validate marks for 3 subjects

Display student details using roll number

Compute average marks

Determine Pass/Fail status automatically

✔ Exception Handling Demonstrated

Built-in exceptions:

InputMismatchException

NumberFormatException

IllegalArgumentException

Custom exception:

InvalidMarksException

Usage of:

throw

throws

Multiple try-catch blocks

finally block for resource cleanup

✔ Validations

Marks must be within 0–100

Prevents duplicate roll numbers

Handles invalid input formats

Graceful error messages for users

📂 Project Structure
ResultManagementSystem.java     # Contains entire program:
                               # - Custom exception
                               # - Student class
                               # - Manager/menu class
README.md                       # Project documentation


(Full implementation is inside a single Java file as required.)

🧠 Concepts Covered (Course Outcomes)
CO1: Java Exception Handling

Understanding and handling built-in and custom exceptions.

CO2: Checked vs Unchecked Exceptions

Using a custom checked exception (InvalidMarksException).

CO3: Exception Propagation

Demonstrating throw and throws in method signatures.

CO4: Custom Exception Design

Creating a domain-specific exception for student mark validation.

CO5: Robust Program Execution

Utilizing try-catch-finally for reliable program flow.

🎯 Learning Outcomes

After completing this project, learners will be able to:

Identify and manage runtime errors through Java exception handling

Distinguish between checked and unchecked exceptions

Write modular and maintainable Java code

Build real-world applications with strong error-handling logic

▶️ How to Run

Ensure Java 8+ is installed

Save the provided code in a file named:

ResultManagementSystem.java


Compile:

javac ResultManagementSystem.java


Run:

java ResultManagementSystem

📸 Sample Program Interaction

Add Student

View Student Details

Handle Invalid Marks

Exit System

All interactions are text-based through a menu-driven interface.

🛠 Technologies Used

Core Java

OOP Principles

Console I/O (Scanner)

Exception Handling
