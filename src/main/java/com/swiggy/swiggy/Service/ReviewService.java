package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.Review;
import com.swiggy.swiggy.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

}
