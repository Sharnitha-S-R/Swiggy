package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.Delivery;
import com.swiggy.swiggy.Repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;

    public Delivery createOrUpdateDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepo.findById(id);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepo.findAll();
    }
    public void deleteDelivery(Long id) {
        deliveryRepo.deleteById(id);
    }
}
