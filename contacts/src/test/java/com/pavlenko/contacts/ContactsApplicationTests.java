package com.pavlenko.contacts;

import com.pavlenko.contacts.controller.ContactController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ContactsApplicationTests {

    @Test
    void contextLoads() {
        ContactController contactController = Mockito.mock(ContactController.class);

        Mockito.when(contactController.getAll(any())).thenReturn("contacts");

    }

}
