package com.swiggy.swiggy.Service;


import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private UserService userService;

    public Restaurant addRestaurant(int userId, Restaurant restaurant)
    {
        if (userService.isRestaurantAdminLoggedIn(userId)){
            return restaurantRepo.save(restaurant);
        }
        else {
            throw new IllegalArgumentException("Restaurant admin must be logged in to add a Restaurant");
        }
    }

    public void deleteRestaurant(int userId, long restaurantId)
    {
        if (userService.isRestaurantAdminLoggedIn(userId)){
            restaurantRepo.deleteById(restaurantId);
        }
        else {
            throw new IllegalArgumentException("Restaurant admin must be logged in to delete a Restaurant");
        }

    }
    public List<Restaurant> getAllRestaurants(int userId)
    {
        if (userService.isUserLoggedIn(userId))
        {
            return restaurantRepo.findAll();
        }
        else {
            return Collections.emptyList();
        }
    }

    public Restaurant updateRestaurant(int userId, long restaurantId,Restaurant restaurant)
    {
        if (userService.isEmpRestaurant(userId)){
            Restaurant restaurant1 = restaurantRepo.findById(restaurantId).orElseThrow(()-> new RuntimeException("Restaurant not found with restaurantId :" + restaurantId));

            restaurant1.setRestaurantName(restaurant.getRestaurantName());
            restaurant1.setCuisine(restaurant.getCuisine());
            restaurant1.setLocation(restaurant.getLocation());
            restaurant1.setRating(restaurant.getRating());
            restaurant1.setPhoneNumber(restaurant.getPhoneNumber());

            return restaurantRepo.save(restaurant1);
        }else {
            throw new IllegalArgumentException("Employee or Restaurant admin must be logged in to update the restaurant data");
        }
    }

}











