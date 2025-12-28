package com.avironlearning.backend.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContactRequestDto {

    @JsonProperty("student_name")
    private String studentName;

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("curriculum")
    private String curriculum;

    @JsonProperty("message")
    private String message;

    // getters and setters
}



