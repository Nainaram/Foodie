
package com.ram.foodie.Interfaces;

import java.util.List;

import com.ram.foodie.model.User;

public interface UserDAO {

    public List<User> getAllUser();

    public User getUser(int id);
    
    public User getUserByEmail(String email);

    public void updateUser( String email, int id);

    public int insertUser(User u);

    public void deleteUser(int id);
}

