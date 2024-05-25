package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.DeliveryPerson;
import com.swiggy.swiggy.Service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveryperson")
public class DeliveryPersonController {

        @Autowired
        private DeliveryPersonService deliveryPersonService;



    @PostMapping("/add")
    public ResponseEntity<DeliveryPerson> addDeliveryPerson(@RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson savedDeliveryPerson = deliveryPersonService.saveDeliveryPerson(deliveryPerson);
        return new ResponseEntity<>(savedDeliveryPerson, HttpStatus.CREATED);
    }

    }


