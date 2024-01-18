# IspitiServis

## Overview
This web application is built using Java and Spring Boot, with HTML and Thymeleaf for the front end. It serves as a student service for exam organization, allowing users to perform CRUD operations on Students, Professors, Subjects, Exams, etc.

## Getting Started
1. 	Clone the repository:
	```bash
	git clone https://github.com/DaliborJankovic/IspitiServis
2.	Open the project in IntelliJ IDEA.
3.	Configure the MySQL database by updating the following properties in 
	'application.properties':
	
	spring.datasource.url=jdbc:mysql://localhost:3306/ispiti_aplikacija?createDatabaseIfNotExist=true
	spring.datasource.username=springstudent
	spring.datasource.password=springstudent
	
4.	Set the security properties:

	spring.security.user.name=Dalibor
	spring.security.user.password=1234
	
5.	Build and run the application.

6.	Access the home page at http://localhost:8080/home.

**Features**

**CRUD Operations:**
- Students
- Professors
- Subjects
- Exams
- Exam Periods
- Exam Registrations

**Paging:**
Student page supports paging with the ability to set the number of entities per page in ascending or descending order.

**Confirmation for Deletion:**
Users are prompted to confirm their intention when deleting an entity.

**Exam Period Restrictions:**
Only one active Exam Period is allowed.
Exam Periods cannot overlap.
...

**Exam Constraints:**
Exams can only be defined if there is no identical exam already.
The date of the exam must fall within the specified Exam Period.
...

**Exam Registration Limitation:**
Exam registration is only possible in the last week before the Exam Period starts.

**Security:**
Roles and authorities are yet to be implemented.

**Notes**
Ensure that the necessary dependencies are resolved and the database is properly configured before running the application.