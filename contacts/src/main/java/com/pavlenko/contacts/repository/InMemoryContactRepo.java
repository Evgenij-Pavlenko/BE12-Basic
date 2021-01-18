package com.pavlenko.contacts.repository;

import com.pavlenko.contacts.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

// And make test
@Repository
public class InMemoryContactRepo implements IContactRepo {

    Map<Integer, Contact> source;

    @Autowired
    public InMemoryContactRepo(Map<Integer, Contact> source) {
        this.source = source;
    }

    @PostConstruct
    private void loadData(){
        source.put(1, new Contact(1, "Ivan", "Ivanov", 20));
        source.put(2, new Contact(2, "Petr", "Petrov", 40));
        source.put(3, new Contact(3, "John", "Jonson", 30));
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(source.values());
    }

    @Override
    public Contact find(int id) {
        return source.get(id);
    }

    @Override
    public void save(Contact contact) {
        int lastKey = source.keySet().stream().mapToInt(v -> v).max().getAsInt();
        lastKey++;
        if (contact.getId() == 0) {
            contact.setId(lastKey);
            source.put(lastKey, contact);
        } else {
            source.put(contact.getId(), contact);
        }

    }

    @Override
    public Contact remove(int id) {
        Contact contact = find(id);
        source.remove(id);
        return contact;
    }
}
