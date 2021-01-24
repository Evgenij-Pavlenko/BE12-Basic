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

    @GetMapping("contacts")
    public String getAll(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contactsList", contacts);
        return "contacts";
    }

    @GetMapping("contacts/{id}")
    public String getContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping("contacts/{id}/edit")
    public String editContactForm(@PathVariable int id, Model model) {
        Contact theContact = contactService.get(id);
        model.addAttribute("contact", theContact);
        return "contact-form";
    }

    @GetMapping("contacts/{id}/delete")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping("contacts/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";

    }

    @PostMapping("contact/save")
    public String saveContact(@ModelAttribute Contact contact) {
        if (contact.getId() > 0)
            contactService.edit(contact);
        else
            contactService.create(contact);
        return "redirect:/contacts";
    }

    @GetMapping("")
    public String home(){
        return "redirect:/contacts";
    }

}
