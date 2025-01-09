<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ram.foodie.model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* General page styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }

        /* Container styling */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 20px;
        }

        /* Card styles */
        .card {
            background: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            margin: 15px;
            width: 300px;
            overflow: hidden;
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .card-content {
            padding: 15px;
            text-align: center;
        }

        .card-title {
            font-size: 1.5rem;
            font-weight: bold;
            color: #333;
            margin: 0;
        }

        .card-description {
            color: #555;
            font-size: 1rem;
            margin: 10px 0;
        }

        .card-rating {
            color: #ff9800;
            font-weight: bold;
        }

        .availability {
            color: green;
            font-weight: bold;
        }

        .unavailable {
            color: red;
            font-weight: bold;
        }

        /* Buttons for quantity and cart */
        .quantity-controls {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 10px 0;
        }

        .quantity-btn {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            font-size: 1.2rem;
            border-radius: 5px;
            margin: 0 5px;
            transition: background 0.3s;
        }

        .quantity-btn:hover {
            background-color: #0056b3;
        }

        .quantity-input {
            font-size: 1rem;
            width: 40px;
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .add-to-cart-btn {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            font-size: 1rem;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .add-to-cart-btn:hover {
            background-color: #218838;
        }

        /* Responsive cards */
        @media (max-width: 768px) {
            .card {
                width: 100%;
            }
        }
          .btn-bd-yellow-red {
  --bs-btn-font-weight: 600;
  --bs-btn-color: var(--bs-white); /* Text color */
  --bs-btn-bg: #ffb84d; /* Base yellowish-red background */
  --bs-btn-border-color: #ffb84d; /* Base yellowish-red border */
  --bs-btn-hover-color: var(--bs-white); /* Text color on hover */
  --bs-btn-hover-bg: #ff9933; /* Slightly darker shade for hover */
  --bs-btn-hover-border-color: #ff9933; /* Border color on hover */
  --bs-btn-focus-shadow-rgb: 255, 179, 77; /* RGB value for focus shadow */
  --bs-btn-active-color: var(--bs-btn-hover-color); /* Active text color */
  --bs-btn-active-bg: #cc7a29; /* Even darker shade for active state */
  --bs-btn-active-border-color: #cc7a29; /* Border color for active state */
}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-orange navbar-white d-flex justify-content-end">
  
      
    </div>
    <a href="home.jsp"><button class ="btn btn-bd-yellow-red ">Go Back</button></a>
  </div>
</nav>

    <h1 style="text-align:center; margin-top: 20px;">Restaurant Menu</h1>
    <div class="container">
        <%-- Fetch the list of menu items from the session --%>
        <% 
            List<Menu> menuList = (List<Menu>) session.getAttribute("menu");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu item : menuList) {
        %>
       <!-- Individual Menu Card -->
<div class="card">
    <img src="<%= item.getImagePath() %>" alt="<%= item.getImagePath() %>">
    <div class="card-content">
        <h2 class="card-title"><%= item.getItemName() %></h2>
        <p class="card-description"><%= item.getDescription() %></p>
        <p class="card-rating">Rating: <%= item.getRatings() %> &#9733;</p>
        <% if (item.isAvailable()) { %>
            <p class="availability">Available</p>
        <% } else { %>
            <p class="unavailable">Not Available</p>
        <% } %>
        <p>Price: $<%= item.getPrice() %></p>
         <!-- Quantity Controls -->
               

        <!-- Form for Quantity and Add to Cart -->
  			<form action="CartServlet" method="post">
                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                <input type="hidden" name="name" value="<%= item.getItemName() %>">
                <input type="hidden" name="price" value="<%= item.getPrice() %>">
                <input type="hidden" name="restId" value="<%= item.getRestaurantId() %>">
                <input type ="text" name = "quantity"  placeholder="enter quantity">
               <!--   <div class="quantity-controls">
                    <button class="quantity-btn" onclick="decreaseQuantity(this)">-</button>
                    <input type="text" name=quantity class="quantity-input" value="1"  >
                    <button class="quantity-btn" onclick="increaseQuantity(this)">+</button>
                </div> -->
                <button type="submit" class="add-to-cart-btn">Add to Cart</button>
            </form>    </div>
</div>

        <%
                }
            } else {
        %>
            <h2 style="text-align: center; color: #777;">No menu items available.</h2>
        <% } %>
    </div>
     <!-- Order Now Button -->
    <div style="text-align:center; margin:20px;">
        <form action="ShowCart" method="get">
            <button type="submit" style="padding: 10px 20px; background-color: #008CBA; color: white; border: none; cursor: pointer;">Order Now</button>
        </form>
    </div>
 
    <script>
        // JavaScript to handle quantity increase and decrease
        function increaseQuantity(button) {
            const input = button.previousElementSibling;
            let value = parseInt(input.value, 10);
            value++;
            input.value = value;
        }

        function decreaseQuantity(button) {
            const input = button.nextElementSibling;
            let value = parseInt(input.value, 10);
            if (value > 1) {
                value--;
                input.value = value;
            }
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    
</body>
</html>
