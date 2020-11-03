package com.capco.digital.engineering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class UserSequenceService implements UserService {

    private final MongoOperations mongoOps;

    @Autowired
    public UserSequenceService(MongoOperations mongoOps){
        this.mongoOps = mongoOps;
    }

    @Override
    public String getNextId() {
        UserSequences counter = mongoOps.findAndModify(
                query(where("_id").is("userSequences")),
                new Update().inc("seq", 1),
                options().returnNew(true).upsert(true),
                UserSequences.class
        );
        return String.valueOf(counter.getSeq());
    }
}
