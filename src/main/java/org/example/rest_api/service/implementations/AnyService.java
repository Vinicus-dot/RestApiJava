package org.example.rest_api.service.implementations;

import org.example.rest_api.model.entity.ChatMessage;
import org.example.rest_api.repository.interfaces.IAnyRepository;
import org.example.rest_api.service.interfaces.IAnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnyService  implements IAnyService {

    @Autowired
    private IAnyRepository _anyRepository;

    @Override
    public List<ChatMessage> getAllMessage() {
        if(true)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        return _anyRepository.getAllMessage();
    }
}
