package com.ram.foodie.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int orderId;

    @Column(name = "userId", nullable = false)
   
    private int userId;

    @Column(name = "restaurantId", nullable = false)
    
    private int restaurantId;

    @Column(name = "orderDate", nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @Column(name = "totalAmount", nullable = false)
   
    private double totalAmount;

    @Column(name = "status", nullable = false)
   
    private String status;

    @Column(name = "paymentMode", nullable = false)
    
    private String paymentMode;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false) // Foreign key to User table
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false) // Foreign key to Restaurant table
    private Restaurant restaurant;

    // Default Constructor
    public Order() {
        this.orderDate = LocalDateTime.now(); // Automatically set the order date
    }

    // Parameterized Constructor
    public Order(int userId, int restaurantId, double totalAmount, String status, String paymentMode) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
        this.orderDate = LocalDateTime.now(); // Automatically set the order date
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId +
                ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status +
                ", paymentMode=" + paymentMode + "]";
    }
}
