package com.example.cv_backend.service;

import com.example.cv_backend.entity.User;
import com.example.cv_backend.model.request.CreateUserRequest;
import com.example.cv_backend.model.request.UpdateUserRequest;
import com.example.cv_backend.model.request.UserResponse;
import com.example.cv_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .birthDay(request.getBirthDay())
                .description(request.getDescription())
                .email(request.getEmail())
                .image(request.getImage())
                .build();

        User savedUser = userRepository.save(user);
        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .phone(savedUser.getPhone())
                .birthDay(savedUser.getBirthDay())
                .description(savedUser.getDescription())
                .email(savedUser.getEmail())
                .image(savedUser.getImage())
                .skills(savedUser.getSkills())
                .build();
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .phone(user.getPhone())
                        .birthDay(user.getBirthDay())
                        .description(user.getDescription())
                        .email(user.getEmail())
                        .image(user.getImage())
                        .skills(user.getSkills())
                        .build())
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .birthDay(user.getBirthDay())
                .description(user.getDescription())
                .email(user.getEmail())
                .image(user.getImage())
                .skills(user.getSkills())
                .build();
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setBirthDay(request.getBirthDay());
        user.setDescription(request.getDescription());
        user.setEmail(request.getEmail());
        user.setImage(request.getImage());

        User updatedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(updatedUser.getId())
                .name(updatedUser.getName())
                .phone(updatedUser.getPhone())
                .birthDay(updatedUser.getBirthDay())
                .description(updatedUser.getDescription())
                .email(updatedUser.getEmail())
                .image(updatedUser.getImage())
                .skills(updatedUser.getSkills())
                .build();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

}
