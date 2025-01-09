<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ram.foodie.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant App</title>
       
    <style>
        /* General reset */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background: linear-gradient(to bottom right, #ff4500, #ffa500);
        }

        /* Container for the cards */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            gap: 20px;
        }

        /* Styling individual cards */
        .card {
            background-color: #ffb84d; /* Light cream */
            width: 30%;
            padding: 20px;
            border: 1px solid #000;
            border-radius: 8px;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 300px;
        }

        /* Display restaurant info */
        .restaurant-info {
            margin-bottom: 10px;
            line-height: 1.6;
        }

        /* Styling the buttons */
        .button-container {
            display: flex;
            justify-content: space-between;
        }

        .btn {
            background-color: #333;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #555;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-orange navbar-white d-flex justify-content-end">
  
      
    </div>
    <a href="login.html"><button class ="btn btn-bd-yellow-red ">Go Back</button></a>
  </div>
</nav>
    <h1>Restaurants List</h1>
    <div class="container">
        <% 
            ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) session.getAttribute("restaurantList"); 
            if (restaurantList != null && !restaurantList.isEmpty()) {
                for (Restaurant rest : restaurantList) { 
        %>
            <div class="card">
            		<img alt= src=<%= rest.getImagePath() %>>
                <div class="restaurant-info">
                    <p><strong>Restaurant ID:</strong> <%= rest.getRestaurantId()%></p>
                    <p><strong>Name:</strong> <%= rest.getName() %></p>
                    <p><strong>Cuisine Type:</strong> <%= rest.getCuisineType() %></p>
                    <p><strong>Address:</strong> <%= rest.getAddress() %></p>
                    <p><strong>Ratings:</strong> <%= rest.getRating() %>/5</p>
                    <p><strong>Delivery Time:</strong> <%= rest.getEstimatedTime() %> minutes</p>
                    <p><strong>Active:</strong> <%= rest.isActive() ? "Yes" : "No" %></p>
                </div>
                <div class="button-container">
                    <a href="ShowMenu?id=<%= rest.getRestaurantId() %>"><button class="btn">View Menu</button></a>
                    <button class="btn">Order Now</button>
                </div>
            </div>
        <% 
                } 
            } else { 
        %>
            <p>No restaurants available at the moment.</p>
        <% 
            } 
        %>
    </div>
   </body>
</html>
