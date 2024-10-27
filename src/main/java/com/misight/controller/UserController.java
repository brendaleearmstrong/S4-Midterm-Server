package com.misight.controller;

import com.misight.model.Mineral;
import com.misight.model.User;
import com.misight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping("/users/register")
    //Register
    public ResponseEntity<User> registerUser(@RequestBody User user){
        try{
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping("/users")
    //Get all users
    public List<User> getUsers(){ return userService.getAllUsers();}

    @GetMapping("/users/{user_id}")
    //Get specific user
    public Optional<User> getUserById(@PathVariable("user_id") Integer user_id){
        return userService.getUserById(user_id);
    }

    @PutMapping("/users/{user_id}")
    //Update user
    public User updateUser(@PathVariable("user_id") Integer user_id, @RequestBody Map<String, String> body){
        User currentUser = userService.getUserById(user_id).get();
        try {
            currentUser.setUsername(body.get("username"));
            currentUser.setPassword(body.get("password"));
            currentUser.setRole(body.get("role"));
            userService.registerUser(currentUser);
            return currentUser;
        }
        catch(Exception e){
            return currentUser;
        }
    }

    @DeleteMapping("/users/{user_id}")
    //Delete user
    public boolean deleteUser(@PathVariable("user_id") Integer user_id){
        if(!userService.findById(user_id).equals(Optional.empty())){
            userService.deluser(user_id);
            return true;
        }
        return false;
    }

}
