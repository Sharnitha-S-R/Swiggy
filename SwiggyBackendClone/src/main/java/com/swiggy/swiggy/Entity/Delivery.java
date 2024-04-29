package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "Delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "deliver_person_Id", referencedColumnName = "deliveryPersonId")
    private DeliveryPerson deliveryPerson;

    @Column(name = "DeliveryStatus")
    private String deliveryStatus;
}
