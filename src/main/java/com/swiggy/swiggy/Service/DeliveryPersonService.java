package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.DeliveryPerson;
import com.swiggy.swiggy.Repository.DeliveryPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPersonService {


        @Autowired
        private DeliveryPersonRepo deliveryPersonRepo;

        public DeliveryPerson saveDeliveryPerson(DeliveryPerson deliveryPerson) {
            return deliveryPersonRepo.save(deliveryPerson);
        }

    public Optional<DeliveryPerson> getDeliveryPersonById(Long deliveryPersonId) {
            return deliveryPersonRepo.findById(deliveryPersonId);
    }


    // Other methods for managing delivery personnel
    }


