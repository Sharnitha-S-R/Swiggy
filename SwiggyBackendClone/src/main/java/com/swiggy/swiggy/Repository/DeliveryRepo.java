package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}

