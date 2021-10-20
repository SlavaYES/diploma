package com.dorchester.diploma.controller;

import com.dorchester.diploma.entity.Theme;
import com.dorchester.diploma.service.TestService;
import com.dorchester.diploma.service.ThemeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    private final ThemeService themeService;

    @Autowired
    private final TestService testService;

    public ThemeController(ThemeService themeService, TestService testService) {
        this.themeService = themeService;
        this.testService = testService;
    }

    @GetMapping("/main_themes")
    public String getThemes(Model model) {
        model.addAttribute("themes", themeService.findAll());
        return "/themes/main_themes";
    }

    @GetMapping("/create_theme")
    public String getCreateTheme(Model model) {
        return "/themes/create_theme";
    }

    @PostMapping("/create_theme")
    public String setCreateTheme(
            @Valid Theme theme,
            BindingResult bindingResult,
            Model model) {

        boolean isEmptyTitle = ObjectUtils.isEmpty(theme.getTitle());
        boolean isEmptyDesc = ObjectUtils.isEmpty(theme.getDescription());

        if (isEmptyTitle) {
            model.addAttribute("titleError", "Поле не должно быть пусто");
        }

        if (isEmptyDesc) {
            model.addAttribute("descriptionError", "Поле не должно быть пусто");
        }

        if (isEmptyDesc || isEmptyTitle || bindingResult.hasErrors()) {
            Map<String, String> errorMap = UtilController.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("theme", theme);
            return "/themes/create_theme";
        }

        model.addAttribute("theme", null);
        themeService.save(theme);

        Iterable<Theme> themes = themeService.findAll();
        model.addAttribute("themes", themes);

        return "redirect:/themes/main_themes";
    }

    @GetMapping("{theme}")
    public String goTheme(@PathVariable Theme theme, Model model) {
        model.addAttribute("theme", theme);
        return "themes/go_theme";
    }
}