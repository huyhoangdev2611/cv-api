package com.example.cv_backend.controller;

import com.example.cv_backend.model.request.CreateSkillRequest;
import com.example.cv_backend.model.request.UpdateSkillRequest;
import com.example.cv_backend.model.response.skillResponse;
import com.example.cv_backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<skillResponse> getSkills() {
        return skillService.getAllSkill();
    }

    @GetMapping({"/{id}"})
    public skillResponse getSkill(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping
    public skillResponse createSkill(@RequestBody CreateSkillRequest request) {
        return skillService.createSkillRequest(request);
    }

    @PutMapping({"/{id}"})
    public skillResponse updateSkill(@PathVariable Long id, @RequestBody UpdateSkillRequest updateSkillRequest) {
        return skillService.updateSkill(id, updateSkillRequest);
    }

    @DeleteMapping({"/{id}"})   
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }


}
