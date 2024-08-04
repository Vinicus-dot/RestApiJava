package org.example.rest_api.controllers;


import org.example.rest_api.service.interfaces.IAnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/any")
@CrossOrigin(origins ="*")
public class AnyController  {

    @Autowired
    private IAnyService _anyService;

    @GetMapping("chatMessage")
    public ResponseEntity getAllMessage(){
        return  ResponseEntity.ok(_anyService.getAllMessage());
    }
}
