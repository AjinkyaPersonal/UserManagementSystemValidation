package com.geekster.UserManagementSystemValidations11.controller;

import com.geekster.UserManagementSystemValidations11.model.User;
import com.geekster.UserManagementSystemValidations11.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "UserManagementSystem")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "addUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(value = "getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "getUser/{userId}")
    public User getUserById(@PathVariable String userId){

        return userService.getUserById(userId);
    }

    @PutMapping(value = "updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable String userId , @RequestBody User user){
        return userService.updateUserInfo(userId , user);

    }

    @DeleteMapping(value = "/deleteUser/{userid}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUser(userId);
    }


}
