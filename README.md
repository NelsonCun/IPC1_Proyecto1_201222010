# Java Hospital Management Desktop Application

Desktop application developed in **Java** as an individual academic project for *Introducción a la Programación y Computación 1* at Universidad de San Carlos de Guatemala (USAC).

The project models hospital-management workflows through a Swing-based graphical interface and demonstrates core Java programming concepts including object-oriented design, inheritance, collections, event-driven interfaces, validation, and role-specific application flows.

## What the application does

The application provides separate workflows for administrators, doctors, and patients.

Key capabilities include:

- authentication and role-specific navigation;
- doctor and patient registration and management;
- product/inventory management;
- doctor availability management;
- appointment scheduling;
- data validation and in-memory collections;
- summary/report-oriented processing for specialties and products;
- graphical desktop interfaces implemented with Java Swing.

## Technical focus

- **Java 21**
- **Java Swing / AWT**
- Object-oriented programming
- Inheritance and encapsulation
- `ArrayList` and collection-based state management
- Event-driven desktop UI
- Input validation
- JCalendar
- JFreeChart
- JTattoo Look & Feel
- Maven
- GitHub Actions

The original coursework was created as a NetBeans/Ant project. A portable Maven build was later added so that the source can be compiled without relying on machine-specific IDE library paths.

## Project structure

```text
.
├── IPC1_Proyecto1_201222010/
│   ├── src/
│   │   └── ipc1_proyecto1_201222010/
│   │       ├── Proyect1.java
│   │       ├── Login.java
│   │       ├── Administrador.java
│   │       ├── Doctor.java
│   │       ├── Paciente.java
│   │       ├── Producto.java
│   │       ├── Cita.java
│   │       └── ...
│   ├── build.xml
│   └── nbproject/
├── pom.xml
└── .github/workflows/java-ci.yml
```

## Build

Requirements:

- JDK 21+
- Maven 3.9+

Compile and package:

```bash
mvn clean package
```

Run from Maven:

```bash
mvn exec:java
```

## Demo administrator

For local demonstration, the application creates an administrator with:

```text
User: admin
Password: admin
```

The password can be overridden without modifying the source:

```bash
IPC1_ADMIN_PASSWORD='your-local-password' mvn exec:java
```

These credentials are intentionally demo-only. The project is an academic desktop application and does **not** implement a production authentication or persistence model.

## CI

GitHub Actions validates that the project can be compiled and packaged with Maven and Java 21 on every pull request and push to `main`.

## Context

This repository is retained as evidence of early Java development experience and fundamental programming work. Its value is in the implementation of desktop workflows, object-oriented modeling, collections, validation, and Java GUI/event handling rather than in modern enterprise-framework usage.

The current portfolio cleanup intentionally preserves the original application logic while improving repository hygiene, reproducibility, and documentation.
