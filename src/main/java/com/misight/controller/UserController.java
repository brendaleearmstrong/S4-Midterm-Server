// File: src/main/java/com/misight/controller/UserController.java
package com.misight.controller;

import com.misight.model.User;
import com.misight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public Optional<User> getUserById(@PathVariable("user_id") Integer user_id) {
        return userService.getUserById(user_id);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") Integer user_id,
                                           @RequestBody User user) {
        try {
            User currentUser = userService.getUserById(user_id).get();
            currentUser.setUsername(user.getUsername());
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                currentUser.setPassword(user.getPassword());
            }
            if (user.getRole() != null) {
                currentUser.setRole(user.getRole());
            }

            userService.registerUser(currentUser);
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{user_id}")
    public boolean deleteUser(@PathVariable("user_id") Integer user_id) {
        if (!userService.findById(user_id).equals(Optional.empty())) {
            userService.deluser(user_id);
            return true;
        }
        return false;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.findByUsername(loginRequest.getUsername());
        if (user.isPresent() && user.get().verifyPassword(loginRequest.getPassword())) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
    }

    private static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}