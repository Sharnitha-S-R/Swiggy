package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Float rating;
    private String comment;





}