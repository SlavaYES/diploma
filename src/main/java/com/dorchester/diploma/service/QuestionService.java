package com.dorchester.diploma.service;

import com.dorchester.diploma.entity.Question;
import com.dorchester.diploma.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    public List<Question> findByTestId(Integer id) {
        return questionRepository.findByTestId(id);
    }
}
