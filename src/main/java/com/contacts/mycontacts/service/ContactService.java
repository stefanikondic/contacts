package com.contacts.mycontacts.service;

import com.contacts.mycontacts.exceptions.ContactNotFoundException;
import com.contacts.mycontacts.model.Contact;
import com.contacts.mycontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    public Contact updateContact(Contact contact) {
        Optional<Contact> oldContact = contactRepository.findContactById(contact.getId());
        if (oldContact.isPresent()) {
            oldContact.get().setName(contact.getName());
            oldContact.get().setPhone(contact.getPhone());
            oldContact.get().setEmail(contact.getEmail());
            return contactRepository.save(oldContact.get());
        } else {
            return null;
        }

    }

    public Contact findContactById(Long id) {
        return contactRepository.findContactById(id).orElseThrow(()-> new ContactNotFoundException
                ("There are no contacts with that id. "));
    }

    @Transactional
    public void deleteContact(Long id) {
        contactRepository.deleteContactById(id);
    }
}
