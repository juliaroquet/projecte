package edu.upc.dsa.services;

import edu.upc.dsa.UserManager;
import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

    @Api(value = "/user", description = "Endpoint to User Service")
    @Path("/user")
    public class UserService {

        private UserManager um;

        public UserService() {
            this.um = UserManagerImpl.getInstance();

        }

        @POST
        @ApiOperation(value = "User Registration", notes = "Registrem a un usuari")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "User register Successfull"),
                @ApiResponse(code = 404, message = "This username is already being used"),
                @ApiResponse(code = 500, message = "Error")

        })
        @Path("/register")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response Register(User user) {

            if (user.getName() == null || user.getSurname()==null || user.getPassword()== null || user.getUsername() == null)  return Response.status(500).entity(user).build();
            try{
                this.um.registerUser(user.getName(), user.getSurname(), user.getUsername(), user.getPassword());
                return Response.status(201).entity(user).build();

            }
            catch(UserNameYaExiste e){
                return Response.status(404).entity(user).build();
            }

        }

        @POST
        @ApiOperation(value = "User Log in", notes = "Fem login d'un usuari")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "User logg in Successfull"),
                @ApiResponse(code = 404, message = "The password is incorrect"),

        })
        @Path("/login")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response Login(User user) throws PasswordIncorrecteException, UserNotRegisteredException {

            User user1 = this.um.loginUser(user.getUsername(), user.getPassword());
            if(user1 != null){
                return Response.status(201).entity(user).build();
            }
            return Response.status(404).entity(user).build();
        }
    }
