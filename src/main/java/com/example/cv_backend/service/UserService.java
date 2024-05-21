package com.example.cv_backend.service;

import com.example.cv_backend.entity.Skill;
import com.example.cv_backend.entity.User;
import com.example.cv_backend.model.request.CreateUserRequest;
import com.example.cv_backend.model.request.UpdateUserRequest;
import com.example.cv_backend.model.response.UserResponse;
import com.example.cv_backend.repository.SkillRepository;
import com.example.cv_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    public UserResponse createUser(CreateUserRequest request) {
        List<Skill> skills = skillRepository.findByIdIn(request.getSkillIds());
        User user = User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .birthDay(request.getBirthDay())
                .description(request.getDescription())
                .email(request.getEmail())
                .image(request.getImage())
                .skills(skills)
                .build();

        User savedUser = userRepository.save(user);
        return UserResponse.fromEntity(savedUser);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponse.fromEntity(user);
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Skill> skills = skillRepository.findByIdIn(request.getSkillsId());

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setBirthDay(request.getBirthDay());
        user.setDescription(request.getDescription());
        user.setEmail(request.getEmail());
        user.setImage(request.getImage());
        user.setSkills(skills);

        User updatedUser = userRepository.save(user);
        return UserResponse.fromEntity(updatedUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
