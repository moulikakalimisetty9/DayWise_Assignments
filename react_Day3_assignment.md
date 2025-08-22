#### ===========================casestudy1=======================



ECommerce.js



import { useState, useEffect } from "react";



export default function ECommerce() {

&nbsp; const \[products, setProducts] = useState(\[]);

&nbsp; const \[category, setCategory] = useState("all");

&nbsp; const \[loading, setLoading] = useState(false);



&nbsp; useEffect(() => {

&nbsp;   setLoading(true);

&nbsp;   let url = "https://fakestoreapi.com/products";

&nbsp;   if (category !== "all") {

&nbsp;     url = `https://fakestoreapi.com/products/category/${category}`;

&nbsp;   }

&nbsp;   fetch(url)

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => {

&nbsp;       setProducts(data);

&nbsp;       setLoading(false);

&nbsp;     })

&nbsp;     .catch(() => setLoading(false));

&nbsp; }, \[category]);



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>E-Commerce Product Listing</h2>

&nbsp;     <select onChange={(e) => setCategory(e.target.value)}>

&nbsp;       <option value="all">All</option>

&nbsp;       <option value="electronics">Electronics</option>

&nbsp;       <option value="jewelery">Jewelry</option>

&nbsp;       <option value="men's clothing">Men's Clothing</option>

&nbsp;       <option value="women's clothing">Women's Clothing</option>

&nbsp;     </select>

&nbsp;     {loading ? (

&nbsp;       <p>Loading...</p>

&nbsp;     ) : (

&nbsp;       <div style={{ display: "flex", flexWrap: "wrap" }}>

&nbsp;         {products.map((p) => (

&nbsp;           <div key={p.id} style={{ border: "1px solid gray", margin: 10, padding: 10 }}>

&nbsp;             <img src={p.image} alt={p.title} width="100" />

&nbsp;             <h4>{p.title}</h4>

&nbsp;             <p>₹{p.price}</p>

&nbsp;           </div>

&nbsp;         ))}

&nbsp;       </div>

&nbsp;     )}

&nbsp;   </div>

&nbsp; );

}



#### =============================casestudy2======================================



ProductDetails.js



import { useState, useEffect } from "react";



export default function ProductDetails({ productId = 1 }) {

&nbsp; const \[product, setProduct] = useState(null);

&nbsp; const \[loading, setLoading] = useState(false);



&nbsp; useEffect(() => {

&nbsp;   setLoading(true);

&nbsp;   fetch(`https://fakestoreapi.com/products/${productId}`)

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => {

&nbsp;       setProduct(data);

&nbsp;       setLoading(false);

&nbsp;     });

&nbsp; }, \[productId]);



&nbsp; if (loading) return <p>Loading product...</p>;

&nbsp; if (!product) return <p>No product found</p>;



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>Product Details</h2>

&nbsp;     <img src={product.image} alt={product.title} width="150" />

&nbsp;     <h3>{product.title}</h3>

&nbsp;     <p>Price: ₹{product.price}</p>

&nbsp;     <p>{product.description}</p>

&nbsp;     <p>Rating: {product.rating?.rate} </p>

&nbsp;   </div>

&nbsp; );

}



#### ================================casestudy3================================



UserDashboard.js



import { useState, useEffect } from "react";



export default function UserDashboard() {

&nbsp; const \[users, setUsers] = useState(\[]);

&nbsp; const \[selectedUser, setSelectedUser] = useState(null);



&nbsp; useEffect(() => {

&nbsp;   fetch("https://jsonplaceholder.typicode.com/users")

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => setUsers(data));

&nbsp; }, \[]);



&nbsp; useEffect(() => {

&nbsp;   if (selectedUser) {

&nbsp;     fetch(`https://jsonplaceholder.typicode.com/users/${selectedUser}`)

&nbsp;       .then((res) => res.json())

&nbsp;       .then((data) => setSelectedUser(data));

&nbsp;   }

&nbsp; }, \[selectedUser]);



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>User Management Dashboard</h2>

&nbsp;     <ul>

&nbsp;       {users.map((u) => (

&nbsp;         <li key={u.id} onClick={() => setSelectedUser(u.id)}>

&nbsp;           {u.name} - {u.email}

&nbsp;         </li>

&nbsp;       ))}

&nbsp;     </ul>

