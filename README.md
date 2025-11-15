# 🏥 Hospital Management System (HMS)

A simple and beginner-friendly **Spring Boot CRUD Application** designed to manage basic hospital operations such as **Patients, Doctors, Appointments, and Billing**.  
This project demonstrates clean backend architecture using **Spring Boot, REST API, JPA, and Hibernate**.

---

## 🚀 Features

### ✅ Patient Module
- Add new patient  
- Update patient details  
- Fetch single patient  
- Fetch all patients  
- Delete patient

### ✅ Doctor Module
- Add new doctor  
- Update doctor info  
- View doctor list  
- Delete doctor

### ✅ Appointment Module
- Book an appointment  
- Update appointment  
- View appointment list  
- Delete appointment

### ✅ Billing Module
- Generate bill  
- View bill  
- Delete bill

---

## 🧱 Project Architecture

The project follows a **layered architecture**:


### **Controller Layer**
Exposes REST endpoints (CRUD APIs).

### **Service Layer**
Contains business logic and validation.

### **Repository Layer**
JPA repository for DB interactions.

### **Entity Layer**
Represents database tables.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / H2 Database**
- **Maven**

---

## 📌 API Endpoints (Examples)

### Patient APIs
| Method |         Endpoint         |     Description     |
|--------|--------------------------|
| POST   | `/api/v1/patient/add`    |     Add patient     |
| GET    | `/api/v1/patient/{id}`   |   Get patient by ID |
| GET    | `/api/v1/patient/all`    |   Get all patients  |
| PUT    | `/api/v1/patient/update` |   Update patient    |
| DELETE | `/api/v1/patient/{id}`   |   Delete patient    |

(Similar structure for Doctors, Appointments, and Bills)

---

👨‍💻 Author

Akshay
IT Student | Java Developer | Android Developer
