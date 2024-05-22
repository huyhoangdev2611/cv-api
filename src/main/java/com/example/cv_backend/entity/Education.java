package com.example.cv_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name ="educations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degree;
    private String institution;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;
}
