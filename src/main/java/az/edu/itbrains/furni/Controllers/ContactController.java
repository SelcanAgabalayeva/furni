package az.edu.itbrains.furni.Controllers;

import az.edu.itbrains.furni.dtos.contact.ContactCreateDto;
import az.edu.itbrains.furni.dtos.contact.ContactDashDto;
import az.edu.itbrains.furni.dtos.contact.ContactDto;
import az.edu.itbrains.furni.dtos.contact.ContactUpdateDto;
import az.edu.itbrains.furni.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    @PostMapping("/contact")
    public String addContact(@ModelAttribute("contact")ContactDto contactDto){
        contactService.addContact(contactDto);
        return "redirect:/contact";
    }

    @GetMapping("/admin/contact")
    public String admin(Model model){
        List<ContactDashDto> contactDashDtoList=contactService.getContactAll();
        model.addAttribute("contacts",contactDashDtoList);
        return "/dashboard/contact/index.html";
    }
    @GetMapping("/admin/contact/create")
    public String admin(){
        return "/dashboard/contact/create.html";
    }
    @PostMapping("/admin/contact/create")
    public String createContact(@ModelAttribute("contact")ContactCreateDto contactCreateDto){
        contactService.createContact(contactCreateDto);
        return "redirect:/admin/contact";
    }
    @GetMapping("/admin/contact/update/{id}")
    public String update(@PathVariable Long id,Model model){
        ContactUpdateDto contactUpdateDto=contactService.getUpdateContact(id);
        model.addAttribute("contact",contactUpdateDto);
        return "/dashboard/contact/update.html";
    }

    @PostMapping("/admin/contact/update/{id}")
    public String update(@ModelAttribute ContactUpdateDto contactUpdateDto,@PathVariable Long id,Model model){
        contactService.updateContact(contactUpdateDto,id);
        return "redirect:/admin/contact";
    }
    @GetMapping("/admin/contact/delete/{id}")
    public  String delete(@PathVariable ("id") Long id){
        return "/dashboard/contact/delete.html";
    }
    @PostMapping("/admin/contact/delete/{id}")
    public  String deletes(@PathVariable ("id") Long id){
        contactService.deleteContact(id);
        return "redirect:/admin/contact";
    }




}
