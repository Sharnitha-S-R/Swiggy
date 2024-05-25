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

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @Column(name = "CUISINE")
    private String cuisine;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "RATING")
    private Double rating;

}



