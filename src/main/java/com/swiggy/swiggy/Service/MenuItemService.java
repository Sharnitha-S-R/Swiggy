package com.swiggy.swiggy.Service;
import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Repository.MenuItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import java.util.Optional;

@Service
public class MenuItemService  {
    @Autowired
    private MenuItemRepo menuItemRepo;



    public MenuItem saveMenuItem(MenuItem menuItem){
        return menuItemRepo.save(menuItem);
    }
    public void deleteMenuItem(Long menuItemId) {
        menuItemRepo.deleteById(menuItemId);
    }


    public List<MenuItem> searchMenuItems(String itemName, Double minPrice, Double maxPrice, String category, String ingredients) {
        if (itemName != null) {
            return menuItemRepo.findByItemNameContainingIgnoreCase(itemName);
        } else if (Objects.equals(minPrice, null) && Objects.equals(maxPrice, null)) {
            return menuItemRepo.findByPriceBetween(minPrice, maxPrice);
        } else if (category != null) {
            return menuItemRepo.findByCategoryIgnoreCase(category);
        } else if (ingredients != null) {
            return menuItemRepo.findByIngredientsContainingIgnoreCase(ingredients);
        } else {
            return menuItemRepo.findAll();
        }
    }

}
