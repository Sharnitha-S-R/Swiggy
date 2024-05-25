package com.swiggy.swiggy.Service;

import java.util.List;
import java.util.Optional;

import com.swiggy.swiggy.Entity.*;
import com.swiggy.swiggy.Repository.DeliveryPersonRepo;
import com.swiggy.swiggy.Repository.MenuItemRepo;
import com.swiggy.swiggy.Repository.OrderRepo;
import com.swiggy.swiggy.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private MenuItemRepo menuItemRepo; // Assuming you have a MenuItemRepository
    
    public Order placeOrder(Order order) throws Exception {

        validateOrder(order);
        updateStockLevels(order.getItems());
        return orderRepo.save(order);
    }


    private void validateOrder(Order order) throws Exception {

    }

    private void updateStockLevels(List<MenuItem> items) throws Exception {

    }



    public void updateOrderStatus(Long orderId, OrderStatus status) throws OrderNotFoundException {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(status);
            orderRepo.save(order); // Update the order status in the database
        } else {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
    }
    public List<Order> getOrdersByUser(User user) {
        return orderRepo.findByUserId(user);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepo.findById(orderId);
    }



}
