package com.ram.foodie.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ram.foodie.Interfaces.UserDAO;
import com.ram.foodie.model.User;



public class UserDAOImpl implements UserDAO {
	
	private Transaction t;
	private Session session;
	
		
	public UserDAOImpl() {
		session= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory().openSession();
	}
    @Override
    public List<User> getAllUser() {
        
    	return (List<User>) session.createQuery("from users").list();
    }

    @Override
    public User getUser(int id) {
        
    	return session.get(User.class, id);
    }

    public User getUserByEmail(String email) {
    	return session.get(User.class,email);
    }
    @Override
    public void updateUser(String email,int id) {
    	t = session.beginTransaction();
		User s = session.get(User.class, id);
		if(s!=null) {
			s.setEmail(email);
			session.persist(s);
		}
		session.getTransaction().commit();
    }

    @Override
    public int insertUser(User u) {
    	
    	t = session.beginTransaction();
		session.persist(u);
		t.commit();
		return 1;
    }

    @Override
    public void deleteUser(int id) {
    	t = session.beginTransaction();
		session.delete(getUser(id));
		session.getTransaction().commit();
    }
}

