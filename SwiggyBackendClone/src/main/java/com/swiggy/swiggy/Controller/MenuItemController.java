package com.swiggy.swiggy.Controller;

import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/addMenuItem/{userId}")
    private String addMenuItem(@PathVariable int userId, @RequestBody MenuItem menuItem) {
        menuItemService.addMenu(userId, menuItem);
        return "Menu item added successfully";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsForRestaurant(@PathVariable Long restaurantId, @RequestParam int userId) {
        return menuItemService.getMenuItemsForRestaurant(userId, restaurantId);
    }

    @DeleteMapping("/delete/{userId}/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(
            @PathVariable("userId") int userId,
            @PathVariable("menuItemId") long menuItemId) {

        try {
            menuItemService.deleteMenuItem(userId, menuItemId);
            return ResponseEntity.ok("Menu item deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
