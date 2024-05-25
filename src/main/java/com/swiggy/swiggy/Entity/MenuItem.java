package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "menu_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private double price;
    private String category;
    private String ingredients;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
