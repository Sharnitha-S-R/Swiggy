package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.Review;
import com.swiggy.swiggy.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        try {
            reviewService.saveReview(review);
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable int userId) {
        try {
            List<Review> reviews = reviewService.getAllReviews(userId);
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
        @DeleteMapping("/deleteReview/{reviewId}/{userId}")
        public String deleteRestaurant(@PathVariable("userId") int userId, @PathVariable("reviewId") long reviewId){

            reviewService.deleteReview(userId,reviewId);
            return "Review deleted successfully";

    }

}
