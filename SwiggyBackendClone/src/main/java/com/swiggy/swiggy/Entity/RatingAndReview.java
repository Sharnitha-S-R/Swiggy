package com.swiggy.swiggy.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "RatingAndReview")
@NoArgsConstructor
@AllArgsConstructor
public class RatingAndReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review_text")
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
