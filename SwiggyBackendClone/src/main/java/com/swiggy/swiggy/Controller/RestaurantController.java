package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/addRestaurant/{userId}")
    private String addRestaurant(@PathVariable("userId") int userId, @RequestBody Restaurant restaurant)
    {
        restaurantService.addRestaurant(userId, restaurant);
        return "Restaurant added successfully";
    }

    @DeleteMapping("/deleteRestaurant/{userId}/{restaurantId}")
    public String deleteRestaurant(@PathVariable("userId") int userId, @PathVariable("restaurantId") long restaurantId){

        restaurantService.deleteRestaurant(userId,restaurantId);
        return "Restaurant deleted successfully";
    }

    @GetMapping("/getAllRestaurants/{userId}")
    public List<Restaurant> getAllRestaurants(@PathVariable("userId") int userId){

        return restaurantService.getAllRestaurants(userId);
    }

    @PutMapping("/updateRestaurant/{userId}/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("userId") int userId, @PathVariable("restaurantId") long restaurantId,@RequestBody Restaurant restaurant)
    {
        return restaurantService.updateRestaurant(userId, restaurantId, restaurant);
    }





}