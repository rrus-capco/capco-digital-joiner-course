package com.capco.digital.engineering.controller;

import com.capco.digital.engineering.domain.User;
import com.capco.digital.engineering.repository.UserRepository;
import com.capco.digital.engineering.service.UserService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    public static final String GET_USERS_PATH = "/users";
    public static final String GET_USER_PATH = "/users/%s";
    public static final String CREATE_USER_PATH = "/users";

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    private UserController userController;

    @Before
    public void setup() {
        userController = new UserController(userRepository, userService);
        RestAssuredMockMvc.standaloneSetup(userController);
    }

    @Test
    public void getUsers_validRequest_200SuccessfulResponseAndListOfUsersReturned(){
        String getUsersResponseBody = "" +
                "[" +
                  "{\"id\":\"1\",\"firstName\":\"Dave\",\"lastName\":\"Smith\"}," +
                  "{\"id\":\"2\",\"firstName\":\"Mary\",\"lastName\":\"Mcdonald\"}" +
                "]";
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new MockUser("Dave", "Smith", "1"),
                new MockUser("Mary", "Mcdonald", "2"))
        );

        given()
                .when()
                .get(GET_USERS_PATH)
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(getUsersResponseBody)));
    }

    @Test
    public void getUser_validId_200SuccessfulResponseAndListOfUsersReturned(){
        String getUserResponseBody = "{\"id\":\"1\",\"firstName\":\"Dave\",\"lastName\":\"Smith\"}";
        when(userRepository.findById("1")).thenReturn(Optional.of(new MockUser("Dave", "Smith", "1")));

        given()
                .when()
                .get(String.format(GET_USER_PATH, "1"))
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON)
                .body(is(equalTo(getUserResponseBody)));
    }

    @Test
    public void getUser_invalidId_404ResponseCode(){
        String getUserResponseBody = "{\"id\":\"1\",\"firstName\":\"Dave\",\"lastName\":\"Smith\"}";
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        given()
                .when()
                .get(String.format(GET_USER_PATH, "1"))
                .then()
                .statusCode(NOT_FOUND.value());
    }

    @Test
    public void createUser_validRequest_201CreatedResponseCodeReturned(){
        String createUserRequestPayload = "{\"firstName\":\"Dave\",\"lastName\":\"Smith\"}";
        when(userRepository.save(any(User.class))).thenReturn(new MockUser("Dave", "Smith", "1"));
        when(userService.getNextId()).thenReturn("1");

        given()
                .contentType(ContentType.JSON)
                .body(createUserRequestPayload)
                .post(CREATE_USER_PATH)
                .then()
                .statusCode(CREATED.value());
    }

    class MockUser extends User {
        private final String id;

        public MockUser(String firstName, String lastName, String id) {
            super(firstName, lastName);
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

}
