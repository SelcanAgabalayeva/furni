package az.edu.itbrains.furni.services;

import az.edu.itbrains.furni.dtos.contact.ContactCreateDto;
import az.edu.itbrains.furni.dtos.contact.ContactDashDto;
import az.edu.itbrains.furni.dtos.contact.ContactDto;
import az.edu.itbrains.furni.dtos.contact.ContactUpdateDto;

import java.util.List;

public interface ContactService {
    void addContact(ContactDto contactDto);

    List<ContactDashDto> getContactAll();

    void createContact(ContactCreateDto contactCreateDto);

    ContactUpdateDto getUpdateContact(Long id);

    void updateContact(ContactUpdateDto contactUpdateDto, Long id);

    void deleteContact(Long id);
}
