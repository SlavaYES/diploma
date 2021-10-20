package com.dorchester.diploma.repository;


import com.dorchester.diploma.entity.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Integer> {
    @Query("Select t from Test t where t.theme_id=?1")
    List<Test> findByTheme_id(Integer id);
}
