package org.tkit.quarkus.hello.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloQuarkusRestController {

    @GET
    public Response hello() {
        return Response.ok("Hello oquarkus").build();
    }
}
