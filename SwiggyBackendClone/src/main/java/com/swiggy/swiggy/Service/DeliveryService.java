package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.Delivery;
import com.swiggy.swiggy.Repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepo deliveryRepo;

    @Autowired
    public DeliveryService(DeliveryRepo deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    // You can add other service methods as needed
}
