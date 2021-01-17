package com.pavlenko.contacts.config;

import com.pavlenko.contacts.model.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
public class ContactConfig {

    @Bean
    public Contact ivan(){
        return new Contact(1, "Ivan", "Ivanov", 20);
    }
    @Bean
    public Contact petr(){
        return new Contact(2, "Petr", "Petrov", 40);
    }
    @Bean
    public Contact john(){
        return new Contact(3, "John", "Jonson", 30);
    }

    @Bean
    public HashMap<Integer, Contact> contacts(){
        HashMap map = new HashMap<>();
        map.put(ivan().getId(), ivan());
        map.put(petr().getId(), petr());
        map.put(john().getId(), john());
        return map;
    }
}
