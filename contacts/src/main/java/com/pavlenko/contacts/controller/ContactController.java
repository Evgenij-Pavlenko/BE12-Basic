package com.pavlenko.contacts.controller;

import com.pavlenko.contacts.model.Contact;
import com.pavlenko.contacts.service.ContactService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contactsList", contacts);
        return "contacts";
    }

    @GetMapping("/contacts/{id}")
    public String getContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contactsList", contact);
        return "contacts";
    }

    @PutMapping("/contacts")
    public String editContact(@ModelAttribute("contact") Contact contact) {
        contactService.edit(contact);
        return "contacts";
    }

    @DeleteMapping("/contacts/{id}/delete")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "contacts";
    }

    @GetMapping("contacts/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";

    }

    @PostMapping("contact/save")
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.create(contact);
        return "redirect:/contacts";

    }

}
