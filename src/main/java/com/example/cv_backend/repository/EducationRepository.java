package com.example.cv_backend.repository;

import com.example.cv_backend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
