package com.mybackend.CB.Controller;

import com.mybackend.CB.model.Contact;
import com.mybackend.CB.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:3000")
// Allow React frontend to access
// Allow frontend access
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Endpoint to save a new contact
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    // Endpoint to get all contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    // Endpoint to get a single contact by ID
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    // Endpoint to delete a contact by ID
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
