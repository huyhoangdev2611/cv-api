package com.example.cv_backend.model.request;

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
public class UpdateUserRequest {
    private String name;
    private String phone;
    private LocalDate birthDay;
    private String description;
    private String email;
    private String image;
    private List<Long> SkillsId;
}
