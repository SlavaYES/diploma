package com.dorchester.diploma.service;

import com.dorchester.diploma.entity.Theme;
import com.dorchester.diploma.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public Iterable<Theme> findAll() {
        return themeRepository.findAll();
    }

    public Theme save(Theme theme) {
        return themeRepository.save(theme);
    }

    public Theme findByTitle(String title) {
        return themeRepository.findByTitle(title);
    }

    public Optional<Theme> findById(Integer id) {
        return themeRepository.findById(id);
    }
}
