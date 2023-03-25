package com.example.mydoc.web.controller;

import com.example.mydoc.models.dto.MessageDTO;
import com.example.mydoc.services.ContactsService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactsController {

    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @ModelAttribute("messageDTO")
    public MessageDTO messageDTO() {
        return new MessageDTO();
    }

    @GetMapping("/contacts")
    public String renderContactsPage() {
        return "contacts";
    }

    @PostMapping("/contacts/message/post")
    public String handleMessageForm(@Valid MessageDTO messageDTO,
                                    RedirectAttributes redirectAttributes) {

        if (messageDTO.getMessage().length() == 0 || messageDTO.getCity().equals("Empty")) {
            redirectAttributes
                    .addFlashAttribute("isEmpty", false);

            return "redirect:/contacts";
        }

        this.contactsService.sendMessage(messageDTO);

        return "redirect:/find-mydoc";
    }
}
