package com.example.cv_backend.model.response;

import com.example.cv_backend.entity.Skill;
import com.example.cv_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private LocalDate birthDay;
    private String email;
    private String phone;
    private String image;
    private String description;
    private List<Long> skillsId;

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .birthDay(user.getBirthDay())
                .email(user.getEmail())
                .phone(user.getPhone())
                .image(user.getImage())
                .description(user.getDescription())
                .skillsId(user.getSkills().stream().map(Skill::getId).collect(Collectors.toList()))
                .build();
    }
}
