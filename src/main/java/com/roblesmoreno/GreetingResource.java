package com.roblesmoreno;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger log = Logger.getLogger(GreetingResource.class);
    @ConfigProperty(name="publisher.name")
    String publisherName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info(String.format("Property %s",publisherName) );
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/world")
    public Response world(){
        return Response.status(Response.Status.OK).entity("{Hello World").build();
    }
}
