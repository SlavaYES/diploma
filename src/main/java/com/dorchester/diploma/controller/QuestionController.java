package com.dorchester.diploma.controller;

import com.dorchester.diploma.entity.Question;
import com.dorchester.diploma.entity.Test;
import com.dorchester.diploma.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("tests/")
public class QuestionController {
    @Autowired
    private final QuestionService questionService;

    @Value("${upload.path}")
    private String uploadPath;

    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/main_questions/{test}")
    public String getQuestions(@PathVariable Test test, Model model) {
        List<Question> questions = questionService.findByTestId(test.getId());
        model.addAttribute("questions", questions);
        model.addAttribute("test", test);
        return "/tests/main_questions";
    }

    @GetMapping("create_question/{test}")
    public String getCreateQuestion(@PathVariable Test test, Model model) {
        List<Question> questions = questionService.findByTestId(test.getId());
        model.addAttribute("questions", questions);
        model.addAttribute("test", test);
        return "/tests/create_question";
    }

    @PostMapping("/create_question/{test}")
    public String setCreateQuestion(
            @PathVariable Test test,
            @Valid Question question,
            BindingResult bindingResult, // должен идти перед Model
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {

        question.setTest_id(test.getId());

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = UtilController.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("question", question);
        } else {
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                question.setFilename(resultFilename);
            }
            model.addAttribute("question", null);
            questionService.save(question);
        }

        Iterable<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "/tests/create_question";
    }
}
