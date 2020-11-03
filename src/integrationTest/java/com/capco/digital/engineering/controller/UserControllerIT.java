package com.capco.digital.engineering.controller;

import com.capco.digital.engineering.domain.User;
import com.capco.digital.engineering.service.UserSequences;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerIT {

    public static final String USERS_PATH = "/users";
    public static final String GET_USER_PATH = "/users/%s";
    public static final String CREATE_USER_PATH = "/users";

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOps;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        mongoOps = mongoTemplate;
        mongoOps.save(userToRetrieve());
    }

    @Test()
    public void getUsers_ValidRequest_200StatusCodeAndListOfUsersReturned(){
        String usersResponseBody = "[{\"firstName\":\"Dave\",\"lastName\":\"Smith\",\"id\":\"1\"}]";

        given()
                .when()
                .get(USERS_PATH)
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(usersResponseBody)));
    }

    @Test()
    public void getUser_ValidId_200StatusCodeAndCorrectUserReturned(){
        String userResponseBody = "{\"firstName\":\"Dave\",\"lastName\":\"Smith\",\"id\":\"1\"}";

        given()
                .when()
                .get(String.format(GET_USER_PATH, "1"))
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(userResponseBody)));
    }

    @Test
    public void getUser_invalidId_404ResponseCode(){

        given()
                .when()
                .get(String.format(GET_USER_PATH, "2"))
                .then()
                .statusCode(NOT_FOUND.value());
    }

    @Test()
    public void createUser_ValidRequest_201CreatedStatusReturned(){
        String createUserRequestPayload = "{\"firstName\":\"Dave\",\"lastName\":\"Smith\"}";

        given()
                .contentType(ContentType.JSON)
                .body(createUserRequestPayload)
                .post(CREATE_USER_PATH)
                .then()
                .statusCode(CREATED.value());

    }

    private User userToRetrieve() {
        User userToRetrieve = new User("Dave", "Smith");
        userToRetrieve.setId("1");
        return userToRetrieve;
    }

    @After
    public void cleanup(){
        mongoOps.findAndRemove(query(where("_id").is("userSequences")), UserSequences.class);
    }

}
