package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DeliveryPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliverypersonId")
    private Long deliveryPersonId;

    @Column(name = "personname")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "status")
    private String status;
}
