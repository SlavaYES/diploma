package com.dorchester.diploma.repository;

import com.dorchester.diploma.entity.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {
    Theme findByTitle(String title);
}
