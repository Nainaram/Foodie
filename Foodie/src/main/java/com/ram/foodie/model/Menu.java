package com.ram.foodie.model;

import jakarta.persistence.*;


@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int menuId;

    @Column(name = "restaurantId", nullable = false)
    
    private int restaurantId;

    @Column(name = "itemName", nullable = false)
   
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
   
    private int price;

    @Column(name = "ratings")
   
    private int ratings;

    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;

    @Column(name = "imagePath")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false) // Foreign key to Restaurant table
    private Restaurant restaurant;

    // Default Constructor
    public Menu() {}

    // Parameterized Constructor
    public Menu(int restaurantId, String itemName, String description, int price, int ratings, 
                boolean isAvailable, String imagePath) {
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.ratings = ratings;
        this.isAvailable = isAvailable;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + 
               ", description=" + description + ", price=" + price + ", ratings=" + ratings + 
               ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
    }
}
