package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.RatingAndReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingAndReviewRepo extends JpaRepository<RatingAndReview, Long> {
}
