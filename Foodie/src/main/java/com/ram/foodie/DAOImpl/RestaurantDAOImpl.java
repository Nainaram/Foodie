package com.ram.foodie.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ram.foodie.Interfaces.RestaurantDAO;
import com.ram.foodie.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

    private Transaction t;
    private Session session;

    public RestaurantDAOImpl() {
        session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Restaurant.class)
                .buildSessionFactory().openSession();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) session.createQuery("from restaurants").list();
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return session.get(Restaurant.class, id);
    }

    @Override
    public void updateRestaurant(String address, int id) {
        t = session.beginTransaction();
        Restaurant r = session.get(Restaurant.class, id);
        if (r != null) {
            r.setAddress(address);
            session.persist(r);
        }
        session.getTransaction().commit();
    }

    @Override
    public void insertRestaurant(Restaurant restaurant) {
        t = session.beginTransaction();
        session.persist(restaurant);
        t.commit();
    }

    @Override
    public void deleteRestaurant(int id) {
        t = session.beginTransaction();
        session.delete(getRestaurant(id));
        session.getTransaction().commit();
    }
}
