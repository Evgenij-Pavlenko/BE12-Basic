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

    Map<Integer,Contact> source;

    public InMemoryContactRepo(Map<Integer, Contact> source) {
        this.source = source;
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
        if (contact.getId()==0){
            contact.setId(lastKey);
            source.put(lastKey, contact);
        } else{
            source.put(contact.getId(),contact);
        }

    }

    @Override
    public Contact remove(int id) {
        Contact contact = find(id);
        source.remove(id);
        return contact;
    }
}
