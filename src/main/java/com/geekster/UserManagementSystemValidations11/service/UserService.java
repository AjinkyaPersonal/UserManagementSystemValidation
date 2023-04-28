package com.geekster.UserManagementSystemValidations11.service;

import com.geekster.UserManagementSystemValidations11.model.User;
import com.geekster.UserManagementSystemValidations11.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public  List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public String addUser(User user) {
        return userRepo.addUser(user);
    }

    public User getUserById(String userId) {
        return userRepo.getUserById(userId);
    }

    public String updateUserInfo(String userId ,  User user) {

        return userRepo.updateUserInfo(userId , user);

    }

    public String deleteUser(String userId) {
        return userRepo.deleteUser(userId);
    }
}
