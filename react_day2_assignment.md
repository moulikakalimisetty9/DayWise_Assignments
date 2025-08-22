#### **========casestudy1 ================**



**FoodOrder.js**



import { useState } from "react";



function FoodCard({ food, addToCart }) {

&nbsp; return (

&nbsp;   <div className="border p-3 m-2 rounded">

&nbsp;     <h3>{food.name}</h3>

&nbsp;     <p>Price: ₹{food.price}</p>

&nbsp;     <button onClick={() => addToCart(food)}>Add to Cart</button>

&nbsp;   </div>

&nbsp; );

}



export default function FoodOrder() {

&nbsp; const menu = \[

&nbsp;   { id: 1, name: "Pizza", price: 200 },

&nbsp;   { id: 2, name: "Burger", price: 100 },

&nbsp;   { id: 3, name: "Pasta", price: 150 },

&nbsp; ];



&nbsp; const \[cart, setCart] = useState(\[]);

&nbsp; const \[total, setTotal] = useState(0);



&nbsp; const addToCart = (food) => {

&nbsp;   setCart(\[...cart, food]);

&nbsp;   setTotal(total + food.price);

&nbsp; };



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>🍕 Online Food Ordering</h2>

&nbsp;     <div style={{ display: "flex" }}>

&nbsp;       {menu.map((food) => (

&nbsp;         <FoodCard key={food.id} food={food} addToCart={addToCart} />

&nbsp;       ))}

&nbsp;     </div>

&nbsp;     <h3>Cart Items: {cart.length}</h3>

&nbsp;     <h3>Total Bill: ₹{total}</h3>

&nbsp;   </div>

&nbsp; );

}



#### =============**casestudy2**==================



**E\_Learning.js**



import { useState } from "react";



function CourseCard({ course, enroll }) {

&nbsp; return (

&nbsp;   <div className="border p-3 m-2">

&nbsp;     <h3>{course.title}</h3>

&nbsp;     <p>By {course.author}</p>

&nbsp;     <p>Duration: {course.duration}</p>

&nbsp;     <button onClick={() => enroll(course)}>

&nbsp;       {course.enrolled ? "Already Enrolled" : "Enroll"}

&nbsp;     </button>

&nbsp;   </div>

&nbsp; );

}



export default function E\_Learning() {

&nbsp; const \[courses, setCourses] = useState(\[

&nbsp;   { id: 1, title: "React Basics", author: "John", duration: "5h", enrolled: false },

&nbsp;   { id: 2, title: "Node.js Intro", author: "Sarah", duration: "3h", enrolled: false },

&nbsp; ]);



&nbsp; const enroll = (course) => {

&nbsp;   setCourses(

&nbsp;     courses.map((c) =>

&nbsp;       c.id === course.id ? { ...c, enrolled: true } : c

&nbsp;     )

&nbsp;   );

&nbsp; };



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>📚 E-Learning Platform</h2>

&nbsp;     {courses.map((course) => (

&nbsp;       <CourseCard key={course.id} course={course} enroll={enroll} />

&nbsp;     ))}

&nbsp;   </div>

&nbsp; );

}



#### ==============**casestudy3**=================

**MovieBooking.js**



import { useState } from "react";



function SeatSelector({ seat, toggleSeat }) {

&nbsp; return (

&nbsp;   <button

&nbsp;     style={{

&nbsp;       margin: "5px",

&nbsp;       backgroundColor: seat.selected ? "green" : "lightgray",

&nbsp;     }}

&nbsp;     onClick={() => toggleSeat(seat.id)}

&nbsp;   >

&nbsp;     {seat.id}

&nbsp;   </button>

&nbsp; );

}



export default function MovieBooking() {

&nbsp; const \[seats, setSeats] = useState(\[

&nbsp;   { id: 1, selected: false },

&nbsp;   { id: 2, selected: false },

&nbsp;   { id: 3, selected: false },

&nbsp; ]);

&nbsp; const pricePerSeat = 150;



&nbsp; const toggleSeat = (id) => {

&nbsp;   setSeats(

&nbsp;     seats.map((s) =>

&nbsp;       s.id === id ? { ...s, selected: !s.selected } : s

&nbsp;     )

&nbsp;   );

&nbsp; };



&nbsp; const selectedSeats = seats.filter((s) => s.selected);



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>🎬 Movie Ticket Booking</h2>

&nbsp;     {seats.map((s) => (

&nbsp;       <SeatSelector key={s.id} seat={s} toggleSeat={toggleSeat} />

&nbsp;     ))}

&nbsp;     <h3>Selected Seats: {selectedSeats.map((s) => s.id).join(", ")}</h3>

&nbsp;     <h3>Total Cost: ₹{selectedSeats.length \* pricePerSeat}</h3>

&nbsp;   </div>

&nbsp; );

}



