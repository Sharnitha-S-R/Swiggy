package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.Order;
import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeorder/{userId}")
    private String placeOrder(@PathVariable("userId") int userId, @RequestBody Order order)
    {
        orderService.placeOrder(userId, order);
        return "Order added successfully";
    }

    @PutMapping("/updateorder/{userId}/{orderId}")
    public String updateOrder(@PathVariable("userId") int userId, @PathVariable("orderId") Long orderId, @RequestBody Order order) {
        orderService.updateOrder(userId, orderId, order);
        return "Order updated successfully";
    }

    @PutMapping("/cancelorder/{userId}/{orderId}")
    public String cancelOrder(@PathVariable("userId") int userId, @PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(userId, orderId);
        return "Order cancelled successfully";
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "Order deleted successfully";
    }


}

//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable int customerId) {
//        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
//        return ResponseEntity.ok(orders);
//    }
//
//    @GetMapping("/restaurant/{restaurantId}")
//    public ResponseEntity<List<Order>> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
//        List<Order> orders = orderService.getOrdersByRestaurantId(restaurantId);
//        return ResponseEntity.ok(orders);
//    }
//
//    @GetMapping("/{orderId}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
//        Optional<Order> order = orderService.getOrderById(orderId);
//        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/updateStatus/{orderId}")
//    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestBody String status) {
//        try {
//            Order updatedOrder = orderService.updateOrderStatus(orderId, status);
//            return ResponseEntity.ok(updatedOrder);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @DeleteMapping("/{orderId}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
//        orderService.deleteOrder(orderId);
//        return ResponseEntity.noContent().build();
//    }
//}
