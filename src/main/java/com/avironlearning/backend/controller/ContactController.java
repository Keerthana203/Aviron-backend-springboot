package com.avironlearning.backend.controller;

import com.avironlearning.backend.dto.ContactRequestDto;
import com.avironlearning.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // React dev server
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public String submitContactForm(@RequestBody ContactRequestDto contactRequest) {
        contactService.saveContact(contactRequest);
        contactService.sendEmail(contactRequest);
        return "Contact form submitted successfully.";
    }
}
