package com.ram.foodie.Interfaces;

import java.util.List;

import com.ram.foodie.model.Order;

public interface OrderDAO {

    public List<Order> getAllOrders();

    public Order getOrder(int id);

    public void updateOrder( String status,int id);

    public void insertOrder(Order order);

    public void deleteOrder(int id);
}