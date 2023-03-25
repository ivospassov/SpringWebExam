package com.example.mydoc.services.impl;

import com.example.mydoc.models.dto.MessageDTO;
import com.example.mydoc.models.entities.Message;
import com.example.mydoc.repositories.ContactsRepository;
import com.example.mydoc.services.ContactsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository contactsRepository;

    private final ModelMapper modelMapper;

    public ContactsServiceImpl(ContactsRepository contactsRepository, ModelMapper modelMapper) {
        this.contactsRepository = contactsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        Message message = this.modelMapper.map(messageDTO, Message.class);
        this.contactsRepository.save(message);
    }
}
