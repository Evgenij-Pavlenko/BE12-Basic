package com.pavlenko.contacts.service;

import com.pavlenko.contacts.model.Contact;
import com.pavlenko.contacts.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void create(Contact contact) {
        contactRepo.save(contact);
    }

    public void edit(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        return contactRepo.remove(id);
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }
}
