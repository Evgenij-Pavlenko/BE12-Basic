package com.pavlenko.contactsonepager.service;

import com.pavlenko.contactsonepager.model.Contact;
import com.pavlenko.contactsonepager.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact create(String name, String lastName, int age) {
        Contact contact = new Contact(name, lastName, age);
        contactRepository.save(contact);
        return contact;
    }

    public List<Contact> getAll(){
        List<Contact> res = new ArrayList<>();
        contactRepository.findAll().forEach(res::add);
        return res;
    }
    public Contact get(int id){
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElseThrow(EntityNotFoundException::new);
    }
}
