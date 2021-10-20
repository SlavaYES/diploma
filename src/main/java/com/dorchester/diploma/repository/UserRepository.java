package com.dorchester.diploma.repository;

import com.dorchester.diploma.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