&nbsp;     {selectedUser \&\& (

&nbsp;       <div style={{ marginTop: 20 }}>

&nbsp;         <h3>User Profile</h3>

&nbsp;         <p>Name: {selectedUser.name}</p>

&nbsp;         <p>Email: {selectedUser.email}</p>

&nbsp;         <p>Phone: {selectedUser.phone}</p>

&nbsp;       </div>

&nbsp;     )}

&nbsp;   </div>

&nbsp; );

}



#### ==========================casestudy4=============================



PostsWithComments.js



import { useState, useEffect } from "react";



export default function PostsWithComments() {

&nbsp; const \[posts, setPosts] = useState(\[]);

&nbsp; const \[selectedPost, setSelectedPost] = useState(null);

&nbsp; const \[comments, setComments] = useState(\[]);



&nbsp; useEffect(() => {

&nbsp;   fetch("https://jsonplaceholder.typicode.com/posts")

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => setPosts(data.slice(0, 10)));

&nbsp; }, \[]);



&nbsp; useEffect(() => {

&nbsp;   if (selectedPost) {

&nbsp;     fetch(`https://jsonplaceholder.typicode.com/posts/${selectedPost}/comments`)

&nbsp;       .then((res) => res.json())

&nbsp;       .then((data) => setComments(data));

&nbsp;   }

&nbsp; }, \[selectedPost]);



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>Blog Posts</h2>

&nbsp;     <ul>

&nbsp;       {posts.map((p) => (

&nbsp;         <li key={p.id} onClick={() => setSelectedPost(p.id)}>

&nbsp;           {p.title}

&nbsp;         </li>

&nbsp;       ))}

&nbsp;     </ul>

&nbsp;     {selectedPost \&\& (

&nbsp;       <div>

&nbsp;         <h3>Comments</h3>

&nbsp;         {comments.map((c) => (

&nbsp;           <p key={c.id}>

&nbsp;             <strong>{c.email}:</strong> {c.body}

&nbsp;           </p>

&nbsp;         ))}

&nbsp;       </div>

&nbsp;     )}

&nbsp;   </div>

&nbsp; );

}



#### ==========================**casestudy5**===============================

TodoTracker.js



import { useState, useEffect } from "react";



export default function TodoTracker() {

&nbsp; const \[todos, setTodos] = useState(\[]);

&nbsp; const \[filter, setFilter] = useState("all");



&nbsp; useEffect(() => {

&nbsp;   fetch("https://jsonplaceholder.typicode.com/todos?\_limit=20")

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => setTodos(data));

&nbsp; }, \[]);



&nbsp; const filteredTodos =

&nbsp;   filter === "completed"

&nbsp;     ? todos.filter((t) => t.completed)

&nbsp;     : filter === "pending"

&nbsp;     ? todos.filter((t) => !t.completed)

&nbsp;     : todos;



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>Todo Tracker</h2>

&nbsp;     <button onClick={() => setFilter("all")}>All</button>

&nbsp;     <button onClick={() => setFilter("completed")}>Completed</button>

&nbsp;     <button onClick={() => setFilter("pending")}>Pending</button>



&nbsp;     <ul>

&nbsp;       {filteredTodos.map((t) => (

&nbsp;         <li key={t.id}>

&nbsp;           {t.title} {t.completed ? "Yes" : "No"}

&nbsp;         </li>

&nbsp;       ))}

&nbsp;     </ul>



&nbsp;     <p>

&nbsp;       Completed: {todos.filter((t) => t.completed).length} / {todos.length}

&nbsp;     </p>

&nbsp;   </div>

&nbsp; );

}



==================App.js===============



import ECommerce from "./components/ECommerce";

import ProductDetails from "./components/ProductDetails";

import UserDashboard from "./components/UserDashboard";

import PostsWithComments from "./components/PostsWithComments";

import TodoTracker from "./components/TodoTracker";



function App() {

&nbsp; return (

&nbsp;   <div>

&nbsp;     {/\* Uncomment the one you want to test \*/}

&nbsp;     <ECommerce />

&nbsp;     {/\* <ProductDetails productId={2} /> \*/}

&nbsp;     {/\* <UserDashboard /> \*/}

&nbsp;     {/\* <PostsWithComments /> \*/}

&nbsp;      <TodoTracker /> 

&nbsp;   </div>

&nbsp; );

}



export default App;



