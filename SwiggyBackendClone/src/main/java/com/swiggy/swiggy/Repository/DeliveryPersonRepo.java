package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryPersonRepo extends JpaRepository<DeliveryPerson,Long>{
    List<DeliveryPerson> findAll();

}
