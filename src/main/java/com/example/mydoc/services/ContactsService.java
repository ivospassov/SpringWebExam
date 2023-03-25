package com.example.mydoc.services;

import com.example.mydoc.models.dto.MessageDTO;

public interface ContactsService {

    void sendMessage(MessageDTO messageDTO);
}
