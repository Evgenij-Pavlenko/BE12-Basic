package com.pavlenko.contacts.controller;

import com.pavlenko.contacts.model.Contact;
import com.pavlenko.contacts.service.ContactService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ContactController {
    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String getAll(Model model) {
        //TODO return back this code
//        List<Contact> contacts = contactService.getAll();
        //TODO comment out this code
        List<Contact> contacts = Arrays.asList(new Contact(1, "Vasja", "Vasiljev", 20),
                new Contact(2, "Petje", "Petrov", 25)
        );
        model.addAttribute("contactsList", contacts);
        return "contacts";
    }
}
