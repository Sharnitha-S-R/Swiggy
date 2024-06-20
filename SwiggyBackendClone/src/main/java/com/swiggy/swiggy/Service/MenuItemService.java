package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Repository.MenuItemRepo;
import com.swiggy.swiggy.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private UserService userService;

    public MenuItem addMenu(int userId, MenuItem menuItem) {
        if (userService.isRestaurantAdminLoggedIn(userId)) {
            Long restaurantId = menuItem.getRestaurant().getRestaurantId();
            Restaurant restaurant = restaurantRepo.findById(restaurantId)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
            menuItem.setRestaurant(restaurant);
            return menuItemRepo.save(menuItem);
        } else {
            throw new IllegalArgumentException("Restaurant admin must be logged in to add a menu item");
        }
    }

    public void deleteMenuItem(int userId, long menuItemId) {
        if (userService.isRestaurantAdminLoggedIn(userId)) {
            // Assuming menuItemRepo has a method to delete by id
            menuItemRepo.deleteById(menuItemId);
        } else {
            throw new IllegalArgumentException("Restaurant admin must be logged in to delete a menu item");
        }
    }

    public List<MenuItem> getMenuItemsForRestaurant(int userId, Long restaurantId) {
        if (userService.isUserLoggedIn(userId)) {
            Restaurant restaurant = restaurantRepo.findById(restaurantId)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
            return menuItemRepo.findByRestaurant(restaurant);
        } else {
            throw new IllegalArgumentException("User must be logged in to fetch menu items");
        }


    }
}

