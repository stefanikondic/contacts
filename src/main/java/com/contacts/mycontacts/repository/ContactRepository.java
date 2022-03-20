package com.contacts.mycontacts.repository;

import com.contacts.mycontacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ContactRepository extends JpaRepository<Contact, Long> {
    void deleteContactById(Long id);

    Optional<Contact> findContactById(Long id);
}
