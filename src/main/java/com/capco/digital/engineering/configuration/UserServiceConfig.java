package com.capco.digital.engineering.configuration;

import com.capco.digital.engineering.service.UserService;
import com.capco.digital.engineering.service.UserSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
public class UserServiceConfig {

    @Bean
    @Autowired
    public UserService userService(MongoOperations mongoOperations){
        return new UserSequenceService(mongoOperations);
    }
    
}
