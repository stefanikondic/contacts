package com.contacts.mycontacts;

import com.contacts.mycontacts.model.Contact;
import com.contacts.mycontacts.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id) {
        Contact contact = contactService.findContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact newContact = contactService.addContact(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Contact> editContact(@RequestBody Contact contact) {
        Contact editedContact = contactService.updateContact(contact);
        if (editedContact != null){
        return new ResponseEntity<>(editedContact, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
