# 📦 Inventory Management System (Java + MySQL)

## 📌 Description
A simple **console-based Inventory Management System** built using **Java** and **MySQL (JDBC)**.  
This project demonstrates database connectivity, CRUD operations, and clean project structuring in Java.  

---

## 🚀 Features
- Add new products  
- View all products in inventory  
- Update product details (quantity, price, etc.)  
- Delete products  
- Persistent storage using **MySQL database**  

---

## 🛠️ Tech Stack
- **Java** (Core + JDBC)  
- **MySQL** (Relational Database)  
- **Eclipse IDE**  
- **Git/GitHub** for version control  

---

## 📂 Project Structure
src/main/java/com/inventory/
│── app/
│ └── MainApp.java # Main program (menu-driven)
│── dao/
│ └── ProductDAO.java # Data Access Object for DB operations
│── db/
│ └── DBConnection.java # MySQL JDBC connection
│── model/
│ └── Product.java # Product model class

---

## ▶️ How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/Kruthika0705/Inventory_Management.git
2.Import into Eclipse or run from terminal:
javac -d bin src/main/java/com/inventory/**/*.java
java -cp bin com.inventory.app.MainApp
3.Setup MySQL Database:
CREATE DATABASE inventory_db;
USE inventory_db;

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DECIMAL(10,2)
);
4.Update DB credentials in DBConnection.java if required.
