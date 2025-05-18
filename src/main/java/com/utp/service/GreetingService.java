package com.utp.service;

/**
 *
 * @author Carla Abregù
 */
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/greetings")
public class GreetingService {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("user") String user) {
        if (user == null || user.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("No autorizado").build();
        }
        return Response.ok("Hola, " + user + "! Bienvenido.").build();
    }    
}
