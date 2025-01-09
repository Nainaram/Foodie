package com.ram.foodie.Interfaces;

import java.util.List;

import com.ram.foodie.model.Restaurant;

public interface RestaurantDAO {

    public List<Restaurant> getAllRestaurants();

    public Restaurant getRestaurant(int id);

    public void updateRestaurant(String address,int id);

    public void insertRestaurant(Restaurant restaurant);

    public void deleteRestaurant(int id);
}