package com.capco.digital.engineering.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@ToString
public class User {

    @Id
    private String id;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public User(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }
}
