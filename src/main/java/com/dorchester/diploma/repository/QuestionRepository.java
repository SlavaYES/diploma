package com.dorchester.diploma.repository;

import com.dorchester.diploma.entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    @Query("select q from Question q where q.test_id=?1")
    List<Question> findByTestId(Integer id);
}
