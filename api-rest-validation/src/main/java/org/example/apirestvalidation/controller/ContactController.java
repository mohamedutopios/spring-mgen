package org.example.apirestvalidation.controller;


import jakarta.validation.Valid;
import org.example.apirestvalidation.model.Contact;
import org.example.apirestvalidation.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {


    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts(){
       return contactService.getContacts();

    }

    @PostMapping
    public ResponseEntity<?> addContact(@Valid @RequestBody Contact contact, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + " : " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        Contact savedContact = contactService.addContact(contact);
        return ResponseEntity.status(201).body(savedContact);
    }



}
