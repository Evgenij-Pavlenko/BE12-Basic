package com.pavlenko.contactsonepager.repository;

import com.pavlenko.contactsonepager.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
