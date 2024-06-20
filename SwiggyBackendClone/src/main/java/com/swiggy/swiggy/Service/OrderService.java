package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Entity.Order;
import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Repository.MenuItemRepo;
import com.swiggy.swiggy.Repository.OrderRepo;

import com.swiggy.swiggy.Repository.RestaurantRepo;
import com.swiggy.swiggy.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;

    public Order placeOrder(int userId, Order order) {
        if (userService.isUserLoggedIn(userId)) {
            // Fetch user, restaurant, and menu item to ensure they exist
            Optional<User> userOpt = userRepo.findById(order.getUser().getId());
            Optional<Restaurant> restaurantOpt = restaurantRepo.findById(order.getRestaurant().getRestaurantId());
            Optional<MenuItem> menuItemOpt = menuItemRepo.findById(order.getMenuItem().getId());

            if (userOpt.isPresent() && restaurantOpt.isPresent() && menuItemOpt.isPresent()) {
                order.setUser(userOpt.get());
                order.setRestaurant(restaurantOpt.get());
                order.setMenuItem(menuItemOpt.get());
                return orderRepo.save(order);
            } else {
                throw new IllegalArgumentException("User, Restaurant, or MenuItem not found.");
            }
        } else {
            throw new IllegalArgumentException("User must be logged in to create an order.");
        }
    }
    public Order updateOrder(int userId, Long orderId, Order updatedOrder) {
        if (userService.isUserLoggedIn(userId)) {
            Optional<Order> existingOrderOpt = orderRepo.findById(orderId);

            if (existingOrderOpt.isPresent()) {
                Order existingOrder = existingOrderOpt.get();

                // Update the order details
                existingOrder.setUser(updatedOrder.getUser());
                existingOrder.setRestaurant(updatedOrder.getRestaurant());
                existingOrder.setMenuItem(updatedOrder.getMenuItem());
                existingOrder.setQuantity(updatedOrder.getQuantity());
                existingOrder.setPrice(updatedOrder.getPrice());
                existingOrder.setStatus(updatedOrder.getStatus());
                existingOrder.setTotalAmount(updatedOrder.getTotalAmount());

                return orderRepo.save(existingOrder);
            } else {
                throw new IllegalArgumentException("Order not found");
            }
        } else {
            throw new IllegalArgumentException("User must be logged in to update the order.");
        }
    }

    public void cancelOrder(int userId, Long orderId) {
        if (userService.isUserLoggedIn(userId)) {
            Optional<Order> orderOptional = orderRepo.findById(orderId);
            if (orderOptional.isPresent()) {
                Order order = orderOptional.get();
                // Add logic for cancellation (example: updating status to Cancelled)
                order.setStatus("Cancelled");
                orderRepo.save(order);
            } else {
                throw new IllegalArgumentException("Order not found");
            }
        } else {
            throw new IllegalArgumentException("User must be logged in to cancel the order.");
        }
    }


    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public void deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}

