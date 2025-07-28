#### **Case Study 1: Online Course Registration System**

Objective:

Allow students to register/unregister for courses and view course details.

Table Structure:

CREATE DATABASE course\_db;

USE course\_db;

CREATE TABLE courses (

&nbsp;course\_id INT PRIMARY KEY,

&nbsp;course\_name VARCHAR(100),

&nbsp;faculty VARCHAR(100),

&nbsp;credits INT

);



JDBC Operations:

• INSERT: Add new courses.

• SELECT: List available courses.

• UPDATE: Modify faculty or credit values.

• DELETE: Remove obsolete courses.



#### **CourseJDBC.java**



import java.sql.\*;

import java.util.Scanner;



public class CourseJDBC {

&nbsp;   static final String URL = "jdbc:mysql://localhost:3306/course\_db";

&nbsp;   static final String USER = "root";

&nbsp;   static final String PASS = "your\_password";



&nbsp;   public static void main(String\[] args) {

&nbsp;       try (Connection conn = DriverManager.getConnection(URL, USER, PASS);

&nbsp;            Scanner sc = new Scanner(System.in)) {



&nbsp;           while (true) {

&nbsp;               System.out.println("\\n1. Add Course\\n2. View Courses\\n3. Update Course\\n4. Delete Course\\n5. Exit");

&nbsp;               int choice = sc.nextInt();



&nbsp;               switch (choice) {

&nbsp;                   case 1 -> {

&nbsp;                       System.out.print("Course ID: "); int id = sc.nextInt(); sc.nextLine();

&nbsp;                       System.out.print("Course Name: "); String name = sc.nextLine();

&nbsp;                       System.out.print("Faculty: "); String faculty = sc.nextLine();

&nbsp;                       System.out.print("Credits: "); int credits = sc.nextInt();



&nbsp;                       String insert = "INSERT INTO courses VALUES (?, ?, ?, ?)";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(insert)) {

&nbsp;                           ps.setInt(1, id);

&nbsp;                           ps.setString(2, name);

&nbsp;                           ps.setString(3, faculty);

&nbsp;                           ps.setInt(4, credits);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Course added.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 2 -> {

&nbsp;                       String query = "SELECT \* FROM courses";

&nbsp;                       try (Statement stmt = conn.createStatement();

&nbsp;                            ResultSet rs = stmt.executeQuery(query)) {

&nbsp;                           while (rs.next()) {

&nbsp;                               System.out.println(rs.getInt(1) + " | " +

&nbsp;                                       rs.getString(2) + " | " +

&nbsp;                                       rs.getString(3) + " | " +

&nbsp;                                       rs.getInt(4));

&nbsp;                           }

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 3 -> {

&nbsp;                       System.out.print("Course ID to update: "); int id = sc.nextInt(); sc.nextLine();

&nbsp;                       System.out.print("New Faculty: "); String faculty = sc.nextLine();

&nbsp;                       System.out.print("New Credits: "); int credits = sc.nextInt();



&nbsp;                       String update = "UPDATE courses SET faculty = ?, credits = ? WHERE course\_id = ?";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(update)) {

&nbsp;                           ps.setString(1, faculty);

&nbsp;                           ps.setInt(2, credits);

&nbsp;                           ps.setInt(3, id);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Course updated.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 4 -> {

&nbsp;                       System.out.print("Course ID to delete: "); int id = sc.nextInt();

&nbsp;                       String delete = "DELETE FROM courses WHERE course\_id = ?";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(delete)) {

&nbsp;                           ps.setInt(1, id);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Course deleted.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 5 -> System.exit(0);



&nbsp;                   default -> System.out.println("Invalid choice.");

&nbsp;               }

&nbsp;           }



&nbsp;       } catch (Exception e) {

&nbsp;           e.printStackTrace();

&nbsp;       }

&nbsp;   }

}





#### **Case Study 2: Product Inventory System**

Objective:

Track product stock in a retail store.

Table Structure:C

CREATE DATABASE inventory\_db;

USE inventory\_db;

CREATE TABLE products (

&nbsp;product\_id INT PRIMARY KEY,

&nbsp;product\_name VARCHAR(100),

&nbsp;quantity INT,

&nbsp;price DECIMAL(10,2)

);



JDBC Operations:

• INSERT: Add new products to inventory.

• SELECT: View stock levels and prices.

• UPDATE: Update quantity after sale/purchase.

• DELETE: Remove discontinued products.



#### **ProductJDBC.java**



import java.sql.\*;

import java.util.Scanner;



public class ProductJDBC {

&nbsp;   static final String URL = "jdbc:mysql://localhost:3306/inventory\_db";

&nbsp;   static final String USER = "root";

&nbsp;   static final String PASS = "your\_password";



&nbsp;   public static void main(String\[] args) {

&nbsp;       try (Connection conn = DriverManager.getConnection(URL, USER, PASS);

&nbsp;            Scanner sc = new Scanner(System.in)) {



&nbsp;           while (true) {

&nbsp;               System.out.println("\\n1. Add Product\\n2. View Products\\n3. Update Quantity\\n4. Delete Product\\n5. Exit");

&nbsp;               int choice = sc.nextInt();



&nbsp;               switch (choice) {

&nbsp;                   case 1 -> {

&nbsp;                       System.out.print("Product ID: "); int id = sc.nextInt(); sc.nextLine();

&nbsp;                       System.out.print("Product Name: "); String name = sc.nextLine();

&nbsp;                       System.out.print("Quantity: "); int qty = sc.nextInt();

&nbsp;                       System.out.print("Price: "); double price = sc.nextDouble();



&nbsp;                       String insert = "INSERT INTO products VALUES (?, ?, ?, ?)";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(insert)) {

&nbsp;                           ps.setInt(1, id);

&nbsp;                           ps.setString(2, name);

&nbsp;                           ps.setInt(3, qty);

&nbsp;                           ps.setDouble(4, price);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Product added.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 2 -> {

&nbsp;                       String query = "SELECT \* FROM products";

&nbsp;                       try (Statement stmt = conn.createStatement();

&nbsp;                            ResultSet rs = stmt.executeQuery(query)) {

&nbsp;                           while (rs.next()) {

&nbsp;                               System.out.println(rs.getInt(1) + " | " +

&nbsp;                                       rs.getString(2) + " | " +

&nbsp;                                       rs.getInt(3) + " | ₹" +

&nbsp;                                       rs.getDouble(4));

&nbsp;                           }

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 3 -> {

&nbsp;                       System.out.print("Product ID to update: "); int id = sc.nextInt();

&nbsp;                       System.out.print("New Quantity: "); int qty = sc.nextInt();



&nbsp;                       String update = "UPDATE products SET quantity = ? WHERE product\_id = ?";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(update)) {

&nbsp;                           ps.setInt(1, qty);

&nbsp;                           ps.setInt(2, id);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Quantity updated.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 4 -> {

&nbsp;                       System.out.print("Product ID to delete: "); int id = sc.nextInt();

&nbsp;                       String delete = "DELETE FROM products WHERE product\_id = ?";

&nbsp;                       try (PreparedStatement ps = conn.prepareStatement(delete)) {

&nbsp;                           ps.setInt(1, id);

&nbsp;                           ps.executeUpdate();

&nbsp;                           System.out.println("Product deleted.");

&nbsp;                       }

&nbsp;                   }



&nbsp;                   case 5 -> System.exit(0);



&nbsp;                   default -> System.out.println("Invalid choice.");

&nbsp;               }

&nbsp;           }



&nbsp;       } catch (Exception e) {

&nbsp;           e.printStackTrace();

&nbsp;       }

&nbsp;   }

}





