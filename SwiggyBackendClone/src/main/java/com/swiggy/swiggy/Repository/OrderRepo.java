package com.swiggy.swiggy.Repository;
import com.swiggy.swiggy.Entity.DeliveryPerson;
import com.swiggy.swiggy.Entity.Order;
import com.swiggy.swiggy.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
    public interface OrderRepo extends JpaRepository<Order, Long> {
        List<Order> findByUserId(User user);


}


