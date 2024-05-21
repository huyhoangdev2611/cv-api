package com.example.cv_backend.repository;

import com.example.cv_backend.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByIdIn(List<Long> ids);
}
