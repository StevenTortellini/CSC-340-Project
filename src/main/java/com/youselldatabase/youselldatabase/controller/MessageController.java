// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.entities.Message;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable int id) {
        return service.getMessageById(id);
    }

    @PostMapping("/new")
    public Message createMessage(@RequestBody Message message) {
        service.addNewMessage(message);
        return getMessageById(message.getMessageId());
    }

    @PutMapping("/update/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message messageDetails) {
        service.updateMessage(id, messageDetails);
        return getMessageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        service.deleteMessageById(id);
    }
}
