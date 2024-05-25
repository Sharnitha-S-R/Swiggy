package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.DeliveryPerson;
import com.swiggy.swiggy.Entity.Order;
import com.swiggy.swiggy.Entity.OrderStatus;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Service.DeliveryPersonService;
import com.swiggy.swiggy.Service.OrderService;
import com.swiggy.swiggy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService; // Inject UserService
    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws Exception {
        Order placedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        try {
            orderService.updateOrderStatus(orderId, status);
            return new ResponseEntity<>("Order status updated successfully", HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update order status", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (com.swiggy.swiggy.Service.OrderNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }

        List<Order> orders = orderService.getOrdersByUser(user);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }



}
