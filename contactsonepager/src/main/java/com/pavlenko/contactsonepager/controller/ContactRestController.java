package com.pavlenko.contactsonepager.controller;

import com.pavlenko.contactsonepager.dto.ContactDto;
import com.pavlenko.contactsonepager.model.Contact;
import com.pavlenko.contactsonepager.service.ContactService;
import org.hibernate.mapping.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/contacts")
public class ContactRestController {

    final ContactService contactService;

    public ContactRestController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ContactDto create(@RequestBody ContactDto contactDto) {
        Contact contact = contactService.create(
                contactDto.name,
                contactDto.lastName,
                contactDto.age);

        contactDto.id = contact.getId();
        return contactDto;
    }

    @GetMapping("{id}")
    public ContactDto get(@PathVariable int id) {
        Contact contact = contactService.get(id);

        return new ContactDto(
                contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getAge()
        );
    }

    @GetMapping
    public List<ContactDto> getAll() {
        List<Contact> contacts = contactService.getAll();
        return contacts.stream().map(contact ->
                new ContactDto(contact.getId(), contact.getName(), contact.getLastName(), contact.getAge()))
                .collect(Collectors.toList());
    }

    @PutMapping
    // not necessary
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit(@RequestBody ContactDto contactDto) {
        contactService.edit(
                contactDto.id,
                contactDto.name,
                contactDto.lastName,
                contactDto.age);
    }

    @DeleteMapping("{id}")
    public ContactDto remove(@PathVariable int id) {
        Contact contact = contactService.remove(id);
        return new ContactDto(
                contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getAge()
        );
    }
}