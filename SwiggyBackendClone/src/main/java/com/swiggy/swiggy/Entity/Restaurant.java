package com.swiggy.swiggy.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Restaurant_DB")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "RESTAURANT_NAME", nullable = false)
    private String restaurantName;

    @Column(name = "CUISINE", nullable = false)
    private String cuisine;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;



}