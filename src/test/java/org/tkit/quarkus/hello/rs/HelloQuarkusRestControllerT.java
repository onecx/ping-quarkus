package org.tkit.quarkus.hello.rs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tkit.quarkus.hello.test.AbstractTest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Example tests")
public class HelloQuarkusRestControllerT  extends AbstractTest {

    @Test
    @DisplayName("Hello test")
    public void helloTest() {
        String tmp = given()
                .when()
                .contentType(MediaType.APPLICATION_JSON)
                .get("/hello")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().body().asString();

        Assertions.assertEquals("Hello quarkus", tmp);
    }
}
