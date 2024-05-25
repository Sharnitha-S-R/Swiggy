package com.swiggy.swiggy.Controller;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());
        return isAuthenticated ? "Login successful" : "Login failed";
    }

    @PostMapping("/logout")
    public String logout(@RequestBody User user) {
        boolean isLoggedOut = userService.logoutUser(user.getUsername());
        if (isLoggedOut){
            return "Logout successful.";
        }
        else{
            return "Logout failed.";
        }
    }
}
