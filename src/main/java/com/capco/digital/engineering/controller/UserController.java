package com.capco.digital.engineering.controller;

import com.capco.digital.engineering.domain.User;
import com.capco.digital.engineering.repository.UserRepository;
import com.capco.digital.engineering.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("Request received to get all users");
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("User not found for id: {}", id);
            return new UserNotFoundException();
        });
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        user.setId(userService.getNextId());
        log.info("Request received to create new user: {}", user);
        return userRepository.save(user);
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User not found from id provided")
    class UserNotFoundException extends RuntimeException { }

}
