package com.example.cv_backend.model.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProjectRequest {
    private String name;
    private String members;
    private String describe;
    private List<Long> skillIds;
    private String task;
}
