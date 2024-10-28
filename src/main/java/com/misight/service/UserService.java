package com.misight.service;

import com.misight.model.User;
import com.misight.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }

    public void deluser(Integer id) {
        userRepo.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
}