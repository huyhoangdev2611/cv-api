package com.example.cv_backend.model.request;

import com.example.cv_backend.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private List<Skill> skills;
}
