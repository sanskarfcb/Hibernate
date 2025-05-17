# Hibernate Learning Project 📘

A hands-on Java project demonstrating core Hibernate features using PostgreSQL and IntelliJ IDEA. This repository contains clean implementations of CRUD operations, HQL queries, Criteria API, pagination, and configuration using `hibernate.cfg.xml`.

---

## 🚀 Technologies Used

- **Java** (JDK 17 or later)
- **Hibernate ORM**
- **PostgreSQL** (Database)
- **IntelliJ IDEA** (IDE)
- **Maven** (for dependency management)
- **Spring Boot** (only used for running the main class)

---

## 🧠 Concepts Covered

✅ Hibernate Setup  
✅ `hibernate.cfg.xml` Configuration  
✅ Session & SessionFactory  
✅ CRUD Operations (Create, Read, Update, Delete)  
✅ HQL (Hibernate Query Language)  
✅ Criteria API  
✅ Pagination using `setFirstResult()` and `setMaxResults()`  
✅ Singleton Pattern for HibernateUtil  

---

## 🗃️ Database Configuration

This project uses a local PostgreSQL database.  
Update your credentials in `hibernate.cfg.xml`:

```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/Hibernate</property>
<property name="hibernate.connection.username">your_username</property>
<property name="hibernate.connection.password">your_password</property>
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
