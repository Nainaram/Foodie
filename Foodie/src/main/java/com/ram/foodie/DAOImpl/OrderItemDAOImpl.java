package com.ram.foodie.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ram.foodie.Interfaces.OrderItemDAO;
import com.ram.foodie.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private Transaction t;
    private Session session;

    public OrderItemDAOImpl() {
        session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(OrderItem.class)
                .buildSessionFactory().openSession();
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return (List<OrderItem>) session.createQuery("from order_items").list();
    }

    @Override
    public OrderItem getOrderItem(int id) {
        return session.get(OrderItem.class, id);
    }

    @Override
    public void updateOrderItem(double totalPrice, int id) {
        t = session.beginTransaction();
        OrderItem oi = session.get(OrderItem.class, id);
        if (oi != null) {
            oi.setTotalPrice(totalPrice);
            session.persist(oi);
        }
        session.getTransaction().commit();
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) {
        t = session.beginTransaction();
        session.persist(orderItem);
        t.commit();
    }

    @Override
    public void deleteOrderItem(int id) {
        t = session.beginTransaction();
        session.delete(getOrderItem(id));
        session.getTransaction().commit();
    }
}
