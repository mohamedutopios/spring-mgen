package org.example.apirestvalidation.service;

import org.example.apirestvalidation.model.Contact;
import org.example.apirestvalidation.model.Contact2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService2 {

    private final List<Contact2> contacts2 = new ArrayList<>();

    public ContactService2() {
        contacts2.add(Contact2.builder()
                .id("ABC123")
                .email("mohamed@gmail.com")
                .phone("1234567890")
                .firstName("mohamed")
                .lastName("apeupres")
                .build());
        contacts2.add(new Contact2("AZE456","Michel","Fugain","michel@gmail.com","1234567890"));
    }

    public List<Contact2> getContacts() {
        return contacts2;
    }

    public Contact2 addContact(Contact2 contact2) {
        contacts2.add(contact2);
        return contact2;
    }


}
