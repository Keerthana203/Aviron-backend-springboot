package com.avironlearning.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_requests")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String grade;
    private String phone;
    private String email;
    private String curriculum;
    
    @Column(length = 500)
    private String message;
}
