package com.swiggy.swiggy.Repository;
import org.springframework.stereotype.Service;
import com.swiggy.swiggy.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantRepo extends JpaRepository<Restaurant , Long> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long restaurantId);
}

