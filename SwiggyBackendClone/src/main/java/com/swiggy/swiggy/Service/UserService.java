package com.swiggy.swiggy.Service;
import com.swiggy.swiggy.Entity.User;
import com.swiggy.swiggy.Enum.Role;
import com.swiggy.swiggy.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


import static com.swiggy.swiggy.Enum.Role.*;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private Map<Integer, String> loggedInUsers = new HashMap<>();


    private Map<Integer, String> Users = new HashMap<>();
    private Map<Integer, String> adminUsers = new HashMap<>();
    private Map<Integer, String> adminEmployee = new HashMap<>();
    private Map<Integer, String> adminRestaurant = new HashMap<>();
    private Map<Integer, String> Delivery = new HashMap<>();



    public User createUser(User user) {
        if (user.getRole() == Role.USER) {
            User savedUser = userRepo.save(user);
            System.out.println("Profile saved: " + savedUser);
            return savedUser;
        } else {
            throw new IllegalArgumentException("Profile creation is only allowed for ProfileType.USER");
        }
    }

    public User createAdmin(User user) {
        if (user.getRole() == Role.ADMIN) {
            User savedAdmin = userRepo.save(user);
            System.out.println("Admin Saved:" + savedAdmin);
            return savedAdmin;
        } else {
            throw new IllegalArgumentException("Profile creation is only allowed for ProfileType.ADMIN");
        }
    }

    public User createEmployee(User user) {
        if (user.getRole() == Role.EMPLOYEE) {
            User savedEmployee = userRepo.save(user);
            System.out.println("Employee Saved:" + savedEmployee);
            return savedEmployee;
        } else {
            throw new IllegalArgumentException("Admins can only create employee profile");
        }

    }

    public User createRestaurantAdmin(User user) {
        if (user.getRole() == Role.RES_ADMIN) {
            User savedRestaurantAdmin = userRepo.save(user);
            System.out.println("Employee Saved:" + savedRestaurantAdmin);
            return savedRestaurantAdmin;
        } else {
            throw new IllegalArgumentException("Admins can only create employee profile");
        }
    }

    public User createDeliveryPerson(User user) {
        if (user.getRole() == Role.DEL_PERSON) {
            User savedDeliveryPerson = userRepo.save(user);
            System.out.println("DeliveryPerson Saved:" + savedDeliveryPerson);
            return savedDeliveryPerson;
        } else {
            throw new IllegalArgumentException("Admins can only create Delivery Person profile");
        }
    }


    public String Login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            Role role = user.getRole();
            int UserId = user.getId();
            switch (role) {
                case ADMIN:
                    adminUsers.put(UserId, email);
                    break;
                case EMPLOYEE:
                    adminEmployee.put(UserId, email);
                    break;
                case USER:
                    Users.put(UserId, email);
                    break;
                case RES_ADMIN:
                    adminRestaurant.put(UserId, email);
                    break;
                case DEL_PERSON:
                    Delivery.put(UserId, email);
                    break;

                default:
                    return "Invalid profile type for this login";
            }
            loggedInUsers.put(UserId, email);
            return role + " login successful!";
        } else {
            return "Invalid email or password for other login";
        }
    }


        public String logout(int userId){
        if(loggedInUsers.containsKey(userId)){
            loggedInUsers.remove(userId);
            adminUsers.remove(userId);
            adminEmployee.remove(userId);
            adminRestaurant.remove(userId);
            Delivery.remove(userId);
            return "Logout successful!";
        }else{
            return "User is not logged in";
        }
    }

    public Map<Integer, String> getLoggedInUsers()
    {
        return new HashMap<>(loggedInUsers);
    }

    public Map<Integer, String> getAdminEmployee()
    {
        return new HashMap<>(adminEmployee);
    }

    public Map<Integer, String> getAdminUser()
    {
        return new HashMap<>(adminUsers);
    }

    public Map<Integer, String> getUsers()
    {
        return new HashMap<>(Users);
    }
    public Map<Integer, String> getAdminRestaurant()
    {
        return new HashMap<>(adminRestaurant);
    }
    public Map<Integer, String> getDelivery()
    {
        return new HashMap<>(Delivery);
    }


    public boolean isUserLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId);
    }
    public boolean isDeliveryPersonLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId);
    }
    public boolean isEmployeeLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId) && adminEmployee.containsKey(userId);
    }
    public boolean isAdminLoggedIn(int userId)
    {
        return loggedInUsers.containsKey(userId) && adminUsers.containsKey(userId);
    }
    public boolean isCustomerLoggedIn(int userId)
    {
        return loggedInUsers.containsKey(userId) && Users.containsKey(userId);
    }
    public boolean isRestaurantAdminLoggedIn(int userId)
    {
        return loggedInUsers.containsKey(userId) && adminRestaurant.containsKey(userId);
    }


    public boolean isEmpRestaurant(int userId) {
        return loggedInUsers.containsKey(userId) && (adminEmployee.containsKey(userId) || adminRestaurant.containsKey(userId));
}



    public User getUserById(int Id){
        return userRepo.getById(Id);
    }
}
