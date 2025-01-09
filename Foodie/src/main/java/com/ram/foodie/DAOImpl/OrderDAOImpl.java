package com.ram.foodie.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ram.foodie.Interfaces.OrderDAO;
import com.ram.foodie.model.Order;

public class OrderDAOImpl implements OrderDAO {

    private Transaction t;
    private Session session;

    public OrderDAOImpl() {
        session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .buildSessionFactory().openSession();
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) session.createQuery("from orders").list();
    }

    @Override
    public Order getOrder(int id) {
        return session.get(Order.class, id);
    }

    @Override
    public void updateOrder(String status, int id) {
        t = session.beginTransaction();
        Order o = session.get(Order.class, id);
        if (o != null) {
            o.setStatus(status);
            session.persist(o);
        }
        session.getTransaction().commit();
    }

    @Override
    public void insertOrder(Order order) {
        t = session.beginTransaction();
        session.persist(order);
        t.commit();
    }

    @Override
    public void deleteOrder(int id) {
        t = session.beginTransaction();
        session.delete(getOrder(id));
        session.getTransaction().commit();
    }
}