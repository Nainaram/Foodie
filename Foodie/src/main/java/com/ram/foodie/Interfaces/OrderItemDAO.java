package com.ram.foodie.Interfaces;

import java.util.List;

import com.ram.foodie.model.OrderItem;

public interface OrderItemDAO {

    public List<OrderItem> getAllOrderItems();

    public OrderItem getOrderItem(int id);

    public void updateOrderItem(double totalPrice ,int id);

    public void insertOrderItem(OrderItem orderItem);

    public void deleteOrderItem(int id);
}