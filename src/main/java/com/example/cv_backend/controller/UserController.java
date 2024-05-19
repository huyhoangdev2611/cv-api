package com.example.cv_backend.controller;

import com.example.cv_backend.model.request.CreateUserRequest;
import com.example.cv_backend.model.request.UpdateUserRequest;
import com.example.cv_backend.model.request.UserResponse;
import com.example.cv_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {

        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping({"/{id}"})
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping({"/{id}"})
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping({"/{id}"})
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
