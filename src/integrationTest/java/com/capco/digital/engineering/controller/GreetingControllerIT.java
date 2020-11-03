package com.capco.digital.engineering.controller;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GreetingControllerIT {

    public static final String GREETING_PATH = "/helloWorld";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void greeting_GetRequest_200SuccessfulResponse(){
        String helloResponseBody = "{\"message\":\"Hello World!\"}";

        given()
                .when()
                .get(GREETING_PATH)
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(helloResponseBody)));
    }
}
