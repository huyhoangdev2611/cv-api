package com.example.cv_backend.model.response;

import com.example.cv_backend.entity.Project;
import com.example.cv_backend.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.stream.Collectors;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {
    private Long id;
    private String name;
    private String members;
    private String describe;

    private List<String> skillsName;

    private String task;
    public static ProjectResponse fromEntity(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .members(project.getMembers())
                .describe(project.getDescribe())
                .skillsName(project.getSkills().stream().map(Skill::getName).collect(Collectors.toList()))
                .task(project.getTask())
                .build();
    }
}
