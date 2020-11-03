package com.capco.digital.engineering.controller;

import com.capco.digital.engineering.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/helloWorld")
    public Greeting greeting(){
        return new Greeting("Hello World!");
    }

}
