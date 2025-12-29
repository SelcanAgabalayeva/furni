package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.contact.ContactCreateDto;
import az.edu.itbrains.furni.dtos.contact.ContactDashDto;
import az.edu.itbrains.furni.dtos.contact.ContactDto;
import az.edu.itbrains.furni.dtos.contact.ContactUpdateDto;
import az.edu.itbrains.furni.models.Contact;
import az.edu.itbrains.furni.repositories.ContactRepository;
import az.edu.itbrains.furni.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;


    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setEmail(contactDto.getEmail());
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setMessage(contactDto.getMessage());
        contactRepository.save(contact);

    }

    @Override
    public List<ContactDashDto> getContactAll() {
        List<ContactDashDto>contactDashDtoList=contactRepository.findAll().stream().map(contact -> modelMapper.map(contact,ContactDashDto.class)).collect(Collectors.toList());
        return contactDashDtoList;
    }

    @Override
    public void createContact(ContactCreateDto contactCreateDto) {
        Contact contact=new Contact();
        contact.setEmail(contactCreateDto.getEmail());
        contact.setFirstName(contactCreateDto.getFirstName());
        contact.setLastName(contactCreateDto.getLastName());
        contact.setMessage(contactCreateDto.getMessage());
        contactRepository.save(contact);
    }

    @Override
    public ContactUpdateDto getUpdateContact(Long id) {
        Contact contact=contactRepository.findById(id).orElseThrow();
        ContactUpdateDto contactUpdateDto=modelMapper.map(contact,ContactUpdateDto.class);
        return contactUpdateDto;
    }

    @Override
    public void updateContact(ContactUpdateDto contactUpdateDto, Long id) {
        Contact contact=contactRepository.findById(id).orElseThrow();
        contact.setEmail(contactUpdateDto.getEmail());
        contact.setFirstName(contactUpdateDto.getFirstName());
        contact.setLastName(contactUpdateDto.getLastName());
        contact.setMessage(contactUpdateDto.getMessage());
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        Contact contact=contactRepository.findById(id).orElseThrow();
        contactRepository.delete(contact);
    }
}
