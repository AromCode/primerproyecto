package com.utp.service;

/**
 *
 * @author Carla Abregù
 */
import com.utp.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;
@Path("/auth")
public class AuthService {
    private static final Map<String, User> users = new HashMap<>();
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        if (users.containsKey(user.getUsername())) {
            return Response.status(Response.Status.CONFLICT).entity("Usuario ya existe").build();
        }
        users.put(user.getUsername(), user);
        return Response.ok("Usuario registrado").build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        User found = users.get(user.getUsername());
        if (found != null && found.getPassword().equals(user.getPassword())) {
            return Response.ok("Usuario autenticado: " + found.getUsername() + " con rol " + found.getRole()).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales inválidas").build();
    }
}
