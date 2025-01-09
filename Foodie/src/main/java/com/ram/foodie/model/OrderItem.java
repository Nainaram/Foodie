package com.ram.foodie.model;

import jakarta.persistence.*;


@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int orderItemId;

    @Column(name = "orderId", nullable = false)
   
    private int orderId;

    @Column(name = "menuId", nullable = false)
    
    private int menuId;

    @Column(name = "quantity", nullable = false)
   
    private int quantity;

    @Column(name = "totalPrice", nullable = false)
   
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false) // Foreign key to Order table
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false) // Foreign key to Menu table
    private Menu menu;

    // Default Constructor
    public OrderItem() {}

    // Parameterized Constructor
    public OrderItem(int orderId, int menuId, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId +
                ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
    }
}
