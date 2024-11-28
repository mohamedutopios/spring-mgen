package org.example.apirestvalidation.service;

import org.example.apirestvalidation.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public ContactService() {
        contacts.add(Contact.builder()
                .id("ABC123")
                .email("mohamed@gmail.com")
                .phone("1234567890")
                .firstName("mohamed")
                .lastName("apeupres")
                .build());
        contacts.add(new Contact("AZE456","Michel","Fugain","michel@gmail.com","1234567890"));
    }

public List<Contact> getContacts() {
        return contacts;
}

public Contact addContact(Contact contact) {
        contacts.add(contact);
        return contact;
}


}
