package com.ram.foodie.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ram.foodie.Interfaces.MenuDAO;
import com.ram.foodie.model.Menu;

public class MenuDAOImpl implements MenuDAO {

    private Transaction t;
    private Session session;

    public MenuDAOImpl() {
        session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Menu.class)
                .buildSessionFactory().openSession();
    }

    @Override
    public List<Menu> getAllMenus() {
        return (List<Menu>) session.createQuery("from menus").list();
    }

    @Override
    public Menu getMenu(int id) {
        return session.get(Menu.class, id);
    }

    @Override
    public void updateMenu(int price, int id) {
        t = session.beginTransaction();
        Menu m = session.get(Menu.class, id);
        if (m != null) {
            m.setPrice(price);
            session.persist(m);
        }
        session.getTransaction().commit();
    }

    @Override
    public void insertMenu(Menu menu) {
        t = session.beginTransaction();
        session.persist(menu);
        t.commit();
    }

    @Override
    public void deleteMenu(int id) {
        t = session.beginTransaction();
        session.delete(getMenu(id));
        session.getTransaction().commit();
    }
}