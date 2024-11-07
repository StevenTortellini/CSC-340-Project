package com.youselldatabase.youselldatabase.service;


import com.youselldatabase.youselldatabase.entities.User;
import com.youselldatabase.youselldatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public User getUserById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewUser(User user){
        repo.save(user);
    }

    public void updateUser(int id, @org.jetbrains.annotations.NotNull User user){
        repo.save(user);
    }

    public List<User> deleteUserById(int id){
        repo.deleteById(id);
        return repo.findAll();
    }

}
