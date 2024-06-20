package com.swiggy.swiggy.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Deliveries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_person_name")
    private String deliveryPersonName;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