#### =======================**casestudy4**=============

**FitnessTracker.js**



import { useState } from "react";



function StepsTracker({ steps, updateSteps }) {

&nbsp; return (

&nbsp;   <div>

&nbsp;     <h3>Steps: {steps}</h3>

&nbsp;     <button onClick={() => updateSteps(steps + 100)}>+100 Steps</button>

&nbsp;   </div>

&nbsp; );

}



function CaloriesTracker({ calories, updateCalories }) {

&nbsp; return (

&nbsp;   <div>

&nbsp;     <h3>Calories Burned: {calories}</h3>

&nbsp;     <button onClick={() => updateCalories(calories + 50)}>+50 Calories</button>

&nbsp;   </div>

&nbsp; );

}



function WaterTracker({ water, updateWater }) {

&nbsp; return (

&nbsp;   <div>

&nbsp;     <h3>Water Intake: {water} glasses</h3>

&nbsp;     <button onClick={() => updateWater(water + 1)}>+1 Glass</button>

&nbsp;   </div>

&nbsp; );

}



export default function FitnessTracker() {

&nbsp; const \[steps, setSteps] = useState(0);

&nbsp; const \[calories, setCalories] = useState(0);

&nbsp; const \[water, setWater] = useState(0);



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>🏋️ Fitness Dashboard</h2>

&nbsp;     <StepsTracker steps={steps} updateSteps={setSteps} />

&nbsp;     <CaloriesTracker calories={calories} updateCalories={setCalories} />

&nbsp;     <WaterTracker water={water} updateWater={setWater} />

&nbsp;     <h3>Total Summary: {steps} steps, {calories} cal, {water} glasses</h3>

&nbsp;   </div>

&nbsp; );

}



#### =====================**casestudy5**================

**HotelReservation.js**



import { useState } from "react";



function RoomCard({ room, selectRoom }) {

&nbsp; return (

&nbsp;   <div className="border p-3 m-2">

&nbsp;     <h3>{room.type}</h3>

&nbsp;     <p>₹{room.price}/night</p>

&nbsp;     <button onClick={() => selectRoom(room)}>Select</button>

&nbsp;   </div>

&nbsp; );

}



export default function HotelReservation() {

&nbsp; const rooms = \[

&nbsp;   { id: 1, type: "Single Room", price: 1000 },

&nbsp;   { id: 2, type: "Double Room", price: 1800 },

&nbsp; ];



&nbsp; const \[selectedRoom, setSelectedRoom] = useState(null);

&nbsp; const \[days, setDays] = useState(1);



&nbsp; const total = selectedRoom ? selectedRoom.price \* days : 0;



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>🏨 Hotel Room Reservation</h2>

&nbsp;     {rooms.map((r) => (

&nbsp;       <RoomCard key={r.id} room={r} selectRoom={setSelectedRoom} />

&nbsp;     ))}

&nbsp;     {selectedRoom \&\& (

&nbsp;       <div>

&nbsp;         <h3>Selected: {selectedRoom.type}</h3>

&nbsp;         <label>Days: </label>

&nbsp;         <input

&nbsp;           type="number"

&nbsp;           value={days}

&nbsp;           onChange={(e) => setDays(Number(e.target.value))}

&nbsp;         />

&nbsp;         <h3>Total Price: ₹{total}</h3>

&nbsp;       </div>

&nbsp;     )}

&nbsp;   </div>

&nbsp; );

}



===============**App.js**=================



import FoodOrder from "./components/FoodOrder";

import E\_Learning from "./components/E\_Learning";

import MovieBooking from "./components/MovieBooking";

import FitnessTracker from "./components/FitnessTracker";

import HotelReservation from "./components/HotelReservation";



function App() {

&nbsp; return (

&nbsp;   <div>

&nbsp;     {/\* Uncomment which one you want to test \*/}

&nbsp;     <FoodOrder />

&nbsp;     {/\* <E\_Learning /> \*/}

&nbsp;     {/\* <MovieBooking /> \*/}

&nbsp;     {/\* <FitnessTracker /> \*/}

&nbsp;      <HotelReservation /> 

&nbsp;   </div>

&nbsp; );

}



export default App;



