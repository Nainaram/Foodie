package com.ram.foodie.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ram.foodie.DAOImpl.UserDAOImpl;

import com.ram.foodie.Security.Encrypt;
import com.ram.foodie.model.User;


public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    			
				
				@Override
				protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					 String name = req.getParameter("name");
				        String email = req.getParameter("email");
				        String password = req.getParameter("password");
				        String phone = req.getParameter("phone");
				        String username = req.getParameter("username");
				        String address  = req.getParameter("address");
				        String role = req.getParameter("role");
				        User user = new User(name,username,Encrypt.encrypt(password),email,phone,address,role);
				        try {
									UserDAOImpl udaoimpl = new UserDAOImpl();
								int status=	udaoimpl.insertUser(user);
								if(status>0) {
									resp.sendRedirect("login.html");
								}else {
									resp.sendRedirect("signup.jsp");
								}
									
				        		
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
				
}
