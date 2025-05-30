# NEOL Restaurant Management System

The **NEOL Restaurant Management System** is a Java Swing-based ERP desktop application designed to automate and streamline restaurant operations. this application supports various modules including Order Management, HR, Payroll, Inventory, Finance, and Kitchen Management, all backed by a centralized MySQL database.

---

## 📌 Project Overview

The NEOL system enables restaurant staff to manage the entire workflow—from customer orders to food preparation, employee management, and payment processing—through an intuitive and role-specific interface.

---

## 🖥️ Technologies Used

- **Language**: Java (JDK 22+)
- **GUI Framework**: Java Swing
- **Database**: MySQL 8.0+
- **IDE**: Apache NetBeans
- **Reporting Libraries**: JasperReports, iText
- **Design Pattern**: MVC

---

## 🔑 Key Features

### ✅ Functional Modules

- **Authentication & Access Control**: Role-based access for Admin, HR, Kitchen, Inventory, Finance, and Employees
- **Order Management**: Customer orders, dining sessions, food menus
- **Inventory Management**: GRN processing, product tracking, supplier data
- **HR & Payroll**: Employee management, attendance, leave, position, department setup
- **Finance**: Salary processing, payroll reports, expense reports
- **KPI Reports**: Analytical insights on employee productivity, GRN accuracy, expense variance, and more

---

## 📂 GUI Screens

- **Login & Role Dashboards**: Secure sign-in and dashboard redirection
- **Dining & Menu Interfaces**: Live order placement, potion selection, payment integration
- **Admin Dashboard**: Graphs for revenue, employee count, and operational summaries
- **HR Panel**: Add/manage employees, attendance, departments, payroll
- **Finance Panel**: Add/view payrolls, track expenses, manage salary advances
- **Kitchen & Inventory Panels**: Real-time food prep tracking, stock visualization

---

## 📊 Reports & KPIs

Each department includes KPI tracking features:

- **Employee Productivity**
- **Goods Receiving Accuracy**
- **Expense Variance**
- **Attendance Rate**
- **Payroll Accuracy**
- **Departmental Utilization**

(See `KPI Report.pdf` for detailed breakdowns.)

---

## ⚙️ System Requirements

| Component       | Minimum Requirement                |
|----------------|-------------------------------------|
| OS             | Windows 10 / Ubuntu 20.04+         |
| RAM            | 4GB (8GB recommended)              |
| Java Version   | JDK 22 or higher                   |
| Database       | MySQL Server 8.0+                  |
| Storage        | 1GB free space                     |

---

## 📦 Installation Guide

1. **Install** JDK 22 and NetBeans IDE.
2. **Import** the project into NetBeans.
3. **Setup** MySQL Server 8.0+ and run the provided schema (see `DB Scripts` folder).
4. **Configure** JDBC connection in `DatabaseConnection.java`.
5. **Run** the application from `Main.java`.

---
