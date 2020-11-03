package com.capco.digital.engineering.controller;

import com.capco.digital.engineering.domain.Greeting;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {

    public static final String GREETING_PATH = "/helloWorld";

    @Mock
    private GreetingController greetingController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(greetingController);
    }

    @Test
    public void hello_GetRequest_200SuccessfulResponse(){
        String helloResponseBody = "{\"message\":\"Hello World!\"}";
        when(greetingController.greeting()).thenReturn(new Greeting("Hello World!"));

        given()
                .when()
                .get(GREETING_PATH)
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(helloResponseBody)));
    }

}
