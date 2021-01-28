package com.pavlenko.contacts.repository;

import com.pavlenko.contacts.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;

// And make test
@Repository
public class InMemoryContactRepo implements IContactRepo {

    private Map<Integer, Contact> source = new HashMap<>();
    private int lastUsedId;

    @PostConstruct
    private void loadData() {
        source.put(1, new Contact(1, "Ivan", "Ivanov", 20));
        source.put(2, new Contact(2, "Petr", "Petrov", 40));
        source.put(3, new Contact(3, "John", "Jonson", 30));
        lastUsedId = source.size();
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
        int id = contact.getId();
        if (id == 0) {
            contact.setId(++lastUsedId);
            source.put(lastUsedId, contact);
        } else if (source.containsKey(id)) {
            source.put(id, contact);
        } else {
            throw new ContactNotFoundException();
        }
    }

    @Override
    public Contact remove(int id) {
        return source.remove(id);
    }
}
