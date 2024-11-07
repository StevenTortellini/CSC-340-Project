// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.entities.User;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
        service.addNewUser(user);
        return getUserById(user.getUserId());
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User userDetails) {
        service.updateUser(id, userDetails);
        return getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
    }
}