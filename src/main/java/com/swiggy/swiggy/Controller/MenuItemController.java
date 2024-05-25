package com.swiggy.swiggy.Controller;
import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Entity.Restaurant;
import com.swiggy.swiggy.Service.MenuItemService;
import com.swiggy.swiggy.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    private final MenuItemService menuItemService;
    private final RestaurantService restaurantService;

    public MenuItemController(MenuItemService menuItemService, RestaurantService restaurantService) {
        this.menuItemService = menuItemService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem, @RequestParam String restaurantId) {
        // Convert the restaurantId from String to Integer
        Integer restaurantIdInt = Integer.parseInt(restaurantId);

        // Fetch the restaurant by its ID
        Optional<Restaurant> optionalRestaurant = restaurantService.getRestaurantById(restaurantIdInt.longValue());

        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            menuItem.setRestaurant(restaurant); // Associate the restaurant with the menu item
            MenuItem savedMenuItem = menuItemService.saveMenuItem(menuItem);
            return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Restaurant not found
        }
    }

    @DeleteMapping("/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long menuItemId) {
        try {
            menuItemService.deleteMenuItem(menuItemId);
            return new ResponseEntity<>("Menu item deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete menu item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<MenuItem>> searchMenuItems(@RequestParam(required = false) String itemName,
                                                          @RequestParam(required = false) Double minPrice,
                                                          @RequestParam(required = false) Double maxPrice,
                                                          @RequestParam(required = false) String category,
                                                          @RequestParam(required = false) String ingredients) {
        List<MenuItem> menuItems = menuItemService.searchMenuItems(itemName, minPrice, maxPrice, category, ingredients);
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }
}
