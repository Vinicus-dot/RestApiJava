package org.example.rest_api.repository.interfaces;
import  org.example.rest_api.model.entity.ChatMessage;
import java.util.List;

public interface IAnyRepository {
    List<ChatMessage> getAllMessage();
}
