#### ============= Case Study 1: Simple Bookstore API (MongoDB + Node.js) ================



#### bookstore.js



const mongoose = require("mongoose");



// Step 2: Connect to MongoDB

mongoose.connect("mongodb://localhost:27017/bookstore", {

&nbsp; useNewUrlParser: true,

&nbsp; useUnifiedTopology: true

}).then(() => console.log("MongoDB connected"))

&nbsp; .catch(err => console.error(err));



// Step 3: Define Schema and Model

const bookSchema = new mongoose.Schema({

&nbsp; title: String,

&nbsp; author: String,

&nbsp; price: Number

}, { timestamps: true });



const Book = mongoose.model("Book", bookSchema);



// Step 4: Insert a Book

async function addBook(title, author, price) {

&nbsp; const book = new Book({ title, author, price });

&nbsp; await book.save();

&nbsp; console.log("Book Added:", book);

}



// Step 5: Fetch All Books

async function getAllBooks() {

&nbsp; const books = await Book.find();

&nbsp; console.log("All Books:", books);

}



// Step 6: Find a Book by Title

async function findBookByTitle(title) {

&nbsp; const book = await Book.findOne({ title });

&nbsp; console.log("Found Book:", book);

}



// Step 7: Update Book Price

async function updateBookPrice(title, newPrice) {

&nbsp; const book = await Book.findOneAndUpdate(

&nbsp;   { title },

&nbsp;   { price: newPrice },

&nbsp;   { new: true }

&nbsp; );

&nbsp; console.log("Updated Book:", book);

}



// Example Usage

(async () => {

&nbsp; await addBook("Node.js Guide", "John Doe", 450);

&nbsp; await addBook("MongoDB Basics", "Jane Smith", 300);

&nbsp; await getAllBooks();

&nbsp; await findBookByTitle("Node.js Guide");

&nbsp; await updateBookPrice("Node.js Guide", 500);

})();





#### ======= Case Study 2: Employee Management System (MySQL + Node.js) ===============



#### employee.js



const mysql = require("mysql2");



// Step 3: Connect to MySQL

const db = mysql.createConnection({

&nbsp; host: "localhost",

&nbsp; user: "root",       // change if you have different user

&nbsp; password: "password", // replace with your MySQL password

&nbsp; database: "employeeDB"

});



db.connect(err => {

&nbsp; if (err) throw err;

&nbsp; console.log("MySQL connected");

});



// Step 4: Insert Employee

function addEmployee(name, email, department) {

&nbsp; const sql = "INSERT INTO employees (name, email, department) VALUES (?, ?, ?)";

&nbsp; db.query(sql, \[name, email, department], (err, result) => {

&nbsp;   if (err) throw err;

&nbsp;   console.log("Employee Added:", result.insertId);

&nbsp; });

}



// Step 5: Fetch All Employees

function getAllEmployees() {

&nbsp; db.query("SELECT \* FROM employees", (err, results) => {

&nbsp;   if (err) throw err;

&nbsp;   console.log("Employees:", results);

&nbsp; });

}



// Step 6: Update Employee Info

function updateEmployee(id, name, department) {

&nbsp; const sql = "UPDATE employees SET name=?, department=? WHERE id=?";

&nbsp; db.query(sql, \[name, department, id], (err, result) => {

&nbsp;   if (err) throw err;

&nbsp;   console.log("Employee Updated:", result.message);

&nbsp; });

}



// Step 7: Delete Employee

function deleteEmployee(id) {

&nbsp; db.query("DELETE FROM employees WHERE id=?", \[id], (err, result) => {

&nbsp;   if (err) throw err;

&nbsp;   console.log("Employee Deleted:", result.message);

&nbsp; });

}



// Example Usage

addEmployee("Alice", "alice@example.com", "HR");

addEmployee("Bob", "bob@example.com", "IT");



setTimeout(() => {

&nbsp; getAllEmployees();

&nbsp; updateEmployee(1, "Alice Johnson", "Finance");

&nbsp; deleteEmployee(2);

&nbsp; getAllEmployees();

&nbsp; 

&nbsp; // Step 8: Close Connection

&nbsp; db.end();

}, 1000);



