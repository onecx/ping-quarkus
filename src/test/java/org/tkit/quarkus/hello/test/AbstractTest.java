package org.tkit.quarkus.hello.test;

import io.quarkus.test.common.QuarkusTestResource;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.tkit.quarkus.test.docker.DockerComposeService;
import org.tkit.quarkus.test.docker.DockerComposeTestResource;
import org.tkit.quarkus.test.docker.DockerService;
import org.tkit.quarkus.test.docker.DockerTestEnvironment;
import org.tkit.quarkus.test.docker.QuarkusTestcontainers;

@QuarkusTestcontainers
@QuarkusTestResource(DockerComposeTestResource.class)
public class AbstractTest {

    @DockerService("ping-quarkus")
    protected DockerComposeService service;

    //Configure the containers for the test
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeEach
    public void init() {
        // update the rest assured port for the integration test
        if (service != null) {
            RestAssured.port = service.getPort(8080);
            RestAssured.baseURI = "http://" + service.getHost();
        }
    }
}
