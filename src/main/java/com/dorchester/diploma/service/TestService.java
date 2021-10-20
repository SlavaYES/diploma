package com.dorchester.diploma.service;

import com.dorchester.diploma.entity.Test;
import com.dorchester.diploma.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private final TestRepository testRepository;

    TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public Iterable<Test> findAll() {
        return testRepository.findAll();
    }

    public Optional<Test> findById(Integer id) {
        return testRepository.findById(id);
    }

    public List<Test> findByThemeId(Integer id) {
        return testRepository.findByTheme_id(id);
    }
}
