package com.ram.foodie.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int userid;
    @Column(name ="name")
    private String name;
    @Column(name="username",unique=true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="role")
    private String role;
    
    @Column( name ="createdDate",nullable = false, updatable = false) // Set on creation, not updatable
    private LocalDateTime createdDate;

    @Column( name ="lastLoginDate",nullable = false)
    private LocalDateTime lastLoginDate;

    // Constructor
    public User() {
        // Automatically set createdDate and lastLoginDate
        this.createdDate = LocalDateTime.now();
        this.lastLoginDate = LocalDateTime.now();
    }
    

    public User(String name, String username, String password, String email, String phone, String address, String role
			) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		
	}


	public User(int userid, String name, String username, String password, String email, String phone, String address,
			String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		
	}


	// Getters and Setters
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", role=" + role + ", createdDate="
				+ createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}
    
}
