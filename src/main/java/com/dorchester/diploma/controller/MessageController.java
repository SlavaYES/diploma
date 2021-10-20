package com.dorchester.diploma.controller;

import com.dorchester.diploma.entity.Message;
import com.dorchester.diploma.entity.User;
import com.dorchester.diploma.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Value("${upload.path}")
    private String uploadPath;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message")
    public String findAll(@RequestParam(required = false) String filter, Model model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageService.findByTag(filter);
        } else {
            messages = messageService.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "/messages/message";
    }

    @PostMapping("/message")
    public String add(@AuthenticationPrincipal User user,
                      @Valid Message message,
                      BindingResult bindingResult, // должен идти перед Model
                      Model model,
                      @RequestParam("file") MultipartFile file) throws IOException {
        message.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = UtilController.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("message", message);
        } else {
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                message.setFilename(resultFilename);
            }
            model.addAttribute("message", null);
            messageService.save(message);
        }

        Iterable<Message> messages = messageService.findAll();
        model.addAttribute("messages", messages);

        return "/messages/message";
    }
}
