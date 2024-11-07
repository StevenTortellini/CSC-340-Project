package com.youselldatabase.youselldatabase.service;



import com.youselldatabase.youselldatabase.entities.Message;
import com.youselldatabase.youselldatabase.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repo;


    public List<Message> getAllMessages(){
        return repo.findAll();
    }

    public  Message getMessageById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewMessage(Message message){
        repo.save(message);
    }

    public void updateMessage(int id, @org.jetbrains.annotations.NotNull Message message){
        Message  existing = getMessageById(id);
        existing.setBuyerId(message.getBuyerId());
        existing.setSellerId(message.getSellerId());
        existing.setMessageBody(message.getMessageBody());
        existing.setSoldTo(message.isSoldTo());

        repo.save(existing);

    }

    public List<Message> deleteMessageById(int id){
        repo.deleteById(id);
        return  repo.findAll();
    }

}
