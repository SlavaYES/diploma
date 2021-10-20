package com.dorchester.diploma.service;

import com.dorchester.diploma.entity.Message;
import com.dorchester.diploma.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Iterable<Message> findByTag(String tag) {
        return messageRepository.findByTag(tag);
    }
}
