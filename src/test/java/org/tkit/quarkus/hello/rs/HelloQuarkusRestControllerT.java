package org.tkit.quarkus.hello.rs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tkit.quarkus.hello.test.AbstractTest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HelloQuarkusRestControllerT  extends AbstractTest {

    @Test
    public void dummyTest() {
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
