package com.dorchester.diploma.controller;


import com.dorchester.diploma.entity.Question;
import com.dorchester.diploma.entity.Test;
import com.dorchester.diploma.service.QuestionService;
import com.dorchester.diploma.service.TestService;
import com.dorchester.diploma.service.ThemeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    private final ThemeService themeService;

    private final QuestionService questionService;

    TestController(TestService testService, ThemeService themeService, QuestionService questionService) {
        this.testService = testService;
        this.themeService = themeService;
        this.questionService = questionService;
    }

    @GetMapping("/main_tests")
    public String chapters(Model model) {
        model.addAttribute("tests", testService.findAll());
        return "/tests/main_tests";
    }

    @GetMapping("/create_test")
    public String page_create_test(Model model) {
        return "/tests/create_test";
    }

    @PostMapping("/create_test")
    public String setCreateTest(
            @Valid Test test,
            BindingResult bindingResult,
            Model model) {
        boolean isEmptyTitle = ObjectUtils.isEmpty(test.getTitle());
        boolean isEmptyDesc = ObjectUtils.isEmpty(test.getDescription());

        if (isEmptyTitle) {
            model.addAttribute("titleError", "Поле не должно быть пусто");
        }

        if (isEmptyDesc) {
            model.addAttribute("descriptionError", "Поле не должно быть пусто");
        }

        if (isEmptyDesc || isEmptyTitle || bindingResult.hasErrors()) {
            Map<String, String> errorMap = UtilController.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("test", test);
            return "/tests/create_test";
        }

        testService.save(test);

        return "redirect:/tests/main_questions/" + test.getId();
    }

    @GetMapping("{test}")
    public String ch(@PathVariable Test test, Model model) {
        List<Question> questions = questionService.findByTestId(test.getId());
        model.addAttribute("questions", questions);
        model.addAttribute("test", test);
        return "/tests/go_test";
    }
}
