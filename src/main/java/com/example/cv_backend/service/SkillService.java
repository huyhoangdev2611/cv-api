package com.example.cv_backend.service;

import com.example.cv_backend.entity.Skill;
import com.example.cv_backend.model.request.CreateSkillRequest;
import com.example.cv_backend.model.request.UpdateSkillRequest;
import com.example.cv_backend.model.response.skillResponse;
import com.example.cv_backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public skillResponse createSkillRequest(CreateSkillRequest createSkillRequest) {
        Skill skill = Skill.builder()
                .name(createSkillRequest.getName())
                .build();

        Skill savedSkill = skillRepository.save(skill);

        return skillResponse.builder()
                .id(savedSkill.getId())
                .name(savedSkill.getName())
                .build();
    }

    public List<skillResponse> getAllSkill() {
        List<Skill> skillReponses = skillRepository.findAll();
        return skillReponses.stream()
                .map(skill -> skillResponse.builder()
                        .id(skill.getId())
                        .name(skill.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public skillResponse getSkillById(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return skillResponse.builder()
                .id(skill.getId())
                .name(skill.getName())
                .build();
    }

    public skillResponse updateSkill(Long id, UpdateSkillRequest request) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        skill.setName(request.getName());


        Skill updatedSkill = skillRepository.save(skill);

        return skillResponse.builder()
                .name(updatedSkill.getName())
                .build();
    }

    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        skillRepository.delete(skill);
    }
}
