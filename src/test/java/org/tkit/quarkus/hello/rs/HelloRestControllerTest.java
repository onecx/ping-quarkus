package org.tkit.quarkus.hello.rs;

import static io.restassured.RestAssured.given;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
@DisplayName("Example tests")
class HelloRestControllerTest {

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Hello rest service test")
    void helloTest() {
        String tmp = given()
                .when()
                .contentType(MediaType.APPLICATION_JSON)
                .get("/hello")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().body().asString();

        Assertions.assertEquals("Hello quarkus2?", tmp);
    }
}
