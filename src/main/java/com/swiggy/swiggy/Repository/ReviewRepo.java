package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByUserUserIdAndRestaurantRestaurantId(Long userId, Long restaurantId);
}
