package org.example.rest_api.service.interfaces;

import org.example.rest_api.model.entity.ChatMessage;

import java.util.List;

public interface IAnyService {
    List<ChatMessage> getAllMessage();
}
