package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.ContactDto;
import az.edu.itbrains.furni.models.Contact;
import az.edu.itbrains.furni.repositories.ContactRepository;
import az.edu.itbrains.furni.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setEmail(contactDto.getEmail());
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setMessage(contactDto.getMessage());
        contactRepository.save(contact);

    }
}
