package com.ram.foodie.Interfaces;

import java.util.List;

import com.ram.foodie.model.Menu;

public interface MenuDAO {

    public List<Menu> getAllMenus();

    public Menu getMenu(int id);

    public void updateMenu( int price ,int id);

    public void insertMenu(Menu menu);

    public void deleteMenu(int id);
}