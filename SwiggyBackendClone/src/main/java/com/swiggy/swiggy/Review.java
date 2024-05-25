package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


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
    @Temporal(TemporalType.DATE)
    private Date reviewDate;




}