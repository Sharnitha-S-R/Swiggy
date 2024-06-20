package com.swiggy.swiggy.Controller;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PostMapping("/createAdmin")
    public User createAdmin(@RequestBody User user)
    {
        return userService.createAdmin(user);
    }

    @PostMapping("/createEmployee")
    public User createEmployee(@RequestBody User user)
    {
        return userService.createEmployee(user);
    }
    @PostMapping("/createRestaurantAdmin")
    public User createRestaurantAdmin(@RequestBody User user)
    {
        return userService.createRestaurantAdmin(user);
    }




    @PostMapping("/login")
    public String otherLogin(@RequestBody User loginUser)
    {
        return userService.Login(loginUser.getEmail(), loginUser.getPassword());
}
    @PostMapping("/logout")
    public String logout(@RequestBody User user) {
        return userService.logout(user.getId());
    }

    @GetMapping("/getLoggedInUsers")
    public Map<Integer, String> getLoggedInUsers()
    {
        return userService.getLoggedInUsers();
    }

    @GetMapping("/getAdminUser")
    public Map<Integer, String> getAdminUser() {
        return userService.getAdminUser();
    }

    @GetMapping("/getAdminEmployees")
    public Map<Integer, String> getAdminEmployee() {
        return userService.getAdminEmployee();
    }

    @GetMapping("/getUsers")
    public Map<Integer, String> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getRestaurantAdmin")
    public Map<Integer, String> getRestaurantAdmin() {
        return userService.getAdminRestaurant();
    }


    }
