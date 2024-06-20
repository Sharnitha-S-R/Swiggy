package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.Delivery;
import com.swiggy.swiggy.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/create")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery savedDelivery = deliveryService.createOrUpdateDelivery(delivery);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Optional<Delivery> delivery = deliveryService.getDeliveryById(id);
        return delivery.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        Optional<Delivery> existingDeliveryOpt = deliveryService.getDeliveryById(id);
        if (existingDeliveryOpt.isPresent()) {
            Delivery existingDelivery = existingDeliveryOpt.get();
            existingDelivery.setDeliveryPersonName(delivery.getDeliveryPersonName());
            existingDelivery.setDeliveryStatus(delivery.getDeliveryStatus());
            existingDelivery.setContactNumber(delivery.getContactNumber());
            deliveryService.createOrUpdateDelivery(existingDelivery);
            return new ResponseEntity<>("Delivery updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delivery not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable Long id) {
        try {
            deliveryService.deleteDelivery(id);
            return new ResponseEntity<>("Delivery deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Delivery not found", HttpStatus.NOT_FOUND);
        }
    }
}
