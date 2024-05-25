package com.swiggy.swiggy.Service;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepo.findByUsername(username).orElse(null);
        return user != null && user.getPassword().equals(password);
    }

    public boolean logoutUser(String username){
        User user = userRepo.findByUsername(username).orElse(null);
        if(user != null){
            user.setLastLogout(LocalDateTime.now());
            userRepo.save(user);
            return true;
        }
        else{
            return false;
        }

    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);

    }
}
