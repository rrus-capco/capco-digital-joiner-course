package com.capco.digital.engineering.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSequences")
public class UserSequences {

    @Id
    private String id;
    private int seq;

    public int getSeq() {
        return seq;
    }

}