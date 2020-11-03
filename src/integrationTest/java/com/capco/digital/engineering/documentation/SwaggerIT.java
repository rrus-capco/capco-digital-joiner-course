package com.capco.digital.engineering.documentation;

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
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SwaggerIT {

    public static final String API_DOCS_PATH = "/v2/api-docs";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void apiDocs_GetRequest_200SuccessfulResponse(){
//        String apiDocsResponseBody = "{\"swagger\":\"2.0\",\"info\":{\"description\":\"Api Documentation\",\"version\":\"1.0\",\"title\":\"Api Documentation\",\"termsOfService\":\"urn:tos\",\"contact\":{},\"license\":{\"name\":\"Apache 2.0\",\"url\":\"http://www.apache.org/licenses/LICENSE-2.0\"}},\"host\":\"localhost\",\"basePath\":\"/\",\"tags\":[{\"name\":\"basic-error-controller\",\"description\":\"Basic Error Controller\"},{\"name\":\"greeting-controller\",\"description\":\"Greeting Controller\"},{\"name\":\"user-controller\",\"description\":\"User Controller\"}],\"paths\":{\"/error\":{\"get\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingGET\",\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false},\"head\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingHEAD\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"204\":{\"description\":\"No Content\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"}},\"deprecated\":false},\"post\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false},\"put\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingPUT\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false},\"delete\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingDELETE\",\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"204\":{\"description\":\"No Content\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"}},\"deprecated\":false},\"options\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingOPTIONS\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"204\":{\"description\":\"No Content\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"}},\"deprecated\":false},\"patch\":{\"tags\":[\"basic-error-controller\"],\"summary\":\"error\",\"operationId\":\"errorUsingPATCH\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}}},\"204\":{\"description\":\"No Content\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"}},\"deprecated\":false}},\"/helloWorld\":{\"get\":{\"tags\":[\"greeting-controller\"],\"summary\":\"greeting\",\"operationId\":\"greetingUsingGET\",\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/Greeting\"}},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false}},\"/users\":{\"get\":{\"tags\":[\"user-controller\"],\"summary\":\"getUsers\",\"operationId\":\"getUsersUsingGET\",\"produces\":[\"*/*\"],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/User\"}}},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false},\"post\":{\"tags\":[\"user-controller\"],\"summary\":\"createUser\",\"operationId\":\"createUserUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"user\",\"description\":\"user\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/User\"}}],\"responses\":{\"201\":{\"description\":\"Created\",\"schema\":{\"$ref\":\"#/definitions/User\"}},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false}},\"/users/{id}\":{\"get\":{\"tags\":[\"user-controller\"],\"summary\":\"getUser\",\"operationId\":\"getUserUsingGET\",\"produces\":[\"*/*\"],\"parameters\":[{\"name\":\"id\",\"in\":\"path\",\"description\":\"id\",\"required\":true,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/User\"}},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}},\"deprecated\":false}}},\"definitions\":{\"Greeting\":{\"type\":\"object\",\"properties\":{\"message\":{\"type\":\"string\"}},\"title\":\"Greeting\"},\"ModelAndView\":{\"type\":\"object\",\"properties\":{\"empty\":{\"type\":\"boolean\"},\"model\":{\"type\":\"object\"},\"modelMap\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"object\"}},\"reference\":{\"type\":\"boolean\"},\"status\":{\"type\":\"string\",\"enum\":[\"100 CONTINUE\",\"101 SWITCHING_PROTOCOLS\",\"102 PROCESSING\",\"103 CHECKPOINT\",\"200 OK\",\"201 CREATED\",\"202 ACCEPTED\",\"203 NON_AUTHORITATIVE_INFORMATION\",\"204 NO_CONTENT\",\"205 RESET_CONTENT\",\"206 PARTIAL_CONTENT\",\"207 MULTI_STATUS\",\"208 ALREADY_REPORTED\",\"226 IM_USED\",\"300 MULTIPLE_CHOICES\",\"301 MOVED_PERMANENTLY\",\"302 FOUND\",\"302 MOVED_TEMPORARILY\",\"303 SEE_OTHER\",\"304 NOT_MODIFIED\",\"305 USE_PROXY\",\"307 TEMPORARY_REDIRECT\",\"308 PERMANENT_REDIRECT\",\"400 BAD_REQUEST\",\"401 UNAUTHORIZED\",\"402 PAYMENT_REQUIRED\",\"403 FORBIDDEN\",\"404 NOT_FOUND\",\"405 METHOD_NOT_ALLOWED\",\"406 NOT_ACCEPTABLE\",\"407 PROXY_AUTHENTICATION_REQUIRED\",\"408 REQUEST_TIMEOUT\",\"409 CONFLICT\",\"410 GONE\",\"411 LENGTH_REQUIRED\",\"412 PRECONDITION_FAILED\",\"413 PAYLOAD_TOO_LARGE\",\"413 REQUEST_ENTITY_TOO_LARGE\",\"414 URI_TOO_LONG\",\"414 REQUEST_URI_TOO_LONG\",\"415 UNSUPPORTED_MEDIA_TYPE\",\"416 REQUESTED_RANGE_NOT_SATISFIABLE\",\"417 EXPECTATION_FAILED\",\"418 I_AM_A_TEAPOT\",\"419 INSUFFICIENT_SPACE_ON_RESOURCE\",\"420 METHOD_FAILURE\",\"421 DESTINATION_LOCKED\",\"422 UNPROCESSABLE_ENTITY\",\"423 LOCKED\",\"424 FAILED_DEPENDENCY\",\"425 TOO_EARLY\",\"426 UPGRADE_REQUIRED\",\"428 PRECONDITION_REQUIRED\",\"429 TOO_MANY_REQUESTS\",\"431 REQUEST_HEADER_FIELDS_TOO_LARGE\",\"451 UNAVAILABLE_FOR_LEGAL_REASONS\",\"500 INTERNAL_SERVER_ERROR\",\"501 NOT_IMPLEMENTED\",\"502 BAD_GATEWAY\",\"503 SERVICE_UNAVAILABLE\",\"504 GATEWAY_TIMEOUT\",\"505 HTTP_VERSION_NOT_SUPPORTED\",\"506 VARIANT_ALSO_NEGOTIATES\",\"507 INSUFFICIENT_STORAGE\",\"508 LOOP_DETECTED\",\"509 BANDWIDTH_LIMIT_EXCEEDED\",\"510 NOT_EXTENDED\",\"511 NETWORK_AUTHENTICATION_REQUIRED\"]},\"view\":{\"$ref\":\"#/definitions/View\"},\"viewName\":{\"type\":\"string\"}},\"title\":\"ModelAndView\"},\"User\":{\"type\":\"object\",\"properties\":{\"firstName\":{\"type\":\"string\"},\"id\":{\"type\":\"string\"},\"lastName\":{\"type\":\"string\"}},\"title\":\"User\"},\"View\":{\"type\":\"object\",\"properties\":{\"contentType\":{\"type\":\"string\"}},\"title\":\"View\"}}}";

        given()
                .when()
                .get(API_DOCS_PATH)
                .then()
                .statusCode(OK.value())
                .contentType(ContentType.JSON);
    }

}