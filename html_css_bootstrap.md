#### ============================= **Supermarket E-commerce Website** ====================



<!DOCTYPE html>

<html lang="en">

<head>

&nbsp; <meta charset="UTF-8">

&nbsp; <meta name="viewport" content="width=device-width, initial-scale=1.0">

&nbsp; <title>Supermarket - One Page</title>

&nbsp; <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

&nbsp; <style>

&nbsp;   body { font-family: Arial, sans-serif; scroll-behavior: smooth; }

&nbsp;   .navbar-brand img { height: 40px; }

&nbsp;   .carousel-inner img { height: 400px; object-fit: cover; }

&nbsp;   .card img { height: 200px; object-fit: cover; }

&nbsp;   footer { background:#343a40; color:white; padding:20px 0; margin-top:40px; }

&nbsp;   footer a { color:#ffc107; text-decoration:none; }

&nbsp;   section { padding-top:80px; }

&nbsp; </style>

</head>

<body>



<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

&nbsp; <div class="container">

&nbsp;   <a class="navbar-brand" href="#home"><img src="images/logo.png" alt="Logo"> Supermarket</a>

&nbsp;   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#nav"><span class="navbar-toggler-icon"></span></button>

&nbsp;   <div id="nav" class="collapse navbar-collapse">

&nbsp;     <ul class="navbar-nav ms-auto">

&nbsp;       <li class="nav-item"><a class="nav-link" href="#home">Home</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="#products1">Products</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="#register">Register</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="#login">Login</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>

&nbsp;     </ul>

&nbsp;   </div>

&nbsp; </div>

</nav>



<!-- Home -->

<section id="home">

<div id="hero" class="carousel slide" data-bs-ride="carousel">

&nbsp; <div class="carousel-inner">

&nbsp;   <div class="carousel-item active"><img src="images/banner1.jpg" class="d-block w-100"></div>

&nbsp;   <div class="carousel-item"><img src="images/banner2.jpg" class="d-block w-100"></div>

&nbsp;   <div class="carousel-item"><img src="images/banner3.jpg" class="d-block w-100"></div>

&nbsp; </div>

</div>

<div class="container py-5">

&nbsp; <h2>Featured Products</h2>

&nbsp; <div class="row g-4">

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product1.jpg" class="card-img-top"><div class="card-body"><h5>Fresh Apples</h5><p>$2.99/kg</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product2.jpg" class="card-img-top"><div class="card-body"><h5>Whole Wheat Bread</h5><p>$1.49</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product3.jpg" class="card-img-top"><div class="card-body"><h5>Organic Milk</h5><p>$0.99</p></div></div></div>

&nbsp; </div>

</div>

</section>



<!-- Products Page 1 -->

<section id="products1" class="bg-light">

<div class="container py-5">

&nbsp; <h2>Groceries</h2>

&nbsp; <div class="row g-4">

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product1.jpg" class="card-img-top"><div class="card-body"><h5>Fresh Apples</h5><p>$2.99/kg</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product2.jpg" class="card-img-top"><div class="card-body"><h5>Whole Wheat Bread</h5><p>$1.49</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product3.jpg" class="card-img-top"><div class="card-body"><h5>Organic Milk</h5><p>$0.99</p></div></div></div>

&nbsp; </div>

</div>

</section>



<!-- Products Page 2 -->

<section id="products2">

<div class="container py-5">

&nbsp; <h2>Snacks \& Beverages</h2>

&nbsp; <div class="row g-4">

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product4.jpg" class="card-img-top"><div class="card-body"><h5>Potato Chips</h5><p>$1.29</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product5.jpg" class="card-img-top"><div class="card-body"><h5>Orange Juice</h5><p>$2.49</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product6.jpg" class="card-img-top"><div class="card-body"><h5>Chocolate Cookies</h5><p>$1.99</p></div></div></div>

&nbsp; </div>

</div>

</section>



<!-- Products Page 3 -->

<section id="products3" class="bg-light">

<div class="container py-5">

&nbsp; <h2>Household \& Personal Care</h2>

&nbsp; <div class="row g-4">

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product7.jpg" class="card-img-top"><div class="card-body"><h5>Laundry Detergent</h5><p>$3.99</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product8.jpg" class="card-img-top"><div class="card-body"><h5>Herbal Shampoo</h5><p>$2.49</p></div></div></div>

&nbsp;   <div class="col-md-4"><div class="card"><img src="images/product9.jpg" class="card-img-top"><div class="card-body"><h5>Surface Cleaner</h5><p>$1.79</p></div></div></div>

&nbsp; </div>

</div>

</section>



<!-- Register -->

<section id="register">

<div class="container py-5">

&nbsp; <h2>Register</h2>

&nbsp; <form>

&nbsp;   <div class="row g-3">

&nbsp;     <div class="col-md-6"><input type="text" class="form-control" placeholder="Full Name" required></div>

&nbsp;     <div class="col-md-6"><input type="email" class="form-control" placeholder="Email" required></div>

&nbsp;     <div class="col-md-6"><input type="password" class="form-control" placeholder="Password" required></div>

&nbsp;     <div class="col-md-6"><input type="password" class="form-control" placeholder="Confirm Password" required></div>

&nbsp;     <div class="col-12"><textarea class="form-control" placeholder="Address" rows="3" required></textarea></div>

&nbsp;     <div class="col-12"><button class="btn btn-primary">Register</button></div>

&nbsp;   </div>

&nbsp; </form>

</div>

</section>



<!-- Login -->

<section id="login" class="bg-light">

<div class="container py-5" style="max-width:500px;">

&nbsp; <h2>Login</h2>

&nbsp; <form>

&nbsp;   <input type="email" class="form-control mb-3" placeholder="Email" required>

&nbsp;   <input type="password" class="form-control mb-3" placeholder="Password" required>

&nbsp;   <button class="btn btn-primary w-100">Login</button>

&nbsp; </form>

</div>

</section>



<!-- Contact -->

<section id="contact">

<div class="container py-5">

&nbsp; <h2>Contact Us</h2>

&nbsp; <div class="row g-4">

&nbsp;   <div class="col-md-6">

&nbsp;     <form>

&nbsp;       <input type="text" class="form-control mb-3" placeholder="Name" required>

&nbsp;       <input type="email" class="form-control mb-3" placeholder="Email" required>

&nbsp;       <textarea class="form-control mb-3" rows="4" placeholder="Message" required></textarea>

&nbsp;       <button class="btn btn-primary">Send</button>

&nbsp;     </form>

&nbsp;   </div>

&nbsp;   <div class="col-md-6">

&nbsp;     <h5>Store Info</h5>

&nbsp;     <p>123 Market Street, City</p>

&nbsp;     <p>Phone: +91-90000-00000</p>

&nbsp;     <p>Email: help@supermarket.com</p>

&nbsp;     <p>Follow us: <a href="#">Facebook</a> • <a href="#">Instagram</a> • <a href="#">Twitter</a></p>

&nbsp;   </div>

&nbsp; </div>

</div>

</section>



<!-- Footer -->

<footer class="text-center">

&nbsp; <p>\&copy; 2025 Supermarket. All rights reserved.</p>

</footer>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>







#### =================      **LOCAL EVENT MANAGEMENT WEBSITE**    ================



==================== style.css ====================

body {

&nbsp; font-family: Arial, sans-serif;

&nbsp; background-color: #f8f9fa;

}



header, footer {

&nbsp; background-color: #343a40;

&nbsp; color: white;

&nbsp; padding: 15px 0;

}



header h1 {

&nbsp; margin: 0;

}



.navbar-nav .nav-link {

&nbsp; color: white !important;

}



.table-box {

&nbsp; border: 2px solid #007bff;

&nbsp; padding: 15px;

&nbsp; margin-top: 20px;

}



ul.activities {

&nbsp; list-style-type: square;

&nbsp; padding-left: 20px;

}



footer a {

&nbsp; color: #ffc107;

&nbsp; text-decoration: none;

}





==================== index.html ====================

<!DOCTYPE html>

<html lang="en">

<head>

&nbsp; <meta charset="UTF-8">

&nbsp; <meta name="viewport" content="width=device-width, initial-scale=1.0">

&nbsp; <title>Local Event - Home</title>

&nbsp; <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

&nbsp; <link rel="stylesheet" href="style.css">

</head>

<body>



<header class="text-center">

&nbsp; <h1>Community Festival 2025</h1>

</header>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

&nbsp; <div class="container">

&nbsp;   <a class="navbar-brand" href="index.html">Event</a>

&nbsp;   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">

&nbsp;     <span class="navbar-toggler-icon"></span>

&nbsp;   </button>

&nbsp;   <div class="collapse navbar-collapse" id="navbarNav">

&nbsp;     <ul class="navbar-nav ms-auto">

&nbsp;       <li class="nav-item"><a class="nav-link active" href="index.html">Home</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="register.html">Register</a></li>

&nbsp;     </ul>

&nbsp;   </div>

&nbsp; </div>

</nav>



<main class="container py-4">

&nbsp; <h2>Event Schedule</h2>

&nbsp; <div class="table-box">

&nbsp;   <table class="table table-striped table-bordered table-dark">

&nbsp;     <thead>

&nbsp;       <tr>

&nbsp;         <th>Time</th>

&nbsp;         <th>Activity</th>

&nbsp;         <th>Location</th>

&nbsp;       </tr>

&nbsp;     </thead>

&nbsp;     <tbody>

&nbsp;       <tr>

&nbsp;         <td>10:00 AM</td>

&nbsp;         <td>Opening Ceremony</td>

&nbsp;         <td>Main Stage</td>

&nbsp;       </tr>

&nbsp;       <tr>

&nbsp;         <td>12:00 PM</td>

&nbsp;         <td>Food Stalls Open</td>

&nbsp;         <td>Food Court</td>

&nbsp;       </tr>

&nbsp;       <tr>

&nbsp;         <td>3:00 PM</td>

&nbsp;         <td>Music Performance</td>

&nbsp;         <td>Stage B</td>

&nbsp;       </tr>

&nbsp;     </tbody>

&nbsp;   </table>

&nbsp; </div>



&nbsp; <h2 class="mt-4">Activities</h2>

&nbsp; <ul class="activities">

&nbsp;   <li>Live Music</li>

&nbsp;   <li>Art Exhibition</li>

&nbsp;   <li>Cooking Competition</li>

&nbsp;   <li>Kids' Games</li>

&nbsp; </ul>



&nbsp; <h2 class="mt-4">Promo Video</h2>

&nbsp; <video width="100%" controls>

&nbsp;   <source src="assets/promo.mp4" type="video/mp4">

&nbsp;   Your browser does not support the video tag.

&nbsp; </video>



&nbsp; <h2 class="mt-4">Theme Song</h2>

&nbsp; <audio controls>

&nbsp;   <source src="assets/theme.mp3" type="audio/mpeg">

&nbsp;   Your browser does not support the audio element.

&nbsp; </audio>

</main>



<footer class="text-center">

&nbsp; <p>\&copy; 2025 Local Event. All rights reserved. | <a href="#">Privacy Policy</a></p>

</footer>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>





==================== about.html ====================

<!DOCTYPE html>

<html lang="en">

<head>

&nbsp; <meta charset="UTF-8">

&nbsp; <meta name="viewport" content="width=device-width, initial-scale=1.0">

&nbsp; <title>About - Local Event</title>

&nbsp; <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

&nbsp; <link rel="stylesheet" href="style.css">

</head>

<body>



<header class="text-center">

&nbsp; <h1>About Our Community Event</h1>

</header>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

&nbsp; <div class="container">

&nbsp;   <a class="navbar-brand" href="index.html">Event</a>

&nbsp;   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">

&nbsp;     <span class="navbar-toggler-icon"></span>

&nbsp;   </button>

&nbsp;   <div class="collapse navbar-collapse" id="navbarNav">

&nbsp;     <ul class="navbar-nav ms-auto">

&nbsp;       <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link active" href="about.html">About</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="register.html">Register</a></li>

&nbsp;     </ul>

&nbsp;   </div>

&nbsp; </div>

</nav>



<main class="container py-4">

&nbsp; <h2>Our Story</h2>

&nbsp; <p class="lead">The Community Festival is an annual event that brings together residents, artists, musicians, and food lovers for a day of fun, culture, and unity.</p>

&nbsp; <p>We aim to create a vibrant atmosphere where people of all ages can come together and enjoy a variety of activities, performances, and delicious food. This event is made possible thanks to the support of local businesses, volunteers, and the community.</p>

</main>



<footer class="text-center">

&nbsp; <p>\&copy; 2025 Local Event. All rights reserved.</p>

</footer>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>





==================== register.html ====================

<!DOCTYPE html>

<html lang="en">

<head>

&nbsp; <meta charset="UTF-8">

&nbsp; <meta name="viewport" content="width=device-width, initial-scale=1.0">

&nbsp; <title>Register - Local Event</title>

&nbsp; <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

&nbsp; <link rel="stylesheet" href="style.css">

</head>

<body>



<header class="text-center">

&nbsp; <h1>Register for the Event</h1>

</header>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

&nbsp; <div class="container">

&nbsp;   <a class="navbar-brand" href="index.html">Event</a>

&nbsp;   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">

&nbsp;     <span class="navbar-toggler-icon"></span>

&nbsp;   </button>

&nbsp;   <div class="collapse navbar-collapse" id="navbarNav">

&nbsp;     <ul class="navbar-nav ms-auto">

&nbsp;       <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>

&nbsp;       <li class="nav-item"><a class="nav-link active" href="register.html">Register</a></li>

&nbsp;     </ul>

&nbsp;   </div>

&nbsp; </div>

</nav>



<main class="container py-4">

&nbsp; <form>

&nbsp;   <div class="mb-3">

&nbsp;     <label for="name" class="form-label">Full Name</label>

&nbsp;     <input type="text" class="form-control" id="name" required>

&nbsp;   </div>

&nbsp;   <div class="mb-3">

&nbsp;     <label for="email" class="form-label">Email address</label>

&nbsp;     <input type="email" class="form-control" id="email" required>

&nbsp;   </div>

&nbsp;   <div class="mb-3">

&nbsp;     <label class="form-label">Gender</label><br>

&nbsp;     <div class="form-check form-check-inline">

&nbsp;       <input class="form-check-input" type="radio" name="gender" id="male" value="male" required>

&nbsp;       <label class="form-check-label" for="male">Male</label>

&nbsp;     </div>

&nbsp;     <div class="form-check form-check-inline">

&nbsp;       <input class="form-check-input" type="radio" name="gender" id="female" value="female">

&nbsp;       <label class="form-check-label" for="female">Female</label>

&nbsp;     </div>

&nbsp;   </div>

&nbsp;   <div class="mb-3">

&nbsp;     <label for="eventType" class="form-label">Event Type</label>

&nbsp;     <select class="form-select" id="eventType" required>

&nbsp;       <option value="">Choose...</option>

&nbsp;       <option>Music</option>

&nbsp;       <option>Art</option>

&nbsp;       <option>Cooking</option>

&nbsp;       <option>Games</option>

&nbsp;     </select>

&nbsp;   </div>

&nbsp;   <button type="submit" class="btn btn-primary">Submit</button>

&nbsp; </form>

</main>



<footer class="text-center">

&nbsp; <p>\&copy; 2025 Local Event. All rights reserved.</p>

</footer>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>



