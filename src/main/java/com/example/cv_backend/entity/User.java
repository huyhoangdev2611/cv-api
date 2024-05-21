package com.example.cv_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDay;
    private String email;
    private String phone;
    private String image;
    private String skillsId;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToMany(mappedBy = "users")
    private List<Skill> skills;


}
