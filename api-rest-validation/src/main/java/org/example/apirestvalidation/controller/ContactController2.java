package org.example.apirestvalidation.controller;

import jakarta.validation.Valid;
import org.example.apirestvalidation.model.Contact;
import org.example.apirestvalidation.model.Contact2;
import org.example.apirestvalidation.service.ContactService;
import org.example.apirestvalidation.service.ContactService2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/contacts2")
public class ContactController2 {


    private final ContactService2 contactService2;

    public ContactController2(ContactService2 contactService2) {
        this.contactService2 = contactService2;
    }

    @GetMapping
    public List<Contact2> getAllContacts(){
        return contactService2.getContacts();

    }

    @PostMapping
    public ResponseEntity<?> addContact(@Valid @RequestBody Contact2 contact2, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + " : " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        Contact2 savedContact = contactService2.addContact(contact2);
        return ResponseEntity.status(201).body(savedContact);
    }
}
