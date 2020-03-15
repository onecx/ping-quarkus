package org.tkit.quarkus.hello.test;

import io.restassured.RestAssured;
import org.tkit.quarkus.test.docker.DockerComposeService;
import org.tkit.quarkus.test.docker.DockerTestEnvironment;

public class AbstractTest {

    // load the docker compose file from src/test/resources/docker-compose.yml
    public static DockerTestEnvironment ENVIRONMENT = new DockerTestEnvironment();

    //Configure the containers for the test
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        // start the docker test environment
        ENVIRONMENT.start();

        // update the rest assured port for the integration test
        DockerComposeService service = ENVIRONMENT.getService("ping-quarkus");
        if (service != null) {
            RestAssured.port = service.getPort(8080);
            RestAssured.baseURI = "http://" + service.getHost();
        }
    }
}
