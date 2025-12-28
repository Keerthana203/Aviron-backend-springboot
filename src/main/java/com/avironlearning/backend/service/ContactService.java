package com.avironlearning.backend.service;

import com.avironlearning.backend.dto.ContactRequestDto;
import com.avironlearning.backend.model.Contact;
import com.avironlearning.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(ContactRequestDto request) {
        Contact contact = new Contact();
        contact.setStudentName(request.getStudentName());
        contact.setGrade(request.getGrade());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());
        contact.setCurriculum(request.getCurriculum());
        contact.setMessage(request.getMessage());

        contactRepository.save(contact);
        System.out.println("Saved to DB: " + request.getStudentName());
    }

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactRequestDto request) {
        String organizerEmail = "avironlearning@gmail.com"; // your receiving email

        String subject = "New Admission Inquiry from: " + request.getStudentName();
        String messageBody = "Student Name: " + request.getStudentName() + "\n" +
                "Grade: " + request.getGrade() + "\n" +
                "Phone: " + request.getPhone() + "\n" +
                "Email: " + request.getEmail() + "\n" +
                "Curriculum: " + request.getCurriculum() + "\n" +
                "Message: " + request.getMessage();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(organizerEmail);
        message.setSubject(subject);
        message.setText(messageBody);

        mailSender.send(message);

        System.out.println("Email sent to organizer: " + organizerEmail);
    }

}
