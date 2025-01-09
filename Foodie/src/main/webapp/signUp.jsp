<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to bottom right, #ff4500, #ffa500);
        }
        .signup-container {
            background-color: #ffb84d;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            width: 300px;
        }
        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .signup-container label {
            font-size: 14px;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }
        .signup-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .signup-container button {
            width: 100%;
            padding: 10px;
            background-color: #ff4500;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .signup-container button:hover {
            background-color: #3a8cd6;
        }
        .password-container input {
            width: 100%;
            padding: 10px 40px 10px 10px; /* Leave space for the eye icon */
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .toggle-password {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            cursor: pointer;
            font-size: 14px;
            color: #666;
        }
         .password-container {
            position: relative;
            width: 100%; /* Adjust width as per container */
        }
         .password-container .toggle-password {
            position: absolute;
            top: 50%;
            right: 10px;
            bottom:5px;
            transform: translateY(-50%);
            cursor: pointer;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>Signup</h2>
        <form action ="SignUp" method="post" >
            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Enter your name" required>
            <label for="username">UserName</label>
            <input type="text" id="username" name="username" placeholder="Enter your UserName" required>
			<label for="address">Address</label>
            <input type="text" id="address" name="address" placeholder="Enter your address" required>
            <label for="role">Role</label>
            <input type="text" id="role" name="role" placeholder="Enter your Role" required>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="password">Password</label>
           <div class="password-container">
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
            <span class="toggle-password" onclick="togglePassword()">👁️</span>
        </div>

            <label for="Phone">Phone</label>
            <input type="tel" id="Mobile" name="phone" placeholder="Enter your phone number" required>

            <button type="submit">Signup</button>
            <h1 style="font-size: 1rem">Already having account? <a  style="text-decoration:none;"href="login.html" >Login</a></h1>
        </form>
    </div>
    <script>
        function togglePassword() {
            const passwordInput = document.getElementById('password');
            const toggleIcon = document.querySelector('.toggle-password');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.textContent = '🙈'; // Change icon to "hide"
            } else {
                passwordInput.type = 'password';
                toggleIcon.textContent = '👁️'; // Change icon back to "show"
            }
        }
    </script>
</body>
</html>
