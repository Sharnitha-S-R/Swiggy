package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.Order;
import com.swiggy.swiggy.Entity.Review;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Repository.OrderRepo;
import com.swiggy.swiggy.Repository.ReviewRepo;
import com.swiggy.swiggy.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserService userService;

    public Review saveReview(Review review) {
        if (userService.isUserLoggedIn(review.getUser().getId())) {
            return reviewRepo.save(review);
        } else {
            throw new IllegalArgumentException("User is not logged in.");
        }
    }


    public Optional<Review> getReviewById(Long id) {
        return reviewRepo.findById(id);
    }
    public List<Review> getAllReviews(int userId) {
        if (userService.isUserLoggedIn(userId)) {
            return reviewRepo.findAll();
        } else {
            throw new IllegalArgumentException("User is not logged in.");
        }
    }
    public void deleteReview(int userId, long reviewId) {
        if (userService.isEmpRestaurant(userId)) {
            reviewRepo.deleteById(reviewId);
        } else {
            throw new IllegalArgumentException("Restaurant admin must be logged in to delete a menu item");
        }
    }


}
