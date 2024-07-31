package org.example.rest_api.service.implementations;

import org.example.rest_api.model.entity.ChatMessage;
import org.example.rest_api.repository.interfaces.IAnyRepository;
import org.example.rest_api.service.interfaces.IAnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnyService  implements IAnyService {

    @Autowired
    private IAnyRepository _anyRepository;

    @Override
    public List<ChatMessage> getAllMessage() {
        return _anyRepository.getAllMessage();
    }
}
