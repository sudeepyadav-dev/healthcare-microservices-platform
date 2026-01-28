# Healthcare Microservices Platform

A Spring Boot–based Healthcare Microservices Platform built using a real-world microservices architecture.  
This project demonstrates secure authentication, scalable service design, and backend development best practices.

---

## 1. Project Overview

The Healthcare Microservices Platform is designed to manage healthcare-related operations such as authentication, appointment booking, payments, and notifications.  
Each functionality is implemented as an independent microservice to ensure scalability, maintainability, and loose coupling.

---

## 2. Architecture Overview

- Microservices-based architecture
- Centralized Authentication Service
- Stateless JWT-based security
- Independent deployment of each microservice
- RESTful APIs for inter-service communication

---

## 3. Project Structure

```text
healthcare-microservices-platform
│
├── auth-service
│   └── Authentication & JWT token generation
│
├── appointment-service
│   └── Doctor availability and appointment management
│
├── booking-service
│   └── Appointment booking workflow
│
├── doctor-service
│   └── Doctor profile and schedule management
│
├── patient-service
│   └── Patient information management
│
├── payment-service
│   └── Payment processing
│
├── notification-service
│   └── Email/SMS notifications
│
└── README.md

# Microservices Description

1.Auth Service:-
Handles user authentication and generates JWT tokens.

2.Appointment Service:-
Manages doctor availability and appointment slots.

3.Booking Service:-
Handles appointment booking logic and validation.

4.Doctor Service:-
Manages doctor profiles and schedules.

5.Patient Service:-
Manages patient-related data.

6.Payment Service:-
Handles payment transactions for bookings.

7.Notification Service:-
Sends notifications (email/SMS) to users

## Tech Stack
- Java
- Spring Boot
- Spring Security (JWT)
- REST APIs
- MySQL
- Maven

## Architecture
- Microservices-based architecture
- Central Auth Service
- JWT-based stateless security

## How to Run
1. Clone the repository
2. Configure database in `application.properties`
3. Run each microservice independently

## Security
- JWT-based authentication
- Role-based authorization
