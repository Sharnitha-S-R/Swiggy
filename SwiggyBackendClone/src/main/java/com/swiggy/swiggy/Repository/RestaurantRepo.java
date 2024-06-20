package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long>{
        }