package com.capco.digital.engineering.repository;

import com.capco.digital.engineering.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {

    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);

}
