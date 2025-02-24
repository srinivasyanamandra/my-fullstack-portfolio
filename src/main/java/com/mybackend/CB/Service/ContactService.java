package com.mybackend.CB.Service;

import com.mybackend.CB.model.Contact;
import com.mybackend.CB.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Save a new contact
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Get all contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Get a contact by ID
    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
    }

    // Delete a contact by ID
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
