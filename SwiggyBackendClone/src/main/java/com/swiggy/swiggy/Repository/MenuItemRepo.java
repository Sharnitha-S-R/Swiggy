package com.swiggy.swiggy.Repository;
import com.swiggy.swiggy.Entity.MenuItem;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.swiggy.swiggy.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAll();
    List<MenuItem> findByItemNameContainingIgnoreCase(String itemName);
    List<MenuItem> findByPriceBetween(double minPrice, double maxPrice);
    List<MenuItem> findByCategoryIgnoreCase(String category);
    List<MenuItem> findByIngredientsContainingIgnoreCase(String ingredients);
}
