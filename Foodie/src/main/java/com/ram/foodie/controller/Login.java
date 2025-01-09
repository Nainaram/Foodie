package com.ram.foodie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ram.foodie.DAOImpl.UserDAOImpl;
import com.ram.foodie.Security.Decrypt;
import com.ram.foodie.model.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        // Retrieve email and password from request
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Create DAO instance and fetch user by email
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByEmail(email);

        if (user != null) { // If user exists
            if (Decrypt.decrypt(user.getPassword()).equals(password)) { // Password matches
                // Create session
                HttpSession session = req.getSession();
                session.setAttribute("name", user.getUsername());
                session.setAttribute("email", user.getEmail());

                // Redirect to home page
                resp.sendRedirect("GetRestaurant");
            } else {
                // Incorrect password
                req.setAttribute("errorMessage", "Invalid password. Please try again.");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            // Email not found
            req.setAttribute("errorMessage", "No account found with this email. Please register.");
            	req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}

		


