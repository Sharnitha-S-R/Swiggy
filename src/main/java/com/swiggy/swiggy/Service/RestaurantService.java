package com.swiggy.swiggy.Service;
import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Repository.RestaurantRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;




    public Restaurant saveRestaurant(Restaurant restaurant){
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {

        return restaurantRepo.findById(id);
    }

    public void deleteRestaurant(Long id) {

        restaurantRepo.deleteById(id);
    }




}


